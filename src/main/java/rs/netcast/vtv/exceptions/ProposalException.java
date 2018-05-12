package rs.netcast.vtv.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
public class ProposalException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5148985380565733489L;

	private String message;

	public ProposalException() {
		this.message = "Proposal Error! No message available";
	}
	
	public ProposalException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
