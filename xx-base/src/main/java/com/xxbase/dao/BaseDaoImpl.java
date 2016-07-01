package com.xxbase.dao;

import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.PathBuilder;
import com.xxbase.common.Filter;
import com.xxbase.common.Order;
import com.xxbase.common.Page;
import com.xxbase.common.Pageable;
import com.xxbase.exception.ServiceException;
import com.xxbase.utils.XXSystemUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

/**
 * Created by lifang on 2015/1/22.
 */
public abstract class BaseDaoImpl<T, ID extends Serializable> implements BaseDao<T, ID> {

    private static volatile long aliasCount = 0;

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
    public Page<T> findPage(Pageable pageable) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
        criteriaQuery.select(criteriaQuery.from(clazz));
        return findPage(criteriaQuery, pageable);
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
        if (XXSystemUtils.isEmpty(coll)) return;
        for (T t : coll) persist(t);
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

    protected Page<T> findPage(CriteriaQuery<T> criteriaQuery, Pageable pageable) {
        Assert.notNull(criteriaQuery);
        Assert.notNull(criteriaQuery.getSelection());
        Assert.notEmpty(criteriaQuery.getRoots());

        if (pageable == null) {
            pageable = new Pageable();
        }
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        Root<T> root = getRoot(criteriaQuery);
        addRestrictions(criteriaQuery, pageable);
        addOrders(criteriaQuery, pageable);
//        if (criteriaQuery.getOrderList().isEmpty()) {
//            if (OrderEntity.class.isAssignableFrom(entityClass)) {
//                criteriaQuery.orderBy(criteriaBuilder.asc(root.get(OrderEntity.ORDER_PROPERTY_NAME)));
//            } else {
//                criteriaQuery.orderBy(criteriaBuilder.desc(root.get(OrderEntity.CREATE_DATE_PROPERTY_NAME)));
//            }
//        }
        long total = count(criteriaQuery, null);
        int totalPages = (int) Math.ceil((double) total / (double) pageable.getPageSize());
        if (totalPages < pageable.getPageNumber()) {
            pageable.setPageNumber(totalPages);
        }
        TypedQuery<T> query = entityManager.createQuery(criteriaQuery).setFlushMode(FlushModeType.COMMIT);
        query.setFirstResult((pageable.getPageNumber() - 1) * pageable.getPageSize());
        query.setMaxResults(pageable.getPageSize());
        return new Page<T>(query.getResultList(), total, pageable);
    }

    protected Long count(CriteriaQuery<T> criteriaQuery, List<Filter> filters) {
        Assert.notNull(criteriaQuery);
        Assert.notNull(criteriaQuery.getSelection());
        Assert.notEmpty(criteriaQuery.getRoots());

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        addRestrictions(criteriaQuery, filters);

        CriteriaQuery<Long> countCriteriaQuery = criteriaBuilder.createQuery(Long.class);
        for (Root<?> root : criteriaQuery.getRoots()) {
            Root<?> dest = countCriteriaQuery.from(root.getJavaType());
            dest.alias(getAlias(root));
            copyJoins(root, dest);
        }

        Root<?> countRoot = getRoot(countCriteriaQuery, criteriaQuery.getResultType());
        countCriteriaQuery.select(criteriaBuilder.count(countRoot));

        if (criteriaQuery.getGroupList() != null) {
            countCriteriaQuery.groupBy(criteriaQuery.getGroupList());
        }
        if (criteriaQuery.getGroupRestriction() != null) {
            countCriteriaQuery.having(criteriaQuery.getGroupRestriction());
        }
        if (criteriaQuery.getRestriction() != null) {
            countCriteriaQuery.where(criteriaQuery.getRestriction());
        }
        return entityManager.createQuery(countCriteriaQuery).setFlushMode(FlushModeType.COMMIT).getSingleResult();
    }

    private Root<T> getRoot(CriteriaQuery<T> criteriaQuery) {
        if (criteriaQuery != null) {
            return getRoot(criteriaQuery, criteriaQuery.getResultType());
        }
        return null;
    }

