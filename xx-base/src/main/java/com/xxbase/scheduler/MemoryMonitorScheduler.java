package com.xxbase.scheduler;

import com.xxbase.utils.XXSystemUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 16/06/29.
 */
@Component
public class MemoryMonitorScheduler implements BaseScheduler {

    @Override
    @Scheduled(fixedRate = 1000*60*60*8)
    public void run() {

        Runtime runtime = Runtime.getRuntime();
        long totalMemory = XXSystemUtils.bytesToM(runtime.totalMemory());
        long maxMemory = XXSystemUtils.bytesToM(runtime.maxMemory());
        long freeMemory = XXSystemUtils.bytesToM(runtime.freeMemory());

        if(logger.isDebugEnabled()) logger.debug("total memory : {}M, max memory : {}M, free memory : {}M", totalMemory, maxMemory, freeMemory);
    }

}
