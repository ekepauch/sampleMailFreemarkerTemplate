package com.sampleMail.sampleMail.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Mail {




    private String mailFrom;

    private String mailTo;

    private String mailCc;

    private String mailBcc;

    private String mailSubject;

    private String details;

    private String contentType;

    private List < Object > attachments;

    private Map < String, Object > model;

    public Mail() {
        contentType = "text/plain";
    }

}


