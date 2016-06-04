package com.xxblog.services;

import com.xxbase.dao.BaseDao;
import com.xxbase.services.BaseServiceImpl;
import com.xxblog.dao.BlogGroupDao;
import com.xxblog.entity.BlogContentEntity;
import com.xxblog.entity.BlogGroupEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by admin on 16/05/16.
 */
@Service
@Transactional(readOnly = true)
public class BlogContentServiceImpl extends BaseServiceImpl<BlogContentEntity, Long> implements BlogContentService {

    @Autowired
    private BlogGroupDao blogGroupDao;

    @Override
    @Autowired
    public void setBaseDao(BaseDao<BlogContentEntity, Long> baseDao) {
        super.setBaseDao(baseDao);
    }

}
