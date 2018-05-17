package com.test.service.impl;

import com.test.bean.Command;
import com.test.bean.CommandContent;
import com.test.bean.Message;
import com.test.dao.interfaceDao.CommandDao;
import com.test.dao.interfaceDao.MessageDao;
import com.test.entity.Page;
import com.test.service.QueryService;
import com.test.util.Iconst;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @Author:陈浩杰
 * @description: sad
 * @Date:Created in 22:12 2018/5/6
 */
@Service
public class QueryServiceImpl implements QueryService {
    @Autowired
    private MessageDao messageDao;
    @Autowired
    private CommandDao commandDao;
    @Override
    public List<Message> queryAllMessageList(String command,   String description ,Page page) {
       // List<Message> list = messageDao.queryAllMessageList(command,description);
        Message message = new Message();
        message.setCommand(command);
        message.setDescription(description);
        int totalNumber = messageDao.count(message);
        System.out.println("查询的条数"+totalNumber);
        page.setTotalNumber(totalNumber);
        page.count();
        Map<String,Object> map = new HashMap<>();
        map.put("message",message);
        map.put("page",page);
        System.out.println(messageDao);
        return messageDao.queryAllMessageList(map);
    }

    @Override
    public List<Message> queryAllMessageListByPage(String command, String description, Page page) {
        Map<String,Object> map = new HashMap<>();
        Message message = new Message();
        message.setCommand(command);
        message.setDescription(description);
        int totalNumber = messageDao.count(message);
        page.setTotalNumber(totalNumber);
        page.count();
        map.put("message",message);
        map.put("page",page);
        return messageDao.queryAllMessageListByPage(map);
    }

    @Override
    public Message selectOne(String id) {
        return messageDao.selectOne(Integer.parseInt(id));
    }

    @Override
    public String queryByCommand(String command) {
        List<Command> commandList;
        if (Iconst.HELP_COMMAND.equals(command)){
            commandList = commandDao.queryCommandList(null,null);
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < commandList.size(); i++) {
                if (i != 0){
                    result.append("<br/>");
                }
                result.append("回复[" + commandList.get(i).getName() + "]可以查看" + commandList.get(i).getDescription());
            }
            return result.toString();
        }
        commandList = commandDao.queryCommandList(command,null);
        System.out.println(commandList.size());
        if (commandList.size() > 0){
           List<CommandContent> contentList = commandList.get(0).getContentList();
           int i = new Random().nextInt(contentList.size());
            System.out.println("选择第" + i +"个   个数" + commandList.size());
           return contentList.get(i).getContent();
        }
        return Iconst.NO_MATCHING_CONTENT;
    }


}
