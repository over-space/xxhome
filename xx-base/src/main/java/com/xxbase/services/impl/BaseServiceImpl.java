package com.xxbase.services.impl;

import com.xxbase.dao.BaseDao;
import com.xxbase.services.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by lifang on 2015/1/22.
 */
public class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID> {

    public Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);

    private BaseDao<T, ID> baseDao;

    public void setBaseDao(BaseDao<T, ID> baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    @Transactional(readOnly = true)
    public T findById(ID id) {
        if (id != null) {
            return baseDao.findById(id);
        }
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public T findByName(String name) {
        try {
            return baseDao.findByName(name);
        } catch (Exception e) {
            logger.warn(e.getMessage());
        }
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findAll() {
        return baseDao.findAll();
    }

    @Override
    @Transactional
    public void persist(T t) {
        if (t != null) {
            baseDao.persist(t);
        }
    }

    @Override
    @Transactional
    public void persist(Collection<T> t) {
        if (CollectionUtils.isEmpty(t)) return;
        for (T e : t) {
            persist(e);
        }
    }

    @Override
    @Transactional
    public T merge(T t) {
        if (t != null) {
            return baseDao.merge(t);
        }
        return t;
    }

    @Override
    @Transactional
    public void remove(T t) {
        if (t != null) {
            baseDao.remove(t);
        }
    }

    @Transactional
    public void remove(ID id) {
        if (id != null) {
            T t = findById(id);
            if (t != null) {
                baseDao.remove(t);
            }
        }
    }

    @Override
    public List<T> findAllByName(String name) {
        return findAllByName(name);
    }
}
