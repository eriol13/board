package anymobi.study.board.controller;


import anymobi.study.board.dto.BoardDTO;
import anymobi.study.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping(value = "")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getList() {

        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        return new ResponseEntity<>(boardService.getList(), header, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getInfo(@PathVariable Long id) {

        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        return new ResponseEntity<>(boardService.getInfo(id), header, HttpStatus.OK);
    }

    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> createBoard(@RequestBody BoardDTO dto) {
        dto.validate(true);
        Long id = boardService.createBoard(dto);

        HttpHeaders header = new HttpHeaders();
        header.set("Content-Location", "/board/"+id);

        return new ResponseEntity<>(header, HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> updateBoard(@PathVariable Long id, @RequestBody BoardDTO dto) {
        dto.validate(false);
        boardService.updateBoard(id, dto);

        HttpHeaders header = new HttpHeaders();
        header.set("Content-Location", "/board/"+id);

        return new ResponseEntity<>(header, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> removeBoard(@PathVariable Long id) {
        boardService.removeBoard(id);

        HttpHeaders header = new HttpHeaders();
        header.set("Content-Location", "/board");

        return new ResponseEntity<>("", header, HttpStatus.NO_CONTENT);
    }
}
