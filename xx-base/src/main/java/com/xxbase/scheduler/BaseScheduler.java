package com.xxbase.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by admin on 16/06/29.
 */
public interface BaseScheduler {

    public static Logger logger = LoggerFactory.getLogger(BaseScheduler.class);

    public void run();

}
