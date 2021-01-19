package br.com.andrius.castro.restspringboot.mappers;

import br.com.andrius.castro.restspringboot.core.User;
import br.com.andrius.castro.restspringboot.dtos.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements IMapper<User, UserDTO> {

    @Override
    public UserDTO toDto(User obj) {

        return new UserDTO(obj.getId(), obj.getName(), obj.getEmail());
    }

    @Override
    public User toEntity(UserDTO obj) {
        return new User(obj.getId(), obj.getName(), obj.getEmail());
    }
}
