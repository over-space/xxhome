package com.xxbase.vo;

import java.io.Serializable;

/**
 * Created by admin on 16/06/20.
 */
public class SimpleDataVO implements Serializable{

    private String id;

    private String name;

    private int sort = 0;

    public SimpleDataVO(String id, String name){
        this.id = id;
        this.name = name;
    }

    public SimpleDataVO(String id, String name, int sort){
        this.id = id;
        this.name = name;
        this.sort = sort;
    }

    public SimpleDataVO(long id, String name, int sort){
        this.id = id + "";
        this.name = name;
        this.sort = sort;
    }

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

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
