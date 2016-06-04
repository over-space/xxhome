package com.xxblog.dao;

import com.xxbase.dao.BaseDaoImpl;
import com.xxblog.entity.BlogContentEntity;
import com.xxblog.entity.BlogGroupEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 16/05/16.
 */
@Repository
public class BlogContentDaoImpl extends BaseDaoImpl<BlogContentEntity, Long> implements BlogContentDao {
}
