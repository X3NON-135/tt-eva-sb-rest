package spring.boot.rest.mapper;

public interface DtoResponseMapper<D, C> {
    D toDto(C object);
}
