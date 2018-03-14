package by.runets.voting.mapper;

import org.mapstruct.MappingTarget;

public interface GenericMapper<E, DTO> {
    E map(DTO dto);

    E map(DTO dto, @MappingTarget E entity);
}
