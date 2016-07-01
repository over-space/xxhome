package com.xxbase.scheduler;

import com.xxbase.entity.BaseEntity;
import com.xxbase.services.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by admin on 16/06/29.
 */
@Component
public class IdentityScheduler implements BaseScheduler{

    @Autowired
    private IdentityService identityService;

    @Override
    @Scheduled(fixedRate = 1000*60*60)
    public void run() {
        String identity1 = identityService.getIdentity(BaseEntity.class);
        logger.debug("identity1 : {}", identity1);
        String identity2 = identityService.getIdentity(Serializable.class);
        logger.debug("identity2 : {}", identity2);
    }
}
