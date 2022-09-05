package anymobi.study.board.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class BoardListDTO {

    private Long id;

    private String title;

    private String createdId;

    @Builder
    public BoardListDTO(Long id, String title, String createdId) {
        this.id = id;
        this.title = title;
        this.createdId = createdId;
    }
}
