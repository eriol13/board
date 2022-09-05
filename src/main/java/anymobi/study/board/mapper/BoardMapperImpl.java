package anymobi.study.board.mapper;

import anymobi.study.board.dto.BoardDTO;
import anymobi.study.board.dto.BoardListDTO;
import anymobi.study.board.entity.Board;
import org.mapstruct.IterableMapping;

import java.util.ArrayList;
import java.util.List;

public class BoardMapperImpl implements BoardMapper{
    @Override
    public Board toEntity(BoardDTO dto) {
        return Board.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .createdId(dto.getCreatedId())
                .createdAt(dto.getCreatedAt())
                .build();
    }

    @Override
    public BoardDTO toDto(Board entity) {
        return BoardDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .createdId(entity.getCreatedId())
                .createdAt(entity.getCreatedAt())
                .build();
    }

    public List<BoardListDTO> toDto(List<Board> entity) {
        List<BoardListDTO> list = new ArrayList<>();
        for(int i = 0; i < entity.size(); i++) {
            list.add(BoardListDTO.builder()
                    .id(entity.get(i).getId())
                    .title(entity.get(i).getTitle())
                    .createdId(entity.get(i).getCreatedId())
                    .build());
        }
        return list;
    }
}
