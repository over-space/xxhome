package com.xxbase.services;


import com.xxbase.common.Page;
import com.xxbase.common.Pageable;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by lifang on 2015/1/22.
 */
public abstract interface BaseService<T, ID extends Serializable> {

    T findById(ID id);

    T findByName(String name);

    List<T> findAll();

    Page<T> findPage(Pageable pageable);

    void persist(T t);

    void persist(Collection<T> t);

    T merge(T t);

    void remove(T t);

    void remove(ID id);

    void clear();

    List<T> findAllByName(String name);

}
