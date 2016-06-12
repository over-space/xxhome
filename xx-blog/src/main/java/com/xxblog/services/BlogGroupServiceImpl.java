package com.xxblog.services;

import com.xxbase.dao.BaseDao;
import com.xxbase.method.XXPropertyPlaceholder;
import com.xxbase.services.BaseServiceImpl;
import com.xxbase.utils.XXSystemUtils;
import com.xxblog.dao.BlogGroupDao;
import com.xxblog.entity.BlogGroupEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by admin on 16/05/16.
 */
@Service
@Transactional(readOnly = true)
public class BlogGroupServiceImpl extends BaseServiceImpl<BlogGroupEntity, Long> implements BlogGroupService {

    @Autowired
    private BlogGroupDao blogGroupDao;

    @Override
    @Autowired
    public void setBaseDao(BaseDao<BlogGroupEntity, Long> baseDao) {
        super.setBaseDao(baseDao);
    }


    /**
     * 初始化博客分类列表
     */
    @Override
    @Transactional
    public void initBlogGroup() {
        String jsonString = XXPropertyPlaceholder.getProperty("blog.group.list");
        Collection<BlogGroupEntity> blogGroupEntityList = XXSystemUtils.jsonStringToArrObject(jsonString, BlogGroupEntity.class);
        blogGroupDao.persistAll(blogGroupEntityList);
    }
}
