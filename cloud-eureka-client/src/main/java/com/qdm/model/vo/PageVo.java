package com.qdm.model.vo;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * @author qiudm
 * @date 2018/3/23 15:45
 * @desc
 */
public class PageVo<T> {
    /**
     * 总页数
     */
    private int pageCount;
    /**
     * 每页显示的数据条数
     */
    private int pageSize = 15;
    /**
     * 页码
     */
    private int pageNum = 1;
    /**
     * 开始
     */
    private int start;
    /**
     * 总记录数
     */
    private long total;

    /**
     * 页数据
     */
    private List<T> pageData;

    public PageVo(int pageNum, long total) {
        this.pageNum = pageNum;
        this.total = total;
        init();
    }

    public PageVo(int pageNum, int pageSize, long total) {
        if (pageNum > 0) {
            this.pageNum = pageNum;
        }

        if (pageSize > 0) {
            this.pageSize = pageSize;
        }
        this.total = total;
        init();
    }


    private void init() {
        this.start = (pageNum - 1) * pageSize;
        this.pageCount = (int)(total + pageSize - 1) / pageSize;
    }


    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public List<T> getPageData() {
        return pageData;
    }

    public void setPageData(List<T> pageData) {
        this.pageData = pageData;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public static void main(String[] args) {
        PageVo pageVo = new PageVo(3,61);
        System.out.println("pageVo = " + JSON.toJSONString(pageVo));
    }

}
