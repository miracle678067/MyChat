package com.test.service.impl;

import com.test.bean.Message;
import com.test.dao.interfaceDao.MessageDao;
import com.test.service.MaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Service;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:陈浩杰
 * @description: sad
 * @Date:Created in 13:16 2018/5/9
 */
@Service
public class MaintainServiceImpl implements MaintainService {
    @Autowired
    private MessageDao messageDao;
    @Override
    public void deleteOne(String id) {
       /* if (id != null && !"".equals(id.trim())){
            messageDao.deleteOne(Integer.parseInt(id));
            System.out.println("Maintain:" + id);
        }*/
        if(id != null && !"".equals(id.trim())) {
            messageDao.deleteOne(Integer.valueOf(id));
        }

    }

    @Override
    public int insert(Message message,String command,String description,String content) {

        message.setCommand(command);
        message.setDescription(description);
        message.setContent(content);
        return messageDao.insertList(message);
    }

    @Override
    public void updateCommand(Message message,String id,String command, String description, String content) {
        message.setId(Integer.parseInt(id));
        message.setCommand(command);
        message.setDescription(description);
        message.setContent(content);
        messageDao.updateCommand(message);
    }

    @Override
    public void deleteBatch(String[] ids) {
        List<Integer> idList = new ArrayList<>();
        for (String id:ids){
            idList.add(Integer.valueOf(id));
        }
        messageDao.deleteBatch(idList);
    }
}
