package com.example.demo.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDbBean
public class User {
   private String algama;  // debe coincidir con el nombre de la clave de partición en AWS
    private String name;
    private String email;

    @DynamoDbPartitionKey
    public String getAlgama() {
        return algama;
    }
    public void setAlgama(String algama) {
        this.algama = algama;
    }
}
