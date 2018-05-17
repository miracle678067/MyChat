package com.test.service;

import com.test.bean.Message;

import java.util.List;

/**
 * @Author:陈浩杰
 * @description: sad
 * @Date:Created in 13:15 2018/5/9
 */
public interface MaintainService {
    void deleteOne(String id);

    int insert(Message message, String command, String description, String content);

    void updateCommand(Message message,String id,String command, String description, String content);

    void deleteBatch(String[] ids);
}
