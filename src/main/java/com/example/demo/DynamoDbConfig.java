package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;



@Configuration 
public class DynamoDbConfig {
@Bean
public DynamoDbClient dynamoDbClient() {
    return DynamoDbClient.builder()
            .region(Region.of("us-west-1"))
            .build();
}

/*@Bean
public DynamoDbEnhancedClient enhancedClient(DynamoDbClient dynamoDbClient) {
    return DynamoDbEnhancedClient.builder()
            .dynamoDbClient(dynamoDbClient)
            .build();
}
*/
}
