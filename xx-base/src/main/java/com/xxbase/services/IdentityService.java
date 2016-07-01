package com.xxbase.services;


import com.xxbase.entity.IdentityEntity;

/**
 * Created by lifang on 2015/2/1.
 */
public abstract interface IdentityService extends BaseService<IdentityEntity, Long> {


    public IdentityEntity findByClazz(String clazz);

    public String getIdentity(Class clazz);

}
