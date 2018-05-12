package rs.netcast.vtv.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
public class RepositoryLayerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5739620268524631943L;

	private String message;
	
	public RepositoryLayerException() {
		this.message = "Repository layer error! No message available";
	}
	
	public RepositoryLayerException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
