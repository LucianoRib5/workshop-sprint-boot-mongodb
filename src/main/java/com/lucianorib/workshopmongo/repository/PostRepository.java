package com.lucianorib.workshopmongo.repository;

import com.lucianorib.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
