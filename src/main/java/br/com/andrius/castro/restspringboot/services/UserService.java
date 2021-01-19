package br.com.andrius.castro.restspringboot.services;

import br.com.andrius.castro.restspringboot.core.User;
import br.com.andrius.castro.restspringboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
