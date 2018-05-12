package rs.netcast.vtv.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
public class ParsingException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1603680429524532150L;
	
	private String message;
	
	public ParsingException() {
		this.message = "Parsing Error! No message available";
	}
	
	public ParsingException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
