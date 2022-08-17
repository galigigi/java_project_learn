package com.baidu.incrm.onefrontnumber.intf.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baidu.incrm.onefrontnumber.enums.AuditProcessEnum;
import com.baidu.incrm.onefrontnumber.service.alioth.AliothService;

@RequestMapping(value = "/test")
@RestController
public class TestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @Autowired
    AliothService aliothService;

    @RequestMapping("/hello")
    public String hello() {
        LOGGER.info("hello start ...");
        return "hello world";
    }

    @GetMapping("sendHi")
    public String sendHi(@RequestParam("email") String email) {
        LOGGER.info("email:{}", email);
        aliothService.sendNumberAuditToHi("魏皓测试客户名称",
                "20210823103", new Date(), email, AuditProcessEnum.SUBMIT, null);
        aliothService.sendNumberAuditToHi("魏皓测试客户名称",
                "20210823103", new Date(), email, AuditProcessEnum.APPROVE, null);
        aliothService.sendNumberAuditToHi("魏皓测试客户名称",
                "20210823103", new Date(), email, AuditProcessEnum.REJECT, "驳回原因");
        aliothService.sendNumberAuditToHi("魏皓测试客户名称",
                "010-7723131", new Date(), email, AuditProcessEnum.SUBMIT, null);
        return "success";
    }
}