package br.com.andrius.castro.restspringboot.resources;

import br.com.andrius.castro.restspringboot.core.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity< List<User>> findAll(){
        User u1 = new User("1", "john doe", "john@gmail.com");
        User u2 = new User("2", "jane doe", "jane@gmail.com");

        List<User> users = new ArrayList<>(Arrays.asList(u1, u2));

        return ResponseEntity.ok().body(users);
    }
}
