package com.example.demo.user;


import com.example.demo.user.User;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.enhanced.dynamodb.*;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import java.util.*;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserService {
 private final DynamoDbTable<User> userTable;

public UserService(DynamoDbEnhancedClient enhancedClient) {
    this.userTable = enhancedClient.table("User", TableSchema.fromBean(User.class));
}

public List<User> getAll() {
    List<User> users = new ArrayList<>();
    userTable.scan().items().forEach(users::add);
    return users;
}

public User getById(String id) {
    return userTable.getItem(Key.builder().partitionValue(id).build());
}

public User save(User user) {
    userTable.putItem(user);
    return user;
}

public void delete(String id) {
    userTable.deleteItem(Key.builder().partitionValue(id).build());
}

}