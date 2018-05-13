package rs.netcast.vtv.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import rs.netcast.vtv.dao.AddressDao;
import rs.netcast.vtv.exceptions.ParsingException;
import rs.netcast.vtv.exceptions.RepositoryLayerException;
import rs.netcast.vtv.service.ParsingService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value="/address")
public class AddressApi {

    @Autowired
    AddressDao addressDao;

    @RequestMapping(value = "/address-all", method = RequestMethod.DELETE)
    public void deleteAllAddress() throws ParsingException, RepositoryLayerException {
        // System.out.println("Channel id: " + channelId);
        addressDao.deleteAll();
    }
}
