package rs.netcast.vtv.service;

import org.springframework.web.multipart.MultipartFile;

import rs.netcast.vtv.exceptions.ParsingException;

public interface ParsingService {

	public Object parseFile(MultipartFile mpFile) throws ParsingException;
	
}
