package com.xxbase.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.xxbase.listerer.EntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by lifang on 2015/1/19.
 */
@MappedSuperclass
@EntityListeners(EntityListener.class)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class BaseEntity implements Serializable {

    @Id
    @TableGenerator(name = "GEN_INDEX", table = "t_generator",
            pkColumnName = "gen_key", valueColumnName = "gen_value",
            pkColumnValue = "id", allocationSize = 2, initialValue = 1000)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "GEN_INDEX")
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;//创建时间

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date modifyDate;//更新时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}
