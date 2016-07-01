package com.xxbase.services;

import com.xxbase.dao.BaseDao;
import com.xxbase.dao.IdentityDao;
import com.xxbase.entity.IdentityEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Created by lifang on 2015/2/1.
 */
@Service
public class IdentityServiceImpl extends BaseServiceImpl<IdentityEntity, Long> implements IdentityService {

    @Autowired
    private IdentityDao identityDao;

    private static Object lock = new Object();

    private static Semaphore semaphore = new Semaphore(1);

    @Override
    @Autowired
    public void setBaseDao(BaseDao<IdentityEntity, Long> baseDao) {
        super.setBaseDao(baseDao);
    }

    @Override
    @Transactional(readOnly = true)
    public IdentityEntity findByClazz(String clazz) {
        if (StringUtils.isNotBlank(clazz)) {
            return identityDao.findByClazz(clazz);
        }
        return null;
    }

    @Override
    @Transactional
    public synchronized String getIdentity(Class clazz) {
//        try {
//            semaphore.acquire();
//        } catch (InterruptedException e) {
//            logger.error(e.getMessage(), e);
//        }
        IdentityEntity identityEntity = findByClazz(clazz.getName());

        StringBuffer sb = new StringBuffer(10);
        if (identityEntity != null) {
            String prefix = identityEntity.getPrefix();
            Long suffix = identityEntity.getSuffix() + identityEntity.getStep();
            identityEntity.setSuffix(suffix);
            semaphore.release();
            sb.append(prefix).append(suffix).toString();
        } else {
            int step = 1;
            identityEntity = new IdentityEntity(clazz.getSimpleName().substring(0, 2).toUpperCase(), 10000L, step, clazz.getName());
            persist(identityEntity);
            sb.append(identityEntity.getPrefix()).append(identityEntity.getSuffix()).toString();
        }

//        semaphore.release();
        return sb.toString();
    }
}
