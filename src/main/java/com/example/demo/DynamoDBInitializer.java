package com.example.demo;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

public class DynamoDBInitializer {
    public static void createTable(DynamoDbClient client) {
        CreateTableRequest request = CreateTableRequest.builder()
            .tableName("Alberto-Fase-3-Table")
            .keySchema(KeySchemaElement.builder()
                .attributeName("algama")
                .keyType(KeyType.HASH)
                .build())
            .attributeDefinitions(AttributeDefinition.builder()
                .attributeName("algama")
                .attributeType(ScalarAttributeType.S)
                .build())
            .provisionedThroughput(ProvisionedThroughput.builder()
                .readCapacityUnits(5L)
                .writeCapacityUnits(5L)
                .build())
            .build();

        client.createTable(request);
        System.out.println("Tabla creada: Alberto-Fase-3-Table");
    }
}
