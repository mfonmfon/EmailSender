package com.semicolon.africa.service;

import com.semicolon.africa.data.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;


/* Mfon Mfon Here **/

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("spring.mail.username")
    private String fromMail;

    public void sendMail(String mail, EmailSender emailSender){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(fromMail);
        mailMessage.setSubject(emailSender.getSubject());
        mailMessage.setText(emailSender.getMessage());
        mailMessage.setTo(mail);
        javaMailSender.send(mailMessage);
    }
}