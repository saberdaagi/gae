package com.isp.task.scheduler.taskscheduler.jobs;

import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author Chamith
 */
@Slf4j
@DisallowConcurrentExecution
public class SampleCronJob extends QuartzJobBean {

    @Autowired
    private JavaMailSender javaMailSender;

    void sendEmail() {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("sabersasuke1@gmail.com");

        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");

        javaMailSender.send(msg);

    }
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
       log.info("SampleCronJob Start................");
            sendEmail();
        log.info("SampleCronJob End................");
    }
}
