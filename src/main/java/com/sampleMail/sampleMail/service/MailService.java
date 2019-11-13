package com.sampleMail.sampleMail.service;

import javax.mail.internet.MimeMessage;

import com.sampleMail.sampleMail.controller.EmailController;
import com.sampleMail.sampleMail.model.Mail;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;





@Service
public class MailService  {
    private final static Logger logger = LoggerFactory.getLogger(MailService.class);

    @Autowired
    private JavaMailSender sender;

    @Autowired
    private Configuration freemarkerConfig;




    public void sendEmail(Mail mail) throws Exception {
        MimeMessage message = sender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message);

        // Using a subfolder such as /templates here
        freemarkerConfig.setClassForTemplateLoading(this.getClass(), "/templates");

        Template t = freemarkerConfig.getTemplate("email-template.ftl");
        String text = FreeMarkerTemplateUtils.processTemplateIntoString(t, mail.getModel());



        helper.setTo(mail.getMailTo());
        helper.setText(text, true);
        helper.setSubject(mail.getMailSubject());

        sender.send(message);
    }
}