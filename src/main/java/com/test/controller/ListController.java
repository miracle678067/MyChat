package com.test.controller;

import com.test.bean.Message;
import com.test.entity.Page;
import com.test.service.QueryService;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.regex.Pattern;

/**
 * @Author:陈浩杰
 * @description: sad
 * @Date:Created in 21:19 2018/5/6
 */
@Controller
@RequestMapping("/")
public class ListController {
    @Autowired
    private QueryService queryService;
    private Pattern pattern;

    @RequestMapping("/list")
    public ModelMap getList(@RequestParam(value = "command", required = false) String command, @RequestParam(value = "description", required = false) String description, @Param(value = "currentPage")String currentPage) {
        //创建分页对象
        Page page = new Page();
        //正则表达式校验，0-9最少出现一次，最多出现9次
        pattern = Pattern.compile("[0-9]{1,9}");
        //若不符合正则表达式校验规则，则从第一页开始查起
        if (currentPage == null || !pattern.matcher(currentPage).matches()){
            page.setCurrentPage(1);
        }else {
            page.setCurrentPage(Integer.valueOf(currentPage));
        }
        List<Message> list = queryService.queryAllMessageListByPage(command,description,page);
        System.out.println("总数目为："+list.size());
        /*ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("messageList", list);
        modelAndView.addObject("command",command);
        modelAndView.addObject("description",description);
        modelAndView.addObject("page",page);*/
        ModelMap map = new ModelMap();
        map.addAttribute("messageList",list);
        map.addAttribute("command",command);
        map.addAttribute("description",description);
        map.addAttribute("page",page);
        System.out.println(list.size() + "页数："+page.getTotalNumber() + " " + page.getPageNumber() + " " + page.getTotalPage());
        return map;
    }

}
