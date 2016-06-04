package com.xxblog.services;

import com.xxbase.dao.BaseDao;
import com.xxbase.services.BaseServiceImpl;
import com.xxblog.dao.BlogAccountDao;
import com.xxblog.entity.BlogAccountEntity;
import com.xxblog.services.BlogAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by admin on 16/05/16.
 */
@Service
@Transactional(readOnly = true)
public class BlogAccountServiceImpl extends BaseServiceImpl<BlogAccountEntity, Long> implements BlogAccountService {

    @Autowired
    private BlogAccountDao blogAccountDao;

    @Override
    @Autowired
    public void setBaseDao(BaseDao<BlogAccountEntity, Long> baseDao) {
        super.setBaseDao(baseDao);
    }

    @Override
    public BlogAccountEntity findByEmail(String email) {
        return blogAccountDao.findByEmail(email);
    }
}
