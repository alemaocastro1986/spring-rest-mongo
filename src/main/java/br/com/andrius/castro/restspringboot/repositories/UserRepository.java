package br.com.andrius.castro.restspringboot.repositories;

import br.com.andrius.castro.restspringboot.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    public User findByEmail(String email);
}
