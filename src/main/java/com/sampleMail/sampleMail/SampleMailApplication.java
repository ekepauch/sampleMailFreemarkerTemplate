package com.sampleMail.sampleMail;

import com.sampleMail.sampleMail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SampleMailApplication implements CommandLineRunner {


	@Autowired
	MailService mailService;


	public static void main(String[] args) {
		SpringApplication.run(SampleMailApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {


//		Mail mail = new Mail();
//		mail.setMailFrom("javabycode@gmail.com");
//		mail.setMailTo("ekene.amaechi@upperlink.ng");
//		mail.setMailSubject("Spring Boot - Email with FreeMarker template");
//		String msg = "<a href=\""  + "\">Follow this link to "  + " your credential</a><br/>" +
//				" <strong style=\"color:red\">This link expires after ";
//		mail.setMailContent(msg);
//
//
//		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("name", "David");
//		model.put("details",mail.getMailContent());
//		model.put("location", "Columbus");
//		model.put("signature", "www.javabycode.com");
//		mail.setModel(model);
//
//		mailService.sendEmail(mail);
//
//		System.out.println("Done!");


	}


}