    private Root<T> getRoot(CriteriaQuery<?> criteriaQuery, Class<T> clazz) {
        if (criteriaQuery != null && criteriaQuery.getRoots() != null && clazz != null) {
            for (Root<?> root : criteriaQuery.getRoots()) {
                if (clazz.equals(root.getJavaType())) {
                    return (Root<T>) root.as(clazz);
                }
            }
        }
        return null;
    }

    private void addRestrictions(CriteriaQuery<T> criteriaQuery, List<Filter> filters) {
        if (criteriaQuery == null || filters == null || filters.isEmpty()) {
            return;
        }
        Root<T> root = getRoot(criteriaQuery);
        if (root == null) {
            return;
        }
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        Predicate restrictions = criteriaQuery.getRestriction() != null ? criteriaQuery.getRestriction() : criteriaBuilder.conjunction();
        for (Filter filter : filters) {
            if (filter == null || StringUtils.isEmpty(filter.getProperty())) {
                continue;
            }
            restrictions = getRestrictions(filter, criteriaBuilder, root, restrictions);
        }
        criteriaQuery.where(restrictions);
    }

    private void addRestrictions(CriteriaQuery<T> criteriaQuery, Pageable pageable) {
        if (criteriaQuery == null || pageable == null) {
            return;
        }
        Root<T> root = getRoot(criteriaQuery);
        if (root == null) {
            return;
        }
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        Predicate restrictions = criteriaQuery.getRestriction() != null ? criteriaQuery.getRestriction() : criteriaBuilder.conjunction();
        if (StringUtils.isNotEmpty(pageable.getSearchProperty()) && StringUtils.isNotEmpty(pageable.getSearchValue())) {
            restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.like(root.<String>get(pageable.getSearchProperty()), "%" + pageable.getSearchValue() + "%"));
        }
        if (pageable.getFilters() != null) {
            for (Filter filter : pageable.getFilters()) {
                if (filter == null || StringUtils.isEmpty(filter.getProperty())) {
                    continue;
                }
                restrictions = getRestrictions(filter, criteriaBuilder, root, restrictions);
            }
        }
        criteriaQuery.where(restrictions);
    }


    private Predicate getRestrictions(Filter filter, CriteriaBuilder criteriaBuilder, Root root, Predicate restrictions) {
        if (filter.getOperator() == Filter.Operator.eq && filter.getValue() != null) {
            if (filter.getIgnoreCase() != null && filter.getIgnoreCase() && filter.getValue() instanceof String) {
                restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.equal(criteriaBuilder.lower(root.<String>get(filter.getProperty())), ((String) filter.getValue()).toLowerCase()));
            } else {
                restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.equal(root.get(filter.getProperty()), filter.getValue()));
            }
        } else if (filter.getOperator() == Filter.Operator.ne && filter.getValue() != null) {
            if (filter.getIgnoreCase() != null && filter.getIgnoreCase() && filter.getValue() instanceof String) {
                restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.notEqual(criteriaBuilder.lower(root.<String>get(filter.getProperty())), ((String) filter.getValue()).toLowerCase()));
            } else {
                restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.notEqual(root.get(filter.getProperty()), filter.getValue()));
            }
        } else if (filter.getOperator() == Filter.Operator.gt && filter.getValue() != null) {
            restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.gt(root.<Number>get(filter.getProperty()), (Number) filter.getValue()));
        } else if (filter.getOperator() == Filter.Operator.lt && filter.getValue() != null) {
            restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.lt(root.<Number>get(filter.getProperty()), (Number) filter.getValue()));
        } else if (filter.getOperator() == Filter.Operator.ge && filter.getValue() != null) {
            restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.ge(root.<Number>get(filter.getProperty()), (Number) filter.getValue()));
        } else if (filter.getOperator() == Filter.Operator.le && filter.getValue() != null) {
            restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.le(root.<Number>get(filter.getProperty()), (Number) filter.getValue()));
        } else if (filter.getOperator() == Filter.Operator.like && filter.getValue() != null && filter.getValue() instanceof String) {
            restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.like(root.<String>get(filter.getProperty()), (String) filter.getValue()));
        } else if (filter.getOperator() == Filter.Operator.in && filter.getValue() != null) {
            restrictions = criteriaBuilder.and(restrictions, root.get(filter.getProperty()).in(filter.getValue()));
        } else if (filter.getOperator() == Filter.Operator.isNull) {
            restrictions = criteriaBuilder.and(restrictions, root.get(filter.getProperty()).isNull());
        } else if (filter.getOperator() == Filter.Operator.isNotNull) {
            restrictions = criteriaBuilder.and(restrictions, root.get(filter.getProperty()).isNotNull());
        }

        return restrictions;
    }


    private void addOrders(CriteriaQuery<T> criteriaQuery, List<Order> orders) {
        if (criteriaQuery == null || orders == null || orders.isEmpty()) {
            return;
        }
        Root<T> root = getRoot(criteriaQuery);
        if (root == null) {
            return;
        }
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        List<javax.persistence.criteria.Order> orderList = new ArrayList<javax.persistence.criteria.Order>();
        if (!criteriaQuery.getOrderList().isEmpty()) {
            orderList.addAll(criteriaQuery.getOrderList());
        }
        for (Order order : orders) {
            if (order.getDirection() == Order.Direction.asc) {
                orderList.add(criteriaBuilder.asc(root.get(order.getProperty())));
            } else if (order.getDirection() == Order.Direction.desc) {
                orderList.add(criteriaBuilder.desc(root.get(order.getProperty())));
            }
        }
        criteriaQuery.orderBy(orderList);
    }


    private void copyJoins(From<?, ?> from, From<?, ?> to) {
        for (Join<?, ?> join : from.getJoins()) {
            Join<?, ?> toJoin = to.join(join.getAttribute().getName(), join.getJoinType());
            toJoin.alias(getAlias(join));
            copyJoins(join, toJoin);
        }
        for (Fetch<?, ?> fetch : from.getFetches()) {
            Fetch<?, ?> toFetch = to.fetch(fetch.getAttribute().getName());
            copyFetches(fetch, toFetch);
        }
    }

    private void copyFetches(Fetch<?, ?> from, Fetch<?, ?> to) {
        for (Fetch<?, ?> fetch : from.getFetches()) {
            Fetch<?, ?> toFetch = to.fetch(fetch.getAttribute().getName());
            copyFetches(fetch, toFetch);
        }
    }

    private synchronized String getAlias(Selection<?> selection) {
        if (selection != null) {
            String alias = selection.getAlias();
            if (alias == null) {
                if (aliasCount >= 1000) {
                    aliasCount = 0;
                }
                alias = "o_" + aliasCount++;
                selection.alias(alias);
            }
            return alias;
        }
        return null;
    }

    private void addOrders(CriteriaQuery<T> criteriaQuery, Pageable pageable) {
        if (criteriaQuery == null || pageable == null) {
            return;
        }
        Root<T> root = getRoot(criteriaQuery);
        if (root == null) {
            return;
        }
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        List<javax.persistence.criteria.Order> orderList = new ArrayList<javax.persistence.criteria.Order>();
        if (!criteriaQuery.getOrderList().isEmpty()) {
            orderList.addAll(criteriaQuery.getOrderList());
        }
        if (StringUtils.isNotEmpty(pageable.getOrderProperty()) && pageable.getOrderDirection() != null) {
            if (pageable.getOrderDirection() == Order.Direction.asc) {
                orderList.add(criteriaBuilder.asc(root.get(pageable.getOrderProperty())));
            } else if (pageable.getOrderDirection() == Order.Direction.desc) {
                orderList.add(criteriaBuilder.desc(root.get(pageable.getOrderProperty())));
            }
        }
        if (pageable.getOrders() != null) {
            for (Order order : pageable.getOrders()) {
                if (order.getDirection() == Order.Direction.asc) {
                    orderList.add(criteriaBuilder.asc(root.get(order.getProperty())));
                } else if (order.getDirection() == Order.Direction.desc) {
                    orderList.add(criteriaBuilder.desc(root.get(order.getProperty())));
                }
            }
        }
        criteriaQuery.orderBy(orderList);
    }

}
