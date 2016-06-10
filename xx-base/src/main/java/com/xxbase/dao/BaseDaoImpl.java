package com.xxbase.dao;

import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.PathBuilder;
import com.xxbase.dao.BaseDao;
import com.xxbase.exception.ServiceException;
import com.xxbase.utils.XXStringUtils;
import org.springframework.cache.annotation.CacheEvict;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

/**
 * Created by lifang on 2015/1/22.
 */
public abstract class BaseDaoImpl<T, ID extends Serializable> implements BaseDao<T, ID> {

    @PersistenceContext
    public EntityManager entityManager;

    private Class<T> clazz = null;

    public Map<String, Boolean> fieldNames = new HashMap<String, Boolean>();

    private static final String FIELD_NAME = "name";
    private static final String FIELD_ISENABLED = "isEnabled";

    public BaseDaoImpl() {
        Type type = getClass().getGenericSuperclass();
        Type[] arrayType = ((ParameterizedType) type).getActualTypeArguments();
        clazz = (Class) arrayType[0];
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            fieldNames.put(field.getName(), true);
        }
    }

    @Override
    public T findById(ID id) {
        return entityManager.find(clazz, id);
    }

    @Override
    public T findByName(String name) throws ServiceException {
        PathBuilder<T> pathBuilder = new PathBuilder<T>(clazz, "o");
        JPAQuery jpaQuery = new JPAQuery(entityManager);
        if (fieldNames.get(FIELD_NAME) != null) {
            return jpaQuery.from(pathBuilder).where(pathBuilder.getString(FIELD_NAME).eq(name)).singleResult(pathBuilder);
        }
        return null;
    }

    @Override
    public List<T> findAll() {
        PathBuilder<T> pathBuilder = new PathBuilder<T>(clazz, "o");
        JPAQuery jpaQuery = new JPAQuery(entityManager);
        if (fieldNames.get(FIELD_ISENABLED) != null) {
            return jpaQuery.from(pathBuilder).where(pathBuilder.getBoolean(FIELD_ISENABLED).eq(true)).list(pathBuilder);
        }
        return jpaQuery.from(pathBuilder).list(pathBuilder);
    }

    @Override
    public List<T> findAllByName(String name) {
        PathBuilder<T> pathBuilder = new PathBuilder<T>(clazz, "o");
        JPAQuery jpaQuery = new JPAQuery(entityManager);
        if (fieldNames.get(FIELD_ISENABLED) != null) {
            return jpaQuery.from(pathBuilder).where(pathBuilder.getString(FIELD_NAME).eq(name)).list(pathBuilder);
        }
        return new LinkedList<T>();
    }

    @Override
    public void persist(T t) {
        entityManager.persist(t);
    }

    @Override
    public void persistAll(Collection<T> coll) {
        if(XXStringUtils.isEmpty(coll)) return;
        for(T t : coll) persist(t);
    }

    @Override
    public T merge(T t) {
        entityManager.merge(t);
        return t;
    }

    @Override
    public void remove(T t) {
        entityManager.remove(t);
    }

    @Override
    public void clear() {
        String sql = "delete from " + clazz.getSimpleName();

        entityManager.createQuery(sql).executeUpdate();
    }
}
