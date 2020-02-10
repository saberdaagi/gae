package com.isp.task.scheduler.taskscheduler.repository;


import com.isp.task.scheduler.taskscheduler.domain.SchedulerJobInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Chamith
 */
@Repository
public interface SchedulerRepository extends JpaRepository<SchedulerJobInfo, Long> {

}
