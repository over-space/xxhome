package com.xxblog.entity;

import com.xxbase.entity.BaseEntity;
import org.hibernate.annotations.Fetch;
import org.springframework.context.annotation.Lazy;
import org.springframework.util.StringUtils;

import javax.persistence.*;

/**
 * Created by admin on 16/05/17.
 */
@Entity
@Table(name = "t_blog_content")
public class BlogContentEntity extends BaseEntity {

    @Column(length = 64)
    private String name;

    @Lob
    @Lazy
    private String content;

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
    private String preTopic;

    //后一篇帖子
    @Column(length = 64)
    private String postTopic;


    @Transient
    public String summary;

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

    public String getSummary() {
        return org.apache.commons.lang3.StringUtils.substring(this.content, 0, 270);
    }
}
