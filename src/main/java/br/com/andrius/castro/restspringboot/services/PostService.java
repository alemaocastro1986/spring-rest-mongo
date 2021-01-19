package br.com.andrius.castro.restspringboot.services;

import br.com.andrius.castro.restspringboot.entities.Post;
import br.com.andrius.castro.restspringboot.entities.User;
import br.com.andrius.castro.restspringboot.exceptions.NotFoundException;
import br.com.andrius.castro.restspringboot.repositories.PostRepository;
import br.com.andrius.castro.restspringboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;


    public Post findById(String id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new NotFoundException("User not found."));
    }

    public List<Post> findByTitle(String text) {
        return postRepository.findByTitleContainingIgnoreCase(text);
    }



}
