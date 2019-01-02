package com.badboy.stock.service.util.mail;

import java.io.File;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailUtils {
	
	@Value("${spring.mail.username}")
	public String sendPersion;
	
	@Autowired
    private JavaMailSender mailSender;
	
	public void sendSimpleMailMessage(String title,String content,String toMail) {
		SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sendPersion);
        message.setTo(toMail);
        message.setSubject(title);
        message.setText(content);

        mailSender.send(message);
	}
	
	public void sendAttachmentsMail(String sendTo, String title, String content, List<File> list) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			helper.setFrom(sendPersion);
			helper.setTo(sendTo);
			helper.setSubject(title);
			helper.setText(content);

			for (File f : list) {
				helper.addAttachment(f.getName(), new FileSystemResource(f.getPath()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		mailSender.send(mimeMessage);
	}
	public void sendAttachmentsMail(String sendTo, String title, String content, File file) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			helper.setFrom(sendPersion);
			helper.setTo(sendTo);
			helper.setSubject(title);
			helper.setText(content);
			helper.addAttachment(file.getName(), new FileSystemResource(file.getPath()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		mailSender.send(mimeMessage);
	}

}
