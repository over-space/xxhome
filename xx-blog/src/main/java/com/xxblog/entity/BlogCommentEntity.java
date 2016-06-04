package com.xxblog.entity;

import com.xxbase.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by admin on 16/05/31.
 */
@Entity
@Table(name = "t_blog_comment")
public class BlogCommentEntity extends BaseEntity{

    @Column(length = 200)
    private String comment;

    @Temporal(TemporalType.TIMESTAMP)
    private Date commentTime;

    @ManyToOne
    @JoinColumn(name = "fk_blog_account_id")
    private BlogAccountEntity blogAccountEntity;

    @ManyToOne
    @JoinColumn(name = "fk_blog_content_id")
    private BlogContentEntity blogContentEntity;

    @OneToOne
    @JoinColumn(name = "fk_father_comment_id")
    private BlogCommentEntity blogCommentEntity;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public BlogAccountEntity getBlogAccountEntity() {
        return blogAccountEntity;
    }

    public void setBlogAccountEntity(BlogAccountEntity blogAccountEntity) {
        this.blogAccountEntity = blogAccountEntity;
    }

    public BlogContentEntity getBlogContentEntity() {
        return blogContentEntity;
    }

    public void setBlogContentEntity(BlogContentEntity blogContentEntity) {
        this.blogContentEntity = blogContentEntity;
    }

    public BlogCommentEntity getBlogCommentEntity() {
        return blogCommentEntity;
    }

    public void setBlogCommentEntity(BlogCommentEntity blogCommentEntity) {
        this.blogCommentEntity = blogCommentEntity;
    }
}
