package com.itheima.ssm.domain;

import java.util.List;

/**
 * @version 1.0
 * @Author 李永
 * @company wwww.itcast.com
 * TODO
 * @Date 2019\1\1 0001
 **/
public class PageInfo<T> {

    private int pageNum;
    private int pageSize;
    private int pages;
    private List<T> list;
    private Long total;

    public PageInfo(int pageNum, int pageSize, int pages, List<T> list, Long total) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.pages = pages;
        this.list = list;
        this.total = total;
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

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
