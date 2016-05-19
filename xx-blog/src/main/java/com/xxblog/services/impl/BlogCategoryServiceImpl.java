package com.xxblog.services.impl;

import com.xxblog.dao.BaseDao;
import com.xxblog.dao.BlogCategoryDao;
import com.xxblog.entity.BlogCategoryEntity;
import com.xxblog.services.BlogCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by admin on 16/05/16.
 */
@Service
@Transactional(readOnly = true)
public class BlogCategoryServiceImpl extends BaseServiceImpl<BlogCategoryEntity, Long> implements BlogCategoryService{

    @Autowired
    private BlogCategoryDao blogCategoryDao;

    @Override
    @Autowired
    public void setBaseDao(BaseDao<BlogCategoryEntity, Long> baseDao) {
        super.setBaseDao(baseDao);
    }

}
