package br.com.andrius.castro.restspringboot.repositories;

import br.com.andrius.castro.restspringboot.entities.Post;
import br.com.andrius.castro.restspringboot.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {
    public List<Post> findByTitleContainingIgnoreCase(String text);
}
