package br.com.andrius.castro.restspringboot.config;

import br.com.andrius.castro.restspringboot.entities.Post;
import br.com.andrius.castro.restspringboot.entities.User;
import br.com.andrius.castro.restspringboot.repositories.PostRepository;
import br.com.andrius.castro.restspringboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile(value = "dev")
public class Database implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();

        User u1 = new User(null, "Ragnar Lothbrok", "ragnar@vikings.com");
        User u2 = new User(null, "Bjorn Lothbrok", "bjorn@vikings.com");
        User u3 = new User(null, "Ivar lothbrok", "ragnar@vikings.com");

        userRepository.saveAll(Arrays.asList(u1,u2,u3));

        Post p1 = new Post(null, Instant.now(), "Partiu invadir Inglaterra",
                "Vamos invadir Wessex, atrás de riquezas.", u1);
        Post p2 = new Post(null, Instant.now(), "Save Kattegat", "Vou lutar uma ultima vez.", u2);

        postRepository.saveAll(Arrays.asList(p1,p2));

    }
}
