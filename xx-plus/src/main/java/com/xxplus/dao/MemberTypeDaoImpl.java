package com.xxplus.dao;

import com.xxbase.dao.BaseDaoImpl;
import com.xxplus.dao.MemberTypeDao;
import com.xxplus.entity.MemberTypeEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by lifang on 2015/1/31.
 */
@Repository
public class MemberTypeDaoImpl extends BaseDaoImpl<MemberTypeEntity, Long> implements MemberTypeDao {
}
