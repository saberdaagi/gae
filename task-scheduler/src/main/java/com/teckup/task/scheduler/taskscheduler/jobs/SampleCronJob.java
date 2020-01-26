package com.teckup.task.scheduler.taskscheduler.jobs;

import com.teckup.core.domain.User;
import com.teckup.core.service.EtudiantService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.util.stream.IntStream;

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
