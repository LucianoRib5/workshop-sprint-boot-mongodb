package com.lucianorib.workshopmongo.config;

import com.lucianorib.workshopmongo.domain.User;
import com.lucianorib.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();

        User sebastian = new User(null, "Sebastian", "sebastian@email.com");
        User anthony = new User(null, "Anthony", "anthony@email.com");
        User edwirges = new User(null, "Edwirges", "edwirges@email.com");
        User luciano = new User(null, "Luciano", "luciano@email.com");

        userRepository.saveAll(Arrays.asList(sebastian, anthony, edwirges, luciano));
    }
}
