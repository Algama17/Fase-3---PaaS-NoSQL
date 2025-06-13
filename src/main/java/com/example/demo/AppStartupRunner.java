package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Component
public class AppStartupRunner implements CommandLineRunner {

    private final DynamoDbClient dynamoDbClient;

    @Autowired
    public AppStartupRunner(DynamoDbClient dynamoDbClient) {
        this.dynamoDbClient = dynamoDbClient;
    }

    @Override
    public void run(String... args) throws Exception {
        // Crea la tabla en DynamoDB Local si no existe
        DynamoDBInitializer.createTable(dynamoDbClient);
    }
}