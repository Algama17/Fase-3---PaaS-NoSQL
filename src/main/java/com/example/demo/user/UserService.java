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

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    public User getById(String id) {
        return repository.findByAlgama(id).orElse(null);
    }

    public User save(User user) {
        repository.save(user);
        return user;
    }

    public void delete(String id) {
        repository.deleteByAlgama(id);
    }
}
