package br.com.andrius.castro.restspringboot.config;

import br.com.andrius.castro.restspringboot.core.User;
import br.com.andrius.castro.restspringboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile(value = "dev")
public class Database implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();

        User u1 = new User(null, "Ragnar Lothbrok", "ragnar@vikings.com");
        User u2 = new User(null, "Bjorn Lothbrok", "bjorn@vikings.com");
        User u3 = new User(null, "Ivar lothbrok", "ragnar@vikings.com");

        userRepository.saveAll(Arrays.asList(u1,u2,u3));
    }
}
