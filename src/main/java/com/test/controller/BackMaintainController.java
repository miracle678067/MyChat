package com.test.controller;

import com.test.bean.Message;
import com.test.service.MaintainService;
import com.test.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author:陈浩杰
 * @description: 指令后台管理的控制器
 * @Date:Created in 13:20 2018/5/9
 */
@Controller
@RequestMapping("/")
public class BackMaintainController {
    @Autowired
    private MaintainService maintainService;
    @Autowired
    private QueryService queryService;

    /**
     * 删除单条信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public String delete(@RequestParam(value = "id", required = false) String id) {
        maintainService.deleteOne(id);
        return "list";
    }

    /**
     * 修改指令信息
     *
     * @return
     */
    @RequestMapping("/update")
    public String update(@RequestParam("id") String id, Model model) {
        Message message = queryService.selectOne(id);
        System.out.println(message.getContent());
        model.addAttribute("message", message);
        return "update";
    }

    /**
     * 返回修改结果
     * @param model
     * @param message
     * @param id
     * @param command
     * @param description
     * @param content
     * @return
     */
    @RequestMapping("/updateResult")
    public String updateResult(Model model, Message message, @RequestParam("id") String id, @RequestParam("command") String command, @RequestParam("description") String description, @RequestParam("content") String content) {
        try {
            maintainService.updateCommand(message, id, command, description, content);
            model.addAttribute("result","修改成功");
        } catch (Exception e) {

            model.addAttribute("result","修改失败" + e);
        }
        return "update";
    }

    @RequestMapping("/toAdd")
    public String add() {
        return "add";
    }

    /**
     * 添加新指令
     * @param model
     * @param message
     * @param command
     * @param description
     * @param content
     * @return
     */
    @RequestMapping("/addlist")
    public String insert(Model model, Message message, @RequestParam("command") String command, @RequestParam("description") String description, @RequestParam("content") String content) {
        int n = maintainService.insert(message, command, description, content);

        if (n == 1) {
            model.addAttribute("result", "添加成功");
        } else {
            model.addAttribute("result", "添加失败");
        }
        return "add";
    }
    @RequestMapping("/deleteBatch")
    public String deletePatch(@RequestParam("id") String[] ids){
        maintainService.deleteBatch(ids);
        return "forward:list";
    }
}
