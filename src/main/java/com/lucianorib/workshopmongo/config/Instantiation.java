package com.lucianorib.workshopmongo.config;

import com.lucianorib.workshopmongo.domain.Post;
import com.lucianorib.workshopmongo.domain.User;
import com.lucianorib.workshopmongo.dto.AuthorDTO;
import com.lucianorib.workshopmongo.dto.CommentDTO;
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

        userRepository.saveAll(Arrays.asList(sebastian, anthony, edwirges, luciano));

        Post post0 = new Post(null,sdf.parse("06/05/2023"),"Learn Java","Ficando brabo no Java",new AuthorDTO(luciano));
        Post post1 = new Post(null,sdf.parse("06/05/2023"),"Bikee","Aprendi a andar de bikeee!",new AuthorDTO(sebastian));
        Post post2 = new Post(null,sdf.parse("07/05/2023"),"Learning...","Estudando no sabadão",new AuthorDTO(luciano));

        CommentDTO comment0 = new CommentDTO("Boaa papai, voaa!", sdf.parse("07/05/2023"), new AuthorDTO(sebastian));
        CommentDTO comment1 = new CommentDTO("Boa amor", sdf.parse("07/05/2023"), new AuthorDTO(edwirges));
        CommentDTO comment2 = new CommentDTO("Boa filhãoo", sdf.parse("07/05/2023"), new AuthorDTO(edwirges));
        CommentDTO comment3 = new CommentDTO("Ai sim moleque, você é demais", sdf.parse("07/05/2023"), new AuthorDTO(luciano));

        post0.getComments().addAll(Arrays.asList(comment0, comment1));
        post1.getComments().addAll(Arrays.asList(comment2, comment3));

        postRepository.saveAll(Arrays.asList(post0, post1, post2));

        luciano.getPosts().addAll(Arrays.asList(post0, post2));
        sebastian.getPosts().add(post1);
        userRepository.saveAll(Arrays.asList(luciano, sebastian));
    }
}
