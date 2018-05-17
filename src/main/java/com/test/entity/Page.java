package com.test.entity;

/**
 * @Author:陈浩杰
 * @description: 分页对应的实体类
 * @Date:Created in 20:23 2018/5/15
 */
public class Page {
    /**
     * 总条数
     */
    private int totalNumber;
    /**
     * 当前第几页
     */
    private int currentPage;
    /**
     * 总页数
     */
    private int totalPage;
    /**
     * 每页显示条数
     */
    private int pageNumber = 5;
    /**
     * 数据库中limit的参数，从第几条开始取
     */
    private int dbIndex;
    /**
     * 数据库中limit的参数，一共取多少条
     */
    private int dbNumber;
    /**
     * 根据当前对象中属性值计算并设置相关属性值
     */
    public void count(){
        int totalPageTemp = totalNumber / pageNumber;
        System.out.println("sas" + totalPageTemp + " " + totalNumber + " " + pageNumber);
        int plus = (totalNumber % pageNumber) == 0 ? 0 : 1;
        totalPageTemp = totalPageTemp + plus;
        if (totalPageTemp <= 0){
            totalPageTemp = 1;
        }
        totalPage = totalPageTemp;
        System.out.println("总页数：" + totalPage);
        /**
         * 设置当前页数，总页数小于当前页数，应将当前页数设置为总页数
         */
        if (totalPage < currentPage){
            currentPage = totalPage;
        }
        /**
         * 当前页数小于1设置为1
         */
        if (currentPage < 1){
            currentPage = 1;
        }
        dbIndex = (currentPage - 1) * pageNumber;
        dbNumber = pageNumber;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getDbIndex() {
        return dbIndex;
    }

    public void setDbIndex(int dbIndex) {
        this.dbIndex = dbIndex;
    }

    public int getDbNumber() {
        return dbNumber;
    }

    public void setDbNumber(int dbNumber) {
        this.dbNumber = dbNumber;
    }
}
