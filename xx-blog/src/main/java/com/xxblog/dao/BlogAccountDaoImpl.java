package com.xxblog.dao;

import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.PathBuilder;
import com.xxbase.dao.BaseDaoImpl;
import com.xxblog.entity.BlogAccountEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 16/05/16.
 */
@Repository
public class BlogAccountDaoImpl extends BaseDaoImpl<BlogAccountEntity, Long> implements BlogAccountDao {


    public BlogAccountEntity findByEmail(String email) {
        PathBuilder<BlogAccountEntity> pathBuilder = new PathBuilder<>(BlogAccountEntity.class, "o");
        JPAQuery jpaQuery = new JPAQuery(entityManager);
        return jpaQuery.from(pathBuilder).where(pathBuilder.getString("email").eq(email)).singleResult(pathBuilder);
    }

}
