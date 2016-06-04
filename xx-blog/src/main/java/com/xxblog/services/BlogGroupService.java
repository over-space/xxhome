package com.xxblog.services;

import com.xxbase.services.BaseService;
import com.xxblog.entity.BlogCategoryEntity;
import com.xxblog.entity.BlogGroupEntity;

/**
 * Created by admin on 16/05/16.
 */
public interface BlogGroupService extends BaseService<BlogGroupEntity, Long> {


    /**
     * 初始化博客分类列表
     */
    public void initBlogGroup();

}
