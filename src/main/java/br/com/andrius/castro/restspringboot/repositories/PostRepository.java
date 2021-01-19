package br.com.andrius.castro.restspringboot.repositories;

import br.com.andrius.castro.restspringboot.entities.Post;
import br.com.andrius.castro.restspringboot.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {
}
