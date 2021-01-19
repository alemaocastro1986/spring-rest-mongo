package br.com.andrius.castro.restspringboot.repositories;

import br.com.andrius.castro.restspringboot.entities.Post;
import br.com.andrius.castro.restspringboot.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    @Query("{'comments.content':{ $regex: ?0, $options:'i'}}")
    List<Post> findByComment(String text);

    List<Post> findByTitleContainingIgnoreCase(String text);
}
