package com.example.demo.user;


import com.example.demo.user.User;
import com.example.demo.user.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
  private final UserService service;

public UserController(UserService service) {
    this.service = service;
}

@GetMapping
public List<User> getAll() {
    return service.getAll();
}

@GetMapping("/{id}")
public User getById(@PathVariable String id) {
    return service.getById(id);
}

@PostMapping
public User create(@RequestBody User user) {
    return service.save(user);
}

@DeleteMapping("/{id}")
public void delete(@PathVariable String id) {
    service.delete(id);
}

}