package br.com.andrius.castro.restspringboot.resources;

import br.com.andrius.castro.restspringboot.Mappers.UserMapper;
import br.com.andrius.castro.restspringboot.core.User;
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

    @PostMapping
    public ResponseEntity<UserDTO> store(@RequestBody UserDTO userDTO) {
        UserDTO user = userMapper.toDto(this.userService.store(this.userMapper.toEntity(userDTO)));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }
}
