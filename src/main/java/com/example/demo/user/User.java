package com.example.demo.user;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.*;

@DynamoDbBean
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String algama;
    private String name;
    private String email;

    @DynamoDbPartitionKey
    public String getAlgama() {
        return algama;
    }

    public void setAlgama(String algama) {
        this.algama = algama;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
