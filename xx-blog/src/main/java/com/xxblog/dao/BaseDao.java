package com.xxblog.dao;

import com.xxblog.exception.ServiceException;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 *     持久层基本接口,对于每一个Entity基本上都有此接口方法.
 * </pre>
 * Created by lifang on 2015/1/21.
 */
public abstract interface BaseDao<T, ID extends Serializable> {

    public abstract T findById(ID id);

    public abstract T findByName(String name) throws ServiceException;

    public abstract List<T> findAll();

    public abstract void persist(T t);

    public abstract T merge(T t);

    public abstract void remove(T t);

    public abstract List<T> findAllByName(String name);

}
