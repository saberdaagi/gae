package com.teckup.task.scheduler.taskscheduler.service;


import com.teckup.task.scheduler.taskscheduler.domain.SchedulerJobInfo;

/**
 * @author Chamith
 */
public interface SchedulerService {

    void startAllSchedulers();

    void scheduleNewJob(SchedulerJobInfo jobInfo);

    void updateScheduleJob(SchedulerJobInfo jobInfo);

    boolean unScheduleJob(String jobName);

    boolean deleteJob(SchedulerJobInfo jobInfo);

    boolean pauseJob(SchedulerJobInfo jobInfo);

    boolean resumeJob(SchedulerJobInfo jobInfo);

    boolean startJobNow(SchedulerJobInfo jobInfo);

}
