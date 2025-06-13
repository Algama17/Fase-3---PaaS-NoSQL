package com.example.demo.config;

import org.springframework.context.annotation.*;
import java.net.URI;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import com.example.demo.AwsProperties;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Configuration
@EnableConfigurationProperties(AwsProperties.class)
public class DynamoDbConfig {

    private final AwsProperties awsProperties;

    public DynamoDbConfig(AwsProperties awsProperties) {
    this.awsProperties = awsProperties;
    System.out.println("AWS Region: " + awsProperties.getRegion());
    System.out.println("DynamoDB Endpoint: " + awsProperties.getDynamodbEndpoint());
}
@Bean
public DynamoDbClient dynamoDbClient() {
    if (awsProperties.getRegion() == null) {
        throw new IllegalArgumentException("La propiedad 'aws.region' debe estar configurada en application.properties.");
    }
    if (awsProperties.getDynamodbEndpoint() == null) {
        throw new IllegalArgumentException("La propiedad 'aws.dynamodb.endpoint' debe estar configurada en application.properties.");
    }

    return DynamoDbClient.builder()
        .region(Region.of(awsProperties.getRegion()))
        .endpointOverride(URI.create(awsProperties.getDynamodbEndpoint())) // Usa el endpoint local
        .build();
}
    @Bean
    public DynamoDbEnhancedClient dynamoDbEnhancedClient(DynamoDbClient dynamoDbClient) {
        return DynamoDbEnhancedClient.builder()
            .dynamoDbClient(dynamoDbClient)
            .build();
    }
}