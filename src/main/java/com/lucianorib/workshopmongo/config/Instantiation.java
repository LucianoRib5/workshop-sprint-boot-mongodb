package com.lucianorib.workshopmongo.config;

import com.lucianorib.workshopmongo.domain.Post;
import com.lucianorib.workshopmongo.domain.User;
import com.lucianorib.workshopmongo.repository.PostRepository;
import com.lucianorib.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User sebastian = new User(null, "Sebastian", "sebastian@email.com");
        User anthony = new User(null, "Anthony", "anthony@email.com");
        User edwirges = new User(null, "Edwirges", "edwirges@email.com");
        User luciano = new User(null, "Luciano", "luciano@email.com");

        Post post0 = new Post(
                null,
                sdf.parse("06/05/2023"),
                "Learn Java",
                "Ficando brabo no Java",
                luciano
        );

        Post post1 = new Post(
                null,
                sdf.parse("06/05/2023"),
                "Bikee",
                "Aprendi a andar de bikeee!",
                sebastian
        );

        userRepository.saveAll(Arrays.asList(sebastian, anthony, edwirges, luciano));
        postRepository.saveAll(Arrays.asList(post0, post1));
    }
}
