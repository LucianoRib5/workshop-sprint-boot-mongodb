package com.lucianorib.workshopmongo.resources;

import com.lucianorib.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResources {
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User user1 = new User("1", "Jhon", "jhon@email.com");
        User user2 = new User("2", "Maria", "maria@email.com");
        List<User> userList = new ArrayList<>();
        userList.addAll(Arrays.asList(user1, user2));
        return ResponseEntity.ok().body(userList);
    }
}
