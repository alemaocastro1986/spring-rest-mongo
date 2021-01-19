package br.com.andrius.castro.restspringboot.mappers;

public interface IMapper<TEntity, TDto> {
    TDto toDto(TEntity obj);

    TEntity toEntity(TDto obj);
}
