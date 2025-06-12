package com.example.demo.user;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.*;
import java.util.*;

@Repository
public class UserRepository {

    private final DynamoDbTable<User> userTable;

    public UserRepository(DynamoDbEnhancedClient enhancedClient) {
        this.userTable = enhancedClient.table("Alberto-Fase-3-Table", TableSchema.fromBean(User.class));
    }

    public void save(User user) {
        userTable.putItem(user);
    }

    public Optional<User> findByAlgama(String algama) {
        User user = userTable.getItem(r -> r.key(k -> k.partitionValue(algama)));
        return Optional.ofNullable(user);
    }

    public void deleteByAlgama(String algama) {
        userTable.deleteItem(r -> r.key(k -> k.partitionValue(algama)));
    }

    public List<User> findAll() {
    List<User> users = new ArrayList<>();
    userTable.scan().items().forEach(users::add);
    return users;
}

}
