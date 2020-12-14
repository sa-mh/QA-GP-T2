package com.qa.hq.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "A trainer with the entered ID does not exist.")
public class TrainerNotFoundException extends RuntimeException {

}
