package com.sampleMail.sampleMail.sendgrid;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SGRequest {

    private String method;
    private String endpoint;
    private String body;

}
