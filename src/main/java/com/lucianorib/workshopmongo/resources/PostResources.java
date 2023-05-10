package com.lucianorib.workshopmongo.resources;

import com.lucianorib.workshopmongo.domain.Post;
import com.lucianorib.workshopmongo.resources.utils.URL;
import com.lucianorib.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostResources {

    @Autowired
    private PostService postService;

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Post>> findByText(@RequestParam("text") String text){
        List<Post> posts = postService.findByText(URL.decodeParam(text));
        return ResponseEntity.ok().body(posts);
    }
}
