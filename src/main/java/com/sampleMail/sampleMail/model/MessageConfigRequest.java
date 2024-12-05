package com.sampleMail.sampleMail.model;

import lombok.Data;

@Data
public class MessageConfigRequest {


    private String template;
    private String message;
    private String subject;
    private String email;
    private String firstName;
    private String lastName;
    private String token;
    private String url;
}
