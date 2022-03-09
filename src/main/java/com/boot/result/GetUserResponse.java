package com.boot.result;

import com.boot.pojo.User;

import java.util.List;

public class GetUserResponse {
    private List<User> data;
    private Integer page;
    private Integer limit;
    private Integer count;

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "GetUserResponse{" +
                "data=" + data +
                ", page=" + page +
                ", limit=" + limit +
                ", count=" + count +
                '}';
    }


    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
