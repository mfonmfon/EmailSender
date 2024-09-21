package com.semicolon.africa.web;

import com.semicolon.africa.data.EmailSender;
import com.semicolon.africa.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class controller {

    @Autowired
    private EmailSenderService emailSenderService;
    
    @PostMapping("/send/{email}")
    public String sendEmail(@PathVariable String email, @RequestBody EmailSender emailSender){
        emailSenderService.sendMail(email, emailSender);
        return "Sent successfully";
    }
}
