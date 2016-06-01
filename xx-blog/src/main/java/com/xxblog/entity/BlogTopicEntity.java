package com.xxblog.entity;

import com.xxbase.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * Created by admin on 16/05/17.
 */
@Entity
@Table(name = "t_blog_topic")
public class BlogTopicEntity extends BaseEntity {

    @Column(length = 64)
    private String name;

    @Lob
    private String content;

    //喜欢（顶）
    private int digger = 0;

    //讨厌（踩）
    private int bury = 0;

    //收藏
    private int collect = 0;

    //前一篇帖子
    @Column(length = 64)
    private String preTopic;

    //后一篇帖子
    @Column(length = 64)
    private String postTopic;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPreTopic() {
        return preTopic;
    }

    public void setPreTopic(String preTopic) {
        this.preTopic = preTopic;
    }

    public String getPostTopic() {
        return postTopic;
    }

    public void setPostTopic(String postTopic) {
        this.postTopic = postTopic;
    }
}
