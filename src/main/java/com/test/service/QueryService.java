package com.test.service;

import com.test.bean.Command;
import com.test.bean.Message;
import com.test.entity.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:陈浩杰
 * @description: sad
 * @Date:Created in 22:10 2018/5/6
 */
public interface QueryService {
    List<Message> queryAllMessageList(String command, String description, Page page);
    List<Message> queryAllMessageListByPage(String command,String description,Page page);
    Message selectOne(String id);
    String queryByCommand(String command);
}
