package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "aws")
public class AwsProperties {
    private String dynamodbEndpoint;
    private String region;

    // Getters and setters
    public String getDynamodbEndpoint() {
        return dynamodbEndpoint;
    }

    public void setDynamodbEndpoint(String dynamodbEndpoint) {
        this.dynamodbEndpoint = dynamodbEndpoint;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}