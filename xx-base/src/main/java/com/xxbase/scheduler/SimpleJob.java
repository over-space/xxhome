package com.xxbase.scheduler;

import org.quartz.*;

/**
 * Created by admin on 16/06/29.
 */
public class SimpleJob implements JobDetail{

    @Override
    public JobKey getKey() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public Class<? extends Job> getJobClass() {
        return null;
    }

    @Override
    public JobDataMap getJobDataMap() {
        return null;
    }

    @Override
    public boolean isDurable() {
        return false;
    }

    @Override
    public boolean isPersistJobDataAfterExecution() {
        return false;
    }

    @Override
    public boolean isConcurrentExectionDisallowed() {
        return false;
    }

    @Override
    public boolean requestsRecovery() {
        return false;
    }

    @Override
    public Object clone() {
        return null;
    }

    @Override
    public JobBuilder getJobBuilder() {
        return null;
    }
}
