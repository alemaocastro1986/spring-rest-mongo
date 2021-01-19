package br.com.andrius.castro.restspringboot.resources;

import br.com.andrius.castro.restspringboot.core.User;
import br.com.andrius.castro.restspringboot.dtos.UserDTO;
import br.com.andrius.castro.restspringboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity< List<UserDTO>> index(){
        List<User> users = this.userService.findAll();
        List<UserDTO> usersList = users.stream().map(UserDTO::new).collect(Collectors.toList());

        return ResponseEntity.ok().body(usersList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity< UserDTO> show(@PathVariable String id){
        UserDTO user =  new UserDTO(this.userService.findById(id));

        return ResponseEntity.ok().body(user);
    }
}
