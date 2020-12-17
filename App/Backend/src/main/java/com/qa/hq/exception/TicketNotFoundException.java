package com.qa.hq.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "A ticket with the entered ID does not exist.")
public class TicketNotFoundException extends RuntimeException {

}