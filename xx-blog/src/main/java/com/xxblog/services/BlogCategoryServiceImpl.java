package com.xxblog.services;

import com.xxbase.dao.BaseDao;
import com.xxbase.method.XXPropertyPlaceholder;
import com.xxbase.services.BaseServiceImpl;
import com.xxbase.utils.XXSystemUtils;
import com.xxblog.dao.BlogCategoryDao;
import com.xxblog.entity.BlogCategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * Created by admin on 16/05/16.
 */
@Service
@Transactional(readOnly = true)
public class BlogCategoryServiceImpl extends BaseServiceImpl<BlogCategoryEntity, Long> implements BlogCategoryService {

    @Autowired
    private BlogCategoryDao blogCategoryDao;

    @Override
    @Autowired
    public void setBaseDao(BaseDao<BlogCategoryEntity, Long> baseDao) {
        super.setBaseDao(baseDao);
    }


    @Override
    @Cacheable(value = "blogCategoryListCache")
    public List<BlogCategoryEntity> findAll() {
        return super.findAll();
    }

    /**
     * 初始化博客分类列表
     */
    @Override
    @Transactional
    public void initBlogCategory() {
        String jsonString = XXPropertyPlaceholder.getProperty("blog.category.list");
        Collection<BlogCategoryEntity> blogCategoryEntityList = XXSystemUtils.jsonStringToArrObject(jsonString, BlogCategoryEntity.class);
        blogCategoryDao.persistAll(blogCategoryEntityList);
    }
}
