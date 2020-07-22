package com.akash.springboot.jpa.mysql;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.akash.springboot.jpa.mysql.exception.ExceptionMsgEntity;

/**
 * @author Akash
 *
 */

@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> forAllUnknownException(Exception exception, WebRequest req) {
		ExceptionMsgEntity exceptionMsgEntity = new ExceptionMsgEntity(exception.getMessage(),
				req.getDescription(false));
		return new ResponseEntity<Object>(exceptionMsgEntity, HttpStatus.INTERNAL_SERVER_ERROR);
	}

//	@ExceptionHandler(.class)
//	public final ResponseEntity<Object> handleUserNotFoundException( exception, WebRequest req) {
//		ExceptionMsgEntity exceptionMsgEntity = new ExceptionMsgEntity(exception.getMessage(),
//				req.getDescription(false));
//		return new ResponseEntity<Object>(exceptionMsgEntity, HttpStatus.NOT_FOUND);
//	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest req) {
		ExceptionMsgEntity exceptionMsgEntity = new ExceptionMsgEntity(ex.getMessage(), req.getDescription(false));
		return new ResponseEntity<Object>(exceptionMsgEntity, HttpStatus.BAD_REQUEST);
	}

}
