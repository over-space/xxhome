package com.xxbase.services;


import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by lifang on 2015/1/22.
 */
public abstract interface BaseService<T, ID extends Serializable> {

    public abstract T findById(ID id);

    public abstract T findByName(String name);

    public abstract List<T> findAll();

    public abstract void persist(T t);

    public abstract void persist(Collection<T> t);

    public abstract T merge(T t);

    public abstract void remove(T t);

    public abstract void remove(ID id);

    public abstract void clear();

    public abstract List<T> findAllByName(String name);

}
