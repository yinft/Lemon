package com.lemon.domain.dto;

/**
 * 分页请求参数
 *
 * @author earthchen
 * @date 2018/9/6
 **/
public class PageParamDTO
{

    private Integer size = 10;

    private Integer page = 0;

    private Boolean isAsc;


    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }




    public Boolean getAsc() {
        return isAsc;
    }


    public void setAsc(Boolean asc) {
        isAsc = asc;
    }


    @Override
    public String toString() {
        return "PageParamDTO{" +
                "size=" + size +
                ", page=" + page +
                ", isAsc=" + isAsc +
                '}';
    }
}
