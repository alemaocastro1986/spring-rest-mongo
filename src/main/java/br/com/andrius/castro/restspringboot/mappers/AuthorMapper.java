package br.com.andrius.castro.restspringboot.mappers;

import br.com.andrius.castro.restspringboot.dtos.AuthorDTO;
import br.com.andrius.castro.restspringboot.dtos.UserDTO;
import br.com.andrius.castro.restspringboot.entities.User;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper implements IMapper<User, AuthorDTO> {

    @Override
    public AuthorDTO toDto(User obj) {

        return new AuthorDTO(obj.getId(), obj.getName());
    }

    @Override
    public User toEntity(AuthorDTO obj) {
        return new User(obj.getId(), obj.getName(), null);
    }
}