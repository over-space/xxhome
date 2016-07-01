package com.xxbase.scheduler;

import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by admin on 16/06/29.
 */
public class BaseSchedulerListener implements SchedulerListener {

    private Logger logger = LoggerFactory.getLogger(BaseSchedulerListener.class);

    @Override
    public void jobScheduled(Trigger trigger) {
        logger.debug("jobScheduled");
    }

    @Override
    public void jobUnscheduled(TriggerKey triggerKey) {
        logger.debug("jobUnscheduled");
    }

    @Override
    public void triggerFinalized(Trigger trigger) {
        logger.debug("triggerFinalized");
    }

    @Override
    public void triggerPaused(TriggerKey triggerKey) {
        logger.debug("triggerPaused");
    }

    @Override
    public void triggersPaused(String s) {
        logger.debug("triggersPaused");
    }

    @Override
    public void triggerResumed(TriggerKey triggerKey) {
        logger.debug("triggerResumed");
    }

    @Override
    public void triggersResumed(String s) {
        logger.debug("triggersResumed");
    }

    @Override
    public void jobAdded(JobDetail jobDetail) {
        logger.debug("jobAdded");
    }

    @Override
    public void jobDeleted(JobKey jobKey) {
        logger.debug("jobDeleted");
    }

    @Override
    public void jobPaused(JobKey jobKey) {
        logger.debug("jobPaused");
    }

    @Override
    public void jobsPaused(String s) {
        logger.debug("jobsPaused");
    }

    @Override
    public void jobResumed(JobKey jobKey) {
        logger.debug("jobResumed");
    }

    @Override
    public void jobsResumed(String s) {
        logger.debug("jobsResumed");
    }

    @Override
    public void schedulerError(String s, SchedulerException e) {
        logger.debug("schedulerError");
    }

    @Override
    public void schedulerInStandbyMode() {
        logger.debug("schedulerInStandbyMode");
    }

    @Override
    public void schedulerStarted() {
        logger.debug("schedulerStarted");
    }

    @Override
    public void schedulerStarting() {
        logger.debug("schedulerStarting");
    }

    @Override
    public void schedulerShutdown() {
        logger.debug("schedulerShutdown");
    }

    @Override
    public void schedulerShuttingdown() {
        logger.debug("schedulerShuttingdown");
    }

    @Override
    public void schedulingDataCleared() {
        logger.debug("schedulingDataCleared");
    }
}
