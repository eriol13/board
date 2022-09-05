package anymobi.study.board.mapper;


import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

public interface GenericMapper<D, E>{

    E toEntity(D dto);

    D toDto(E entity);
}
