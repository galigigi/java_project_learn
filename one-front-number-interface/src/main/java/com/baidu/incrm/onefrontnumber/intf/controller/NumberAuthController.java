package com.baidu.incrm.onefrontnumber.intf.controller;

import com.baidu.crm.jsonutils.JsonUtilsForGoogle;
import com.baidu.crm.lego.BaseController;
import com.baidu.crm.lego.vo.ResultVO;
import com.baidu.incrm.onefrontnumber.app.service.NumberAuthHandleService;
import com.baidu.incrm.onefrontnumber.entity.audit.Prove;
import com.baidu.incrm.onefrontnumber.sdk.dto.BanNumberDetails;
import com.baidu.incrm.onefrontnumber.domain.util.UserInfoUtil;
import com.baidu.incrm.onefrontnumber.sdk.query.NumberAuditApplyQuery;
import com.baidu.incrm.onefrontnumber.sdk.query.NumberAuditGodQuery;
import com.baidu.incrm.onefrontnumber.sdk.query.NumberAuditQuery;
import com.baidu.incrm.polaris.annotations.GatewayRegisty;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("/number")
public class NumberAuthController extends BaseController {

    @Autowired
    private NumberAuthHandleService numberAuthHandleService;

    @PostMapping("/auth/deals")
    @GatewayRegisty
    public ResultVO<BanNumberDetails> getNumberAuthDeals(@RequestBody NumberAuditQuery numberAuditQuery) {
        final Long ucId = UserInfoUtil.getCurrentUserId();
        final Long currentPosId = UserInfoUtil.getCurrentPosId();
        try {
            numberAuditQuery.setUcId(ucId);
            numberAuditQuery.setPosId(currentPosId);
            log.info("NumberAuthController-getNumberAuthDeals numberAuditQuery:{}",
                    JsonUtilsForGoogle.toJson(numberAuditQuery));
            if (StringUtils.isEmpty(numberAuditQuery.getCustName()) || null == numberAuditQuery.getCustId()){
                return this.fail("客户信息错误");
            }
            return this.success(numberAuthHandleService.getBanNumberDetails(numberAuditQuery));
        } catch (Exception e) {
            log.error("NumberAuthController-getNumberAuthDeals numberAuditQuery{}:"
                    , JsonUtilsForGoogle.toJson(numberAuditQuery), e);
            return this.fail("获取黑名单信息失败: " + e.getMessage());
        }
    }

    @PostMapping("/auth/god/apply")
    @GatewayRegisty
    public ResultVO<Boolean> authGodApply(@RequestBody NumberAuditGodQuery numberAuditGodQuery) {
        try {
            final Long ucId = UserInfoUtil.getCurrentUserId();
            final Long currentPosId = UserInfoUtil.getCurrentPosId();
            numberAuditGodQuery.setUcId(ucId);
            numberAuditGodQuery.setPosId(currentPosId);
            log.info("NumberAuthController-authGodApply numberAuditQuery:{}",
                    JsonUtilsForGoogle.toJson(numberAuditGodQuery));
            return this.success(numberAuthHandleService.authGodApply(numberAuditGodQuery));
        } catch (Exception e) {
            log.error("NumberAuthController-authGodApply numberAuditQuery{}:"
                    , JsonUtilsForGoogle.toJson(numberAuditGodQuery), e);
            return this.fail("提交审核任务失败: " + e.getMessage());
        }
    }

    @PostMapping("/auth/apply")
    @GatewayRegisty
    public ResultVO<Boolean> applyNumberAuth(@RequestBody NumberAuditApplyQuery numberAuditApplyQuery) {
        try {
            log.info("NumberAuthController-applyNumberAuth numberAuditApplyQuery:{}",
                    JsonUtilsForGoogle.toJson(numberAuditApplyQuery));
            numberAuditApplyQuery.getProves().forEach(ss -> StringEscapeUtils.unescapeJava(ss.getUrl()));
            return this.success(numberAuthHandleService.applyNumberAuth(numberAuditApplyQuery));
        } catch (Exception e) {
            log.error("NumberAuthController-applyNumberAuth numberAuditApplyQuery{}:"
                    , JsonUtilsForGoogle.toJson(numberAuditApplyQuery), e);
            return this.fail("提交审核任务失败: " + e.getMessage());
        }
    }

    @PostMapping("/upload/proves")
    @GatewayRegisty
    public ResultVO<Prove> uploadProves(MultipartFile file) {
        if (file == null) {
            return this.fail("请选择文件");
        }
        String fileName = file.getOriginalFilename();
        log.info("NumberAuthController-uploadProves fileName:{}", fileName);
        String url = numberAuthHandleService.uploadFile(file);
        if (url == null) {
            return this.fail("上传失败");
        }
        Prove prove = new Prove();
        prove.setName(fileName);
        prove.setUrl(url);
        return this.success(prove);
    }
}
