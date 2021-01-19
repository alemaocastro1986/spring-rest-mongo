package br.com.andrius.castro.restspringboot.resources;

import br.com.andrius.castro.restspringboot.core.User;
import br.com.andrius.castro.restspringboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity< List<User>> findAll(){
        List<User> users = this.userService.findAll();

        return ResponseEntity.ok().body(users);
    }
}
