package com.test.dao.interfaceDao;

import com.test.bean.Command;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author:陈浩杰
 * @description: sad
 * @Date:Created in 14:53 2018/5/12
 */
public interface CommandDao {
    List<Command> queryCommandList(@Param("name") String name, @Param("description") String description);
}
