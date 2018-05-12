package rs.netcast.vtv.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class BadRequestException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1669537365152399440L;
	
	private String message;
	
	public BadRequestException() {
		this.message = "Bad Request! No message available";
	}
	
	public BadRequestException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
