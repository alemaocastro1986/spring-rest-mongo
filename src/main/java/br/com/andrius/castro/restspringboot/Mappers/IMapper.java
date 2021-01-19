package br.com.andrius.castro.restspringboot.Mappers;

public interface IMapper<TEntity, TDto> {
    TDto toDto(TEntity obj);

    TEntity toEntity(TDto obj);
}
