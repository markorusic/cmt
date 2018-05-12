package rs.netcast.vtv.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import rs.netcast.vtv.exceptions.ParsingException;
import rs.netcast.vtv.exceptions.RepositoryLayerException;
import rs.netcast.vtv.service.ParsingService;

@RestController
@RequestMapping(value="/ingest")
public class IngestApi {
	
	@Autowired
	ParsingService parsingService;
	
	@PostMapping("/csv")
    public Object handleFileUpload(
    		@RequestBody MultipartFile file, 
    		@RequestParam String channelId,
    		HttpServletRequest request
    ) throws ParsingException, RepositoryLayerException {
			// System.out.println("Channel id: " + channelId);
    		return parsingService.parseFile(file);  		
    }
	
}