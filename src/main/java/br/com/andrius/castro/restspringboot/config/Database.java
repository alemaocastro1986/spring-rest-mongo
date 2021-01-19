package br.com.andrius.castro.restspringboot.config;

import br.com.andrius.castro.restspringboot.dtos.CommentDTO;
import br.com.andrius.castro.restspringboot.entities.Post;
import br.com.andrius.castro.restspringboot.entities.User;
import br.com.andrius.castro.restspringboot.mappers.AuthorMapper;
import br.com.andrius.castro.restspringboot.mappers.UserMapper;
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
    @Autowired
    private AuthorMapper authorMapper;


    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        postRepository.deleteAll();

        User u1 = new User(null, "Ragnar Lothbrok", "ragnar@vikings.com");
        User u2 = new User(null, "Bjorn Lothbrok", "bjorn@vikings.com");
        User u3 = new User(null, "Ivar lothbrok", "ivar@vikings.com");

        userRepository.saveAll(Arrays.asList(u1, u2, u3));

        Post p1 = new Post(null, Instant.now(), "Partiu invadir Inglaterra",
                "Vamos invadir Wessex, atrás de riquezas.", this.authorMapper.toDto(u1));
        Post p2 = new Post(null, Instant.now(), "Partiu Salvar Kattegat", "Vou lutar uma ultima vez.", this.authorMapper.toDto(u2));

        CommentDTO c1 = new CommentDTO("Vamos dominar esta terra pai.", Instant.now(),
                this.authorMapper.toDto(u2));

        CommentDTO c2 = new CommentDTO("Sem piedade.", Instant.now(),
                this.authorMapper.toDto(u3));

        CommentDTO c3 = new CommentDTO("Te espero em Valhala.Onde vamos beber no grande salão de Odin", Instant.now(),
                this.authorMapper.toDto(u1));

        p1.getComments().addAll(Arrays.asList(c1, c2));
        p2.getComments().add(c3);

        postRepository.saveAll(Arrays.asList(p1, p2));

        u1.getPosts().add(p1);
        u2.getPosts().add(p2);

        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
