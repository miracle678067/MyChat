package com.test.dao.interfaceDao;

import com.test.bean.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author:陈浩杰
 * @description: 注意：接口中的方法隐含都是public和abstract的
 * @Date:Created in 21:54 2018/5/6
 */
public interface MessageDao {
    /**
     * @param command @param表示给参数命名,名称就是括号中的内容
     * @param description
     * @return
     */
    //List<Message> queryAllMessageList(@Param("command") String command, @Param("description") String description);

    /**
     * 根据查询条件查询消息列表
     * @param map
     * @return
     */
    List<Message> queryAllMessageList(Map<String,Object> map);

    /**
     * 使用代理进行分页
     * @param map
     * @return
     */
    List<Message> queryAllMessageListByPage(Map<String,Object> map);
    int count(Message message);
    //int count(@Param("command") String command,@Param("description") String description);
    /**
     * @param id 删除单条信息
     */
    void deleteOne(Integer id);
    /**
     * 查询单条信息
     */
    Message selectOne(Integer id);

    /**
     * 插入新的指令
     * @param message
     * @return
     */
    int insertList(Message message);

    /**
     * 修改指令
     * @param message
     */
    void updateCommand(Message message);

    /**
     * 批量删除
     * @param list
     */
    void deleteBatch(List<Integer> list);
}
