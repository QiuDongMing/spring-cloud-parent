package com.qdm.controller.param;

/**
 * @author qiudm
 * @date 2018/3/23 16:10
 * @desc 分页请求
 */
public class PageParam {

    private int pageNum = 1;

    private int pageSize = 15;

    public PageParam(){}

    public PageParam(int pageNum){
        this.pageNum = pageNum;
    }

    public PageParam(int pageNum, int pageSize){
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
