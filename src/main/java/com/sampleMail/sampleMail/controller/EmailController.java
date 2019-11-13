package com.sampleMail.sampleMail.controller;


import com.sampleMail.sampleMail.model.Mail;
import com.sampleMail.sampleMail.service.MailService;
import com.sampleMail.sampleMail.settings.Response;
import com.sampleMail.sampleMail.utility.CustomResponseCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class EmailController {

    private final static Logger logger = LoggerFactory.getLogger(EmailController.class);
    @Autowired
    MailService mailService;



    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public ResponseEntity<Response> sendEmail(@RequestBody Mail mail) throws Exception {
        HttpStatus httpCode;
        Response resp = new Response();
        Map<String, Object> model = new HashMap<String, Object>();
		model.put("details",mail.getDetails());
        mail.setModel(model);
        mailService.sendEmail(mail);
        resp.setCode(CustomResponseCode.SUCCESS);
        resp.setDescription("Successful");
        resp.setData(mail);
        httpCode = HttpStatus.OK;

        return new ResponseEntity<>(resp, httpCode);
    }
}
