package com.badboy.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {
	
//	@Autowired
//    private JavaMailSender mailSender;
	
	@GetMapping("index")
	public String index() {
		
		return "index";
	
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom("badboyren@163.com");
//        message.setTo("2416828825@qq.com");
//        message.setSubject("主题：简单邮件");
//        message.setText("测试邮件内容");
//
//        mailSender.send(message);
	}
}
