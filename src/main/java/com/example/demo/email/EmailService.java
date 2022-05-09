package com.example.demo.email;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.logging.Logger;

@Service
@AllArgsConstructor
@Slf4j
public class EmailService implements EmailSender{


    private final JavaMailSender mailSender;
    @Override
    @Async
    public void sendMail(String to, String mail) {
          try{
              MimeMessage message = mailSender.createMimeMessage();
              MimeMessageHelper messageHelper = new MimeMessageHelper(message,"UTF-8");
              messageHelper.setText(mail,true);
              messageHelper.setTo(to);
              messageHelper.setSubject("Confirm you email");
              messageHelper.setFrom("test@ryk.com");
              mailSender.send(message);
          }catch (MessagingException exception){
              log.error("failed to send message!!",exception.getLocalizedMessage());
              throw  new IllegalStateException("failed to send messgae");
          }
    }
}
