package com.boot.tool;

import java.util.List;

public class Pagenatior<T> {
    private List<T> list;
    private int startIndex;
    private int endIndex;
    private int limit;


    public Pagenatior(List<T> list, int limit) {
        this.list = list;
        this.limit = limit;
    }

    public List<T> page(int page) {
        startIndex = (page - 1) * limit;
        List<T> con = (List<T>)list.get(0);
        endIndex = startIndex + Math.min(limit, con.size() - startIndex);
        return con.subList(startIndex, endIndex);
    }
}
