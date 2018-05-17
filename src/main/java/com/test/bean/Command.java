package com.test.bean;

import java.util.List;

/**
 * @Author:陈浩杰
 * @description: sad
 * @Date:Created in 22:46 2018/5/11
 */
public class Command {
    private String id;
    private String name;
    private String description;
    private List<CommandContent> contentList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CommandContent> getContentList() {
        return contentList;
    }

    public void setContentList(List<CommandContent> contentList) {
        this.contentList = contentList;
    }
}
