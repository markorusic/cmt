package rs.netcast.vtv.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class AuthException extends Exception {

	private static final long serialVersionUID = -7129237589902898381L;
	
	private String message;
	
	public AuthException() {
		this.message = "Auth Error! No message available";
	}
	
	public AuthException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
