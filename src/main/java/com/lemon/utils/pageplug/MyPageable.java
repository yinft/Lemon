package com.lemon.utils.pageplug;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @Author: yinft
 * @Date: 2019/2/28 20:40
 * @Version 1.0
 */
public class MyPageable<T> extends Page{

    private T query;

    public T getQuery() {
        return query;
    }

    public void setQuery(T query) {
        this.query = query;
    }
}