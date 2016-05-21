package com.xxblog.entity;

import com.xxbase.entity.BaseEntity;
import org.hibernate.validator.constraints.Email;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by admin on 16/05/17.
 */
@Entity
@Table(name = "t_blog_account")
public class BlogAccountEntity extends BaseEntity{

    @Column(length = 64)
    private String name;

    @Column(length = 64)
    private String password;

    @Email
    @Column(length = 64)
    public String email;

    @Column(length = 64)
    public String avatar;//头像

    public BlogAccountEntity(){}

    public BlogAccountEntity(String name, String password, String email, String avatar) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
