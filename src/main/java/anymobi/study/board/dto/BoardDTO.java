package anymobi.study.board.dto;


import anymobi.study.board.error.BadRequestException;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.util.Assert;

@Getter
@NoArgsConstructor
@ToString
public class BoardDTO {

    private Long id;

    private String title;

    private String content;

    private String createdId;

    private String createdAt;

    @Builder
    public BoardDTO(Long id, String title, String content, String createdId, String createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdId = createdId;
        this.createdAt = createdAt;
    }

    public void validate(boolean insertFlag) {
        try {
            Assert.hasText(this.title, "제목이 존재하지 않습니다.");
            Assert.hasText(this.content, "내용이 존재하지 않습니다.");
            if(insertFlag) {
                Assert.hasText(this.createdId, "작성자가 존재하지 않습니다.");
                Assert.hasText(this.createdAt, "작성일이 존재하지 않습니다.");
            }
        } catch(IllegalArgumentException e) {
            throw new BadRequestException(e.getMessage());
        }
    }
}
