package br.com.andrius.castro.restspringboot.services;

import br.com.andrius.castro.restspringboot.entities.User;

import br.com.andrius.castro.restspringboot.exceptions.NotFoundException;
import br.com.andrius.castro.restspringboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new NotFoundException("User not found."));
    }

    public User findByEmail(String email) {
        Optional<User> user = Optional.ofNullable(userRepository.findByEmail(email));
        return user.orElseThrow(() -> new NotFoundException("User not found."));
    }

    public User store(User user) {
        return this.userRepository.insert(user);
    }

    public User update(String id, User user) {
        Optional<User> userExist = this.userRepository.findById(id);
        User updateUser =  userExist.orElseThrow(() -> new NotFoundException("User not found."));

        updateUser.setName(user.getName());
        updateUser.setEmail(user.getEmail());

        return this.userRepository.save(updateUser);
    }


    public void destroy(String id) {
        Optional<User> userExist = userRepository.findById(id);
        id = userExist.orElseThrow(() -> new NotFoundException("User not found.")).getId();
        this.userRepository.deleteById(id);
    }
}
