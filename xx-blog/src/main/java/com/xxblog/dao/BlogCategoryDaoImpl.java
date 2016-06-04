package com.xxblog.dao;

import com.xxbase.dao.BaseDaoImpl;
import com.xxblog.entity.BlogCategoryEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 16/05/16.
 */
@Repository
public class BlogCategoryDaoImpl extends BaseDaoImpl<BlogCategoryEntity, Long> implements BlogCategoryDao {
}
