package com.test.dao.impl;

/**
 * @Author:陈浩杰
 * @description: sad
 * @Date:Created in 22:01 2018/5/6
 */

public class MessageDaoImpl  {
    /*@Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Message> queryAllMessageList(String command, String description) {
        String sql = "select id,command,description,content from message where 1 = 1";
        StringBuilder builder = new StringBuilder(sql);
        if (command != null && !"".equals(command.trim())) {
            builder.append(" and command='" + command+"'");
        }
        if (description != null && !"".equals(description.trim())) {
            builder.append(" and description like '%'" + description + "'%'");
        }
        //获取列表结果集，数据库字段和实体类字段自动对应
        Message message = new Message();
        List<Message> list = jdbcTemplate.query(builder.toString(),new BeanPropertyRowMapper<Message>(Message.class));
       *//* if (command == null && description == null) {
            List<Message> list = jdbcTemplate.query(builder.toString(), new BeanPropertyRowMapper<Message>(Message.class));
            return list;
        } else if (command != null && description == null) {
            List<Message> list = jdbcTemplate.query(builder.toString(), new BeanPropertyRowMapper<Message>(Message.class), message.getCommand());
            return list;
        } else if (command == null && description != null) {
            List<Message> list = jdbcTemplate.query(builder.toString(), new BeanPropertyRowMapper<Message>(Message.class), message.getDescription());
            return list;
        } else {
            List<Message> list = jdbcTemplate.query(builder.toString(), new BeanPropertyRowMapper<Message>(Message.class), message.getCommand(), message.getDescription());
            return list;
        }*//*
       return list;

    }*/
}
