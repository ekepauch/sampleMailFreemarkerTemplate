package com.sampleMail.sampleMail.sendgrid;




import com.sendgrid.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;


@SuppressWarnings("ALL")
@Service
public class EmailMessageService {

    private  static final Logger logger = LoggerFactory.getLogger(EmailMessageService.class);

    @Value("${email.sender}")
    private String sender;
    @Value("${api.key}")
    private String apiKey;


    public void sendGridMail(EmailMessage emailMessage) throws IOException {



        Email from = new Email(sender);
        String subject = emailMessage.getSubject();
        Email to = new Email(emailMessage.getToAddress());
        Content content = new Content("text/html", emailMessage.getBody());
        Mail mail = new Mail(from, subject, to, content);


        SendGrid sg = new SendGrid(apiKey);

        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            logger.info("::::::  NOTIFICATION :::::::::::" +ex);
            throw ex;
        }

    }

}
