package com.hanjie.common.async;

import com.hanjie.common.util.SpringContainerUtils;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class AsyncFactory {


    /**
     *定时发送邮件
     */
    public static Runnable sendEmail(String email,String content){
        Runnable runnable=()->{
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom("lap191019@163.com");
            simpleMailMessage.setTo(email);
            simpleMailMessage.setSubject("定时发送");
            simpleMailMessage.setText(content);
            JavaMailSender bean = SpringContainerUtils.getBean(JavaMailSender.class);
            bean.send(simpleMailMessage);
        };
        return runnable;
    }
}
