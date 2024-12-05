package com.sampleMail.sampleMail.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.sampleMail.sampleMail.controller.EmailController;
import com.sampleMail.sampleMail.model.Mail;
import com.sampleMail.sampleMail.model.MessageConfigRequest;
import com.sampleMail.sampleMail.sendgrid.EmailMessage;
import com.sampleMail.sampleMail.sendgrid.EmailMessageService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class MailService  {
    private final static Logger logger = LoggerFactory.getLogger(MailService.class);

//    @Autowired
//    private JavaMailSender sender;
    @Autowired
    private Configuration freemarkerConfig;
    @Autowired
    private EmailMessageService mailService;



    public void sendEmail(MessageConfigRequest request) throws IOException, TemplateException, MessagingException {

        String msg= " Your merchant profile on FBN payment gateway has been approved " + "<br/>"
                + "";
//        MimeMessage messages = sender.createMimeMessage();
//
//        MimeMessageHelper helper = new MimeMessageHelper(messages);
        EmailMessage mail = new EmailMessage();

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("details",msg);
        model.put("firstName",request.getFirstName());
        model.put("lastName",request.getLastName());
        model.put("token",request.getToken());
        model.put("apiBaseUrl",request.getUrl());
        mail.setModel(model);


        // Using a subfolder such as /templates here
        freemarkerConfig.setClassForTemplateLoading(this.getClass(), "/templates");
//        Template t = freemarkerConfig.getTemplate("email-template.ftl");
        Template t = freemarkerConfig.getTemplate(request.getTemplate());
        String text = FreeMarkerTemplateUtils.processTemplateIntoString(t, mail.getModel());
        mail.setSubject(request.getSubject());
        mail.setToAddress(request.getEmail());
        mail.setBody(text);
            mailService.sendGridMail(mail);

    }


//    public void sendEmail(Mail mail) throws Exception {
//        MimeMessage message = sender.createMimeMessage();
//
//        MimeMessageHelper helper = new MimeMessageHelper(message);
//
//        // Using a subfolder such as /templates here
//        freemarkerConfig.setClassForTemplateLoading(this.getClass(), "/templates");
//
//        Template t = freemarkerConfig.getTemplate("email-template.ftl");
//        String text = FreeMarkerTemplateUtils.processTemplateIntoString(t, mail.getModel());
//
//        helper.setTo(mail.getMailTo());
//        helper.setText(text, true);
//        helper.setSubject(mail.getMailSubject());
//        helper.setFrom("mark");
//        sender.send(message);
//    }
}