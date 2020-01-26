truncate scheduler_job_info ;
INSERT INTO scheduler_job_info
(id , cron_expression, job_class, job_group, job_name, cron_job, repeat_time) VALUES
(1 ,'0 0/1 * ? * *', 'com.teckup.task.scheduler.taskscheduler.jobs.SampleCronJob', 'Test_Cron', 'Sample Cron', true, NULL);





/*INSERT INTO scheduler_job_info
(id , cron_expression, job_class, job_group, job_name, cron_job, repeat_time) VALUES(2 , NULL, 'com.helixz.quartz.demo.jobs.SimpleJob', 'Test_Job', 'Simple Job', false , '600000');
*/