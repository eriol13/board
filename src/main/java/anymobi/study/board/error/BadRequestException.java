package anymobi.study.board.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class BadRequestException extends IllegalArgumentException {

    public BadRequestException(String message) {
        super(message);
    }

    public ErrorCode getErrorCode() {
        return new ErrorCode(HttpStatus.BAD_REQUEST, this.getMessage());
    }
}
