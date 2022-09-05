package anymobi.study.board.service;

import anymobi.study.board.dto.BoardDTO;
import anymobi.study.board.dto.BoardListDTO;
import anymobi.study.board.entity.Board;
import anymobi.study.board.mapper.BoardMapper;
import anymobi.study.board.repository.BoardRepository;
import anymobi.study.board.error.CustomException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public List<BoardListDTO> getList() {
        return BoardMapper.INSTANCE.toDto(boardRepository.findAll());
    }

    public BoardDTO getInfo(Long id) {
        return BoardMapper.INSTANCE.toDto(boardRepository.findById(id).orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "게시글을 찾을 수 없습니다.")));
    }

    public Long createBoard(BoardDTO dto) {
        return boardRepository.save(BoardMapper.INSTANCE.toEntity(dto)).getId();
    }

    public void updateBoard(Long id, BoardDTO dto) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new CustomException(HttpStatus.BAD_REQUEST, "수정할 게시글이 존재하지 않습니다."));
        board.updateBoard(dto.getTitle(), dto.getContent());
        boardRepository.save(board);
    }

    public void removeBoard(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new CustomException(HttpStatus.BAD_REQUEST, "삭제할 게시글이 존재하지 않습니다."));

        boardRepository.delete(board);
    }
}
