package com.xxblog.dao;

import com.xxbase.dao.BaseDao;
import com.xxblog.entity.BlogAccountEntity;

/**
 * Created by admin on 16/05/21.
 */
public interface BlogAccountDao extends BaseDao<BlogAccountEntity, Long> {

    public BlogAccountEntity findByEmail(String email);

}
