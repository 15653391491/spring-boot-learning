package com.boot.tool;

import java.util.List;

public class Pagenatior {
    private List<Object> list;
    private int startIndex;
    private int endIndex;
    private int limit;

    public Pagenatior(List<Object> list, int limit) {
        this.list = list;
        this.limit = limit;
    }

    public List<Object> page(int page) {
        startIndex = (page - 1) * limit;
        List<Object> con = (List<Object>)list.get(0);
        endIndex = startIndex + Math.min(limit, con.size() - startIndex);
        return con.subList(startIndex, endIndex);
    }
}
