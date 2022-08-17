package com.baidu.incrm.onefrontnumber.intf.controller.audit;

import com.baidu.crm.lego.vo.ResultVO;
import com.baidu.incrm.onefrontnumber.domain.util.GsonUtils;
import com.baidu.incrm.onefrontnumber.entity.audit.DownloadCenterDTO;
import com.baidu.incrm.onefrontnumber.entity.audit.ParamDTO;
import com.baidu.incrm.onefrontnumber.intf.controller.base.ResponseController;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author kangjie02
 * @date 2021/12/9
 * @description
 */
@RestController
@RequestMapping("/numberAudit")
public class DownLoadController extends ResponseController implements ApplicationContextAware {
    private Logger logger = LoggerFactory.getLogger(DownLoadController.class);

    @RequestMapping(value = "/download")
    @ApiOperation(value = "下载中心回调接口", httpMethod = "POST")
    public ResultVO<Map> download(@RequestBody DownloadCenterDTO downloadCenterDto) throws Exception {

        logger.info("download callback interface with param:{}", GsonUtils.toJson(downloadCenterDto));

        try {
            Integer pageIndex = 1;
            if (StringUtils.isNotEmpty(downloadCenterDto.getPageIndex())) {
                pageIndex = Integer.parseInt(downloadCenterDto.getPageIndex());
            }
            Integer pageSize = 100;
            if (StringUtils.isNotEmpty(downloadCenterDto.getPageSize())) {
                pageSize = Integer.parseInt(downloadCenterDto.getPageSize());
            }

            String params = downloadCenterDto.getParams();
            ParamDTO paramDto = new ParamDTO();
            try {
                paramDto = GsonUtils.fromJson(params, ParamDTO.class);
            } catch (Exception e) {
                logger.error("params is not right" + e.getMessage(), e);
                throw new RuntimeException("params is not right!");
            }

            String completeServiceName = paramDto.getMethod();
            String serviceName = completeServiceName.split("\\.")[0];
            String methodName = completeServiceName.split("\\.")[1];

            Object bean = applicationContext.getBean(serviceName);
            Class serviceClass = bean.getClass();
            Method method = serviceClass.getMethod(methodName, String.class, Integer.class, Integer.class);

            Map<String, Object> data = (Map) method.invoke(bean,
                    GsonUtils.toJson(paramDto.getParam()), pageIndex, pageSize);
            logger.info("download callback interface success,{}", GsonUtils.toJson(data));
            // return this.success(data);
            return new ResultVO(200,
                    ResultVO.ResultEnum.RETURN_SUCC.getMsg(),
                    data);
        } catch (Exception e) {
            logger.error("download-error", e);
            return this.fail(e.getMessage());
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    private ApplicationContext applicationContext;
}
