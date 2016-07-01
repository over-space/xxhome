package com.xxblog.entity;

import com.xxbase.entity.BaseEntity;
import org.hibernate.annotations.Fetch;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.context.annotation.Lazy;
import org.springframework.util.StringUtils;

import javax.persistence.*;

/**
 * Created by admin on 16/05/17.
 */
@Entity
@Table(name = "t_blog_content")
public class BlogContentEntity extends BaseEntity {

    public enum Status{DEL, PUBLIC, DRAFT}

    @Column(length = 64)
    @NotBlank(message = "博客名称不允许为空")
    private String name;

    //博客内容
    @Lob
    @Lazy
    private String content;

    //内容简介
    @Column(length = 300)
    private String abstracts;

    //状态
    @Enumerated(EnumType.STRING)
    private Status status = Status.DRAFT;

    //博客标签
    @Column(length = 200)
    private String tags;

    //喜欢（顶）
    private int digger = 0;

    //讨厌（踩）
    private int bury = 0;

    //收藏
    private int collect = 0;

    //前一篇帖子
    @Column(length = 64)
    private String lastContent;

    //后一篇帖子
    @Column(length = 64)
    private String nextContent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getDigger() {
        return digger;
    }

    public void setDigger(int digger) {
        this.digger = digger;
    }

    public int getBury() {
        return bury;
    }

    public void setBury(int bury) {
        this.bury = bury;
    }

    public int getCollect() {
        return collect;
    }

    public void setCollect(int collect) {
        this.collect = collect;
    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getLastContent() {
        return lastContent;
    }

    public void setLastContent(String lastContent) {
        this.lastContent = lastContent;
    }

    public String getNextContent() {
        return nextContent;
    }

    public void setNextContent(String nextContent) {
        this.nextContent = nextContent;
    }

    public String getAbstracts() {
        return abstracts;
    }

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }
}
