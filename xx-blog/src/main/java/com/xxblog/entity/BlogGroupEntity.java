package com.xxblog.entity;

import com.xxbase.entity.BaseEntity;

import javax.persistence.*;

/**
 * 用户自定义分组
 * Created by admin on 16/06/04.
 */
@Entity
@Table(name = "t_blog_group")
public class BlogGroupEntity extends BaseEntity{

    @Column(length = 64)
    private String name;

    @Column(length = 120)
    private String description;

    @ManyToOne
    @JoinColumn(name = "fk_blog_account_id")
    private BlogAccountEntity blogAccountEntity;
}
