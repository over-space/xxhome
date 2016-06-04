package com.xxblog.services;

import com.xxbase.dao.BaseDao;
import com.xxbase.services.BaseServiceImpl;
import com.xxblog.dao.BlogCategoryDao;
import com.xxblog.entity.BlogCategoryEntity;
import com.xxblog.services.BlogCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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


    /**
     * 初始化博客分类列表
     */
    @Override
    @Transactional
    public void initBlogCategory() {
        String[] categoryNameArr = {"移动开发", "Web前端", "架构设计", "编程语言", "互联网", "数据库", "系统运维", "云计算", "研发管理", "综合"};
        for(String name : categoryNameArr){
            if(blogCategoryDao.findByName(name) != null) continue;
            BlogCategoryEntity blogCategoryEntity = new BlogCategoryEntity(name);
            blogCategoryDao.persist(blogCategoryEntity);
        }
    }
}
