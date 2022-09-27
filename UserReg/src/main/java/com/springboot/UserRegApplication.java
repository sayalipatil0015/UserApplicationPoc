package com.springboot;

import javax.mail.MessagingException;
import javax.security.auth.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.springboot.service.EmailSenderService;

@SpringBootApplication

public class UserRegApplication {


	@Autowired
	private EmailSenderService service;

	public static void main(String[] args) {
		SpringApplication.run(UserRegApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void sendMail()  {

		service.sendSimpleEmail("userapplication995@gmail.com", 
				"This is subject", 
				"This is body of email");



	}

}
