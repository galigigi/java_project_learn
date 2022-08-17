package com.baidu.incrm.onefrontnumber.intf.controller.audit;

import com.baidu.crm.jsonutils.JsonUtilsForGoogle;
import com.baidu.crm.lego.BaseController;
import com.baidu.crm.lego.vo.ResultVO;
import com.baidu.incrm.onefrontnumber.app.convertor.audit.NumberAuditConvertor;
import com.baidu.incrm.onefrontnumber.app.dto.audit.NumberAuditListInitDTO;
import com.baidu.incrm.onefrontnumber.app.dto.audit.NumberAuditNoticeDTO;
import com.baidu.incrm.onefrontnumber.app.dto.audit.NumberAuditRecordingDTO;
import com.baidu.incrm.onefrontnumber.app.dto.audit.NumberAuditSubmitDTO;
import com.baidu.incrm.onefrontnumber.enums.AuditProcessEnum;
import com.baidu.incrm.onefrontnumber.enums.AuditResultEnum;
import com.baidu.incrm.onefrontnumber.enums.AuditStatusEnum;
import com.baidu.incrm.onefrontnumber.enums.BanReasonEnum;
import com.baidu.incrm.onefrontnumber.enums.RejectReasonEnum;
import com.baidu.incrm.onefrontnumber.domain.util.UserInfoUtil;
import com.baidu.incrm.onefrontnumber.entity.acs.Position;
import com.baidu.incrm.onefrontnumber.entity.audit.NumberAuditDetail;
import com.baidu.incrm.onefrontnumber.entity.audit.NumberAuditSubmit;
import com.baidu.incrm.onefrontnumber.entity.audit.PaginationDTO;
import com.baidu.incrm.onefrontnumber.entity.yunyin.BlackUnbanEntity;
import com.baidu.incrm.onefrontnumber.app.dto.audit.NumberAuditDetailRespDTO;
import com.baidu.incrm.onefrontnumber.sdk.dto.NumberAuditListQry;
import com.baidu.incrm.onefrontnumber.entity.audit.NumberAuditList;
import com.baidu.incrm.onefrontnumber.entity.audit.NumberAuditParam;
import com.baidu.incrm.onefrontnumber.sdk.dto.NumberAuditResDTO;
import com.baidu.incrm.onefrontnumber.service.acs.AcsService;
import com.baidu.incrm.onefrontnumber.service.alioth.AliothService;
import com.baidu.incrm.onefrontnumber.service.audit.NumberAuditService;
import com.baidu.incrm.polaris.annotations.GatewayRegisty;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author kangjie02
 * @date 2021/8/14
 * @description 防骚扰审核记录
 */
