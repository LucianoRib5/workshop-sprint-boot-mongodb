package com.lucianorib.workshopmongo.services;

import com.lucianorib.workshopmongo.domain.Post;
import com.lucianorib.workshopmongo.repository.PostRepository;
import com.lucianorib.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post findById(String id){
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado"));
    }

    public List<Post> findByText(String text){
        return postRepository.findByTitleContainingIgnoreCase(text);
    }
}
