package br.com.andrius.castro.restspringboot.resources;

import br.com.andrius.castro.restspringboot.entities.Post;
import br.com.andrius.castro.restspringboot.mappers.UserMapper;
import br.com.andrius.castro.restspringboot.entities.User;
import br.com.andrius.castro.restspringboot.dtos.UserDTO;
import br.com.andrius.castro.restspringboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @GetMapping
    public ResponseEntity<List<UserDTO>> index() {
        List<User> users = this.userService.findAll();
        List<UserDTO> usersList = users.stream().map(user -> userMapper.toDto(user)).collect(Collectors.toList());

        return ResponseEntity.ok().body(usersList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> show(@PathVariable String id) {
        UserDTO user = userMapper.toDto(this.userService.findById(id));

        return ResponseEntity.ok().body(user);
    }

    @GetMapping(value = "/{id}/posts")
    public ResponseEntity<List<Post>> listPosts(@PathVariable String id) {
        User user = this.userService.findById(id);

        return ResponseEntity.ok().body(user.getPosts());
    }

    @PostMapping
    public ResponseEntity<UserDTO> store(@RequestBody UserDTO userDTO) {
        UserDTO user = userMapper.toDto(this.userService.store(this.userMapper.toEntity(userDTO)));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable String id, @RequestBody UserDTO userDTO) {
        UserDTO user = userMapper.toDto(this.userService.update(id, this.userMapper.toEntity(userDTO)));

        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> store(@PathVariable String id) {
        this.userService.destroy(id);
        return ResponseEntity.noContent().build();
    }


}
