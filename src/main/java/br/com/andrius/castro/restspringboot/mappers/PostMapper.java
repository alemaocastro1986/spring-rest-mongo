package br.com.andrius.castro.restspringboot.mappers;

import br.com.andrius.castro.restspringboot.dtos.PostDTO;
import br.com.andrius.castro.restspringboot.entities.Post;
import org.springframework.stereotype.Component;

@Component
public class PostMapper implements IMapper<Post, PostDTO> {


    @Override
    public PostDTO toDto(Post obj) {
        return new PostDTO(obj.getId(), obj.getDate(), obj.getTitle(), obj.getContent(), obj.getAuthor(), obj.getComments());
    }

    @Override
    public Post toEntity(PostDTO obj) {
        return new Post(obj.getId(), obj.getDate(), obj.getTitle(), obj.getContent(), obj.getAuthor());
    }
}
