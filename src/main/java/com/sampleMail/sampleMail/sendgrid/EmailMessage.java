package com.sampleMail.sampleMail.sendgrid;

import lombok.Data;

import java.util.Map;


@Data
public class EmailMessage {

    private String toAddress;
    private String subject;
    private String body;

    private Map< String, Object > model;








}
