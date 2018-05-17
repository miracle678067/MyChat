package com.test.controller;

import com.test.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author:陈浩杰
 * @description: 客户端页面的控制器
 * @Date:Created in 21:34 2018/5/11
 */
@Controller
@RequestMapping("/")
public class FrontMaintainController {
    @Autowired
    private QueryService queryService;
    @RequestMapping("/inittalk")
    public String initTalk(){
        return "talk";
    }

    @RequestMapping(value = "/AutoReply",produces = "application/json;charset=utf-8")
    @ResponseBody()
    public String autoReply(@RequestParam("content") String content){
        String rs = queryService.queryByCommand(content);
        System.out.println(rs);
        return rs;
    }
}