@Slf4j
@RestController
@RequestMapping("/numberAudit")
public class NumberAuditController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(NumberAuditController.class);

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private AcsService acsService;

    @Autowired
    private NumberAuditService numberAuditService;

    @Autowired
    private AliothService aliothService;


    /**
     * 防骚扰解禁审核列表初始化
     */
    @PostMapping("/init")
    @GatewayRegisty
    public ResultVO<NumberAuditListInitDTO> init() {
        NumberAuditListInitDTO result = new NumberAuditListInitDTO();
        Long posId = UserInfoUtil.getCurrentPosId();
        List<Position> positionList = new ArrayList<>();
        try {
            positionList = acsService.getManagedPositionTreeWithControl(posId);
        } catch (Exception e) {
            logger.error("NumberAuditController-init-"
                    + "getManagedPositionTreeWithControl-error, posId:{}", posId, e);
        }
        result.setPosIdList(positionList);
        result.setAuditStatus(AuditStatusEnum.getAllMap());
        result.setAuditResult(AuditResultEnum.getAllMap());
        result.setBanReason(BanReasonEnum.getAllMap());
        result.setRejectReason(RejectReasonEnum.getAllMap());

        return this.success(result);
    }

    /**
     * 防骚扰解禁审核列表查询
     */
    @PostMapping("/queryList")
    @GatewayRegisty
    public ResultVO<PaginationDTO<List<NumberAuditResDTO>>> queryList(
            @RequestBody NumberAuditListQry numberAuditListQry) {
        logger.info("NumberAuditController-queryList-NumberAuditListQry:{}",
                JsonUtilsForGoogle.toJson(numberAuditListQry));
        StopWatch stopWatch = StopWatch.createStarted();
        PaginationDTO<List<NumberAuditResDTO>> result = new PaginationDTO<>();
        result.setPageNum(Long.valueOf(numberAuditListQry.getPageNum()));
        result.setPageSize(Long.valueOf(numberAuditListQry.getPageSize()));
        List<NumberAuditResDTO> responseDTOList = Lists.newArrayList();
        try {
            NumberAuditParam numberAuditParam = NumberAuditConvertor.INSTANCE.toNumberAuditParam(numberAuditListQry);
            NumberAuditList numberAuditList = numberAuditService.queryList(numberAuditParam);
            logger.info("NumberAuditController-queryList-: numberAuditList{}",
                    JsonUtilsForGoogle.toJson(numberAuditList));
            result.setTotalNum(numberAuditList.getTotalNum());
            responseDTOList = NumberAuditConvertor.INSTANCE.toNumberAuditResDTOList(
                    numberAuditList.getNumberAuditList());
            logger.info("NumberAuditController-queryList-NumberAuditResDTOList: {}",
                    JsonUtilsForGoogle.toJson(responseDTOList));
            result.setResult(responseDTOList);
            stopWatch.stop();
            logger.info("NumberAuditController-queryList,cost: {} ms", stopWatch.getTime());
            return this.success(result);
        } catch (Exception e) {
            logger.error("queryNumberAuditList error:", e);
            return this.fail("获取防骚扰审核列表失败:" + e.getMessage());
        }
    }

    /**
     * 防骚扰解禁审核列表查询
     */
    @GetMapping("/queryDetail")
    @GatewayRegisty
    public ResultVO<NumberAuditDetailRespDTO> queryDetail(@RequestParam("auditId") Long auditId) {
        logger.info("NumberAuditController-queryDetail-auditId:{}", auditId);
        StopWatch stopWatch = StopWatch.createStarted();
        NumberAuditDetailRespDTO result;
        try {
            if (null == auditId || auditId == 0) {
                logger.error("request param auditId is null");
                return this.fail("请求参数auditId不能为空");
            }
            NumberAuditDetail numberAuditDetail = numberAuditService.queryDetail(auditId);
            logger.info("NumberAuditController-queryDetail-: numberAuditDetail{}",
                    JsonUtilsForGoogle.toJson(numberAuditDetail));
            result = NumberAuditConvertor.INSTANCE.toNumberAuditDetailRespDTO(numberAuditDetail);
            logger.info("NumberAuditController-queryDetail-: NumberAuditDetailRespDTO{}",
                    JsonUtilsForGoogle.toJson(result));
            stopWatch.stop();
            logger.info("NumberAuditController-queryDetail,cost: {} ms", stopWatch.getTime());
        } catch (Exception e) {
            logger.error("queryNumberAuditDetail error:", e);
            return this.fail("获取防骚扰审核详情失败:" + e.getMessage());
        }
        return this.success(result);
    }

    /**
     * 防骚扰解禁审核详情录音
     */
    @GetMapping("/getRecording")
    @GatewayRegisty
    public ResultVO<NumberAuditRecordingDTO> getRecording(@RequestParam("callId") String callId) {
        logger.info("NumberAuditController-getRecording-callId:{}", callId);
        StopWatch stopWatch = StopWatch.createStarted();
        NumberAuditRecordingDTO result = new NumberAuditRecordingDTO();
        try {
            BlackUnbanEntity blackUnbanEntity = numberAuditService.queryRecording(callId);
            if (Objects.nonNull(blackUnbanEntity)) {
                result = NumberAuditConvertor.INSTANCE.toNumberAuditRecordingDTO(blackUnbanEntity);
            }
        } catch (Exception e) {
            logger.error("queryNumberAuditDetail error:", e);
            return this.fail("获取防骚扰审核详情录音失败:" + e.getMessage());
        }
        return this.success(result);
    }

    /**
     * 防骚扰解禁审核操作
     */
    @PostMapping("/audit")
    @GatewayRegisty
    public ResultVO audit(
            @RequestBody NumberAuditSubmitDTO numberAuditSubmitDTO) {
        String result = null;
        try {
            logger.info("NumberAuditController-audit:{}", JsonUtilsForGoogle.toJson(numberAuditSubmitDTO));
            if (null == numberAuditSubmitDTO || null == numberAuditSubmitDTO.getCustPhone()) {
                logger.error("request param custPhone is null");
                return this.fail("请求参数custPhone不能为空");
            }
            NumberAuditSubmit submit = NumberAuditConvertor.INSTANCE.toNumberAuditSubmit(numberAuditSubmitDTO);
            result = numberAuditService.submitAudit(submit);
        } catch (Exception ex) {
            logger.error("audit error:", ex);
            return this.fail("审核失败: " + ex.getMessage());
        }
        try {
            Date date = simpleDateFormat.parse(numberAuditSubmitDTO.getSubmitTime());
            StringBuffer rejectReason = new StringBuffer();
            if (CollectionUtils.isNotEmpty(numberAuditSubmitDTO.getRejectReason())) {
                for (Integer reason : numberAuditSubmitDTO.getRejectReason()) {
                    rejectReason.append(RejectReasonEnum.getEnumByCode(reason).getMsg() + ";");
                }
                rejectReason.deleteCharAt(rejectReason.length() - 1);
            }
            aliothService.sendNumberAuditToHi(numberAuditSubmitDTO.getCustName(),
                    numberAuditSubmitDTO.getCustPhone(), date, numberAuditSubmitDTO.getSubmitEmail(),
                    AuditProcessEnum.getEnumByCode(numberAuditSubmitDTO.getType()), rejectReason.toString());
        } catch (Exception ex) {
            logger.error("notice error:", ex);
            return this.fail("通知失败: " + ex.getMessage());
        }
        if (Objects.nonNull(result)) {
            return this.paramError(result);
        }
        return this.success();
    }

    /**
     * 防骚扰审核通知
     */
    @PostMapping("/notice")
    @GatewayRegisty
    public ResultVO notice(@RequestBody NumberAuditNoticeDTO numberAuditNoticeDTO) {
        logger.info("NumberAuditController-notice:{}", JsonUtilsForGoogle.toJson(numberAuditNoticeDTO));

        try {
            if (null == numberAuditNoticeDTO) {
                logger.error("request param is null");
                return this.fail("请求参数不能为空");
            }
            Date date = simpleDateFormat.parse(numberAuditNoticeDTO.getSubmitTime());
            StringBuffer rejectReason = new StringBuffer();
            if (CollectionUtils.isNotEmpty(numberAuditNoticeDTO.getRejectReason())) {
                for (Integer reason : numberAuditNoticeDTO.getRejectReason()) {
                    rejectReason.append(RejectReasonEnum.getEnumByCode(reason).getMsg() + ";");
                }
                rejectReason.deleteCharAt(rejectReason.length() - 1);
            }
            aliothService.sendNumberAuditToHi(numberAuditNoticeDTO.getCustName(),
                    numberAuditNoticeDTO.getCustPhone(), date, numberAuditNoticeDTO.getSubmitEmail(),
                    AuditProcessEnum.getEnumByCode(numberAuditNoticeDTO.getType()), rejectReason.toString());

        } catch (Exception ex) {
            logger.error("notice error:", ex);
            return this.fail("通知失败: " + ex.getMessage());
        }
        return this.success();
    }

    /**
     * 添加审核记录列表下载任务
     */
    @RequestMapping(value = "/downloadTask")
    @GatewayRegisty
    public ResultVO<Long> downloadTask(@RequestBody NumberAuditListQry numberAuditListQry) {
        Long taskId = 0L;
        try {
            NumberAuditParam numberAuditParam = NumberAuditConvertor.INSTANCE.toNumberAuditParam(numberAuditListQry);
            taskId = numberAuditService.downloadTask(numberAuditParam);
        } catch (Exception e) {
            logger.error("numberAuditDownloadTask error:", e);
            return this.fail("号码审核下载任务失败:" + e.getMessage());
        }
        return this.success(taskId);
    }
}
