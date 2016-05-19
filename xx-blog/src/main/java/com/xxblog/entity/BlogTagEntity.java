package com.xxblog.entity;

import com.xxbase.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by admin on 16/05/17.
 */
@Entity
@Table(name = "t_blog_tag")
public class BlogTagEntity extends BaseEntity{

    @Column(length = 64)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
