package rs.netcast.vtv.service.impl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import rs.netcast.vtv.exceptions.ParsingException;
import rs.netcast.vtv.service.ParsingService;

@Service
public class ParsingServiceImpl implements ParsingService {

	 private Logger logger = LoggerFactory.getLogger(ParsingServiceImpl.class);
	
	/*
	 * (non-Javadoc)
	 * @see rs.netcast.vtv.service.ParsingService#parseFile(org.springframework.web.multipart.MultipartFile)
	 * https://commons.apache.org/proper/commons-csv/user-guide.html
	 */
	@Override
	public Object parseFile(MultipartFile mpFile) throws ParsingException {
		return null;
	}
//		try {
//			Reader reader = new InputStreamReader(mpFile.getInputStream());
//			CSVParser parser = new CSVParser(reader, CSVFormat.TDF.withHeader(FormatedCSVHeader.class));
//			
//			List<CSVRecord> records = parser.getRecords();
//			List<EpgProposalItem> epgProposals = new ArrayList<EpgProposalItem>();
//						
//			int size = records.size();
//			int index = 0;
//			for(CSVRecord record: records) {
//				
//				String title = record.get(FormatedCSVHeader.TITLE);
//				Long startTimestamp = Long.parseLong(record.get(FormatedCSVHeader.START)) * 1000;
//				Date start = new Date(startTimestamp);
//				Date end = null;
//				
//				if((index + 1) < size) {
//					CSVRecord next = records.get(index + 1);
//					end = new Date(Long.parseLong(next.get(FormatedCSVHeader.START)) * 1000);
//				} else {
//					// last EPG case - calculate end time based on EPG with same title runtime or default runtime
//					Long runtime = ApplicationProperties.DEFAULT_CONTENT_RUNTIME_MILISECONDS;
//					Optional<EpgProposalItem> epgWithSameTitle = epgProposals
//								.stream()
//								.filter(epgProposalItem -> epgProposalItem.getTitle().toLowerCase().equals(title.toLowerCase()))
//								.findFirst();
//					if (epgWithSameTitle.isPresent()) {
//						runtime = epgWithSameTitle.get().getEnd().getTime() - epgWithSameTitle.get().getStart().getTime();				
//					} else {
//					// TODO: Uzmi runtime iz contenta 
//					}
//					end = new Date(startTimestamp + runtime);
//				}
//				
//				EpgProposalItem epg  = new EpgProposalItem(						
//						title,
//						record.get(FormatedCSVHeader.ORIGINAL_TITLE),
//						record.get(FormatedCSVHeader.DESCRIPTION),
//						record.get(FormatedCSVHeader.TYPE).toLowerCase(),
//						start,
//						end
//				);
//				
//				epgProposals.add(epg);
//				index++;
//			}
//			
//			parser.close();
//			
//			return epgProposals;
//			
//		} catch(IOException e) {
//			throw new ParsingException("Error parsing CSV file: " + e.getMessage());
//		}
//	}

	
	
}
