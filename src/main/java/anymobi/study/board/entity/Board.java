package anymobi.study.board.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "board")
@NoArgsConstructor
@Getter
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "created_id")
    private String createdId;

    @Column(name = "created_at")
    private String createdAt;

    @Builder
    public Board(String title, String content, String createdId, String createdAt) {
        this.title = title;
        this.content = content;
        this.createdId = createdId;
        this.createdAt = createdAt;
    }

    public void updateBoard(String title, String content, String createdId, String createdAt) {
        this.title = title;
        this.content = content;
        this.createdId = createdId;
        this.createdAt = createdAt;
    }

    public void updateBoard(String title, String content, String createdId) {
        this.title = title;
        this.content = content;
        this.createdId = createdId;
    }


    public void updateBoard(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
