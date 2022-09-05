package anymobi.study.board.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class CustomException extends RuntimeException {
    HttpStatus httpStatus;
    String message;

    public ErrorCode getErrorCode() {
        return new ErrorCode(this.httpStatus, this.message);
    }
}
