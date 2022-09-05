package anymobi.study.board.mapper;

import anymobi.study.board.dto.BoardDTO;
import anymobi.study.board.dto.BoardListDTO;
import anymobi.study.board.entity.Board;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface BoardMapper extends GenericMapper<BoardDTO, Board> {
    BoardMapper INSTANCE = Mappers.getMapper(BoardMapper.class);

    public List<BoardListDTO> toDto(List<Board> entity);
}
