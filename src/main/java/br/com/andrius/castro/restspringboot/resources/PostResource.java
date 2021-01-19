package br.com.andrius.castro.restspringboot.resources;

import br.com.andrius.castro.restspringboot.dtos.PostDTO;
import br.com.andrius.castro.restspringboot.dtos.UserDTO;
import br.com.andrius.castro.restspringboot.entities.Post;
import br.com.andrius.castro.restspringboot.entities.User;
import br.com.andrius.castro.restspringboot.mappers.PostMapper;
import br.com.andrius.castro.restspringboot.mappers.UserMapper;
import br.com.andrius.castro.restspringboot.services.PostService;
import br.com.andrius.castro.restspringboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
    @Autowired
    private PostService postService;
    @Autowired
    private PostMapper postMapper;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PostDTO> show(@PathVariable String id) {
        PostDTO post = postMapper.toDto(this.postService.findById(id));

        return ResponseEntity.ok().body(post);
    }
}
