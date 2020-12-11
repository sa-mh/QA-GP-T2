package App.Backend.src.main.java.com.qa.HP.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "A trainee with the entered ID does not exist.")
public class TraineeNotFoundException extends RuntimeException {

}
