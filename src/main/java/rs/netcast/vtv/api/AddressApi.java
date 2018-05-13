package rs.netcast.vtv.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import rs.netcast.vtv.dao.AddressDao;
import rs.netcast.vtv.domain.Address;
import rs.netcast.vtv.dto.LocationDto;
import rs.netcast.vtv.exceptions.ParsingException;
import rs.netcast.vtv.exceptions.RepositoryLayerException;
import rs.netcast.vtv.service.LocationService;
import rs.netcast.vtv.service.ParsingService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value="/address")
public class AddressApi {

    @Autowired
    AddressDao addressDao;


    @Autowired
    LocationService locationService;

    @RequestMapping(value = "/address-all", method = RequestMethod.DELETE)
    public void deleteAllAddress() {
        // System.out.println("Channel id: " + channelId);
        addressDao.deleteAll();
    }


    @RequestMapping(value = "/pickup-spots", method = RequestMethod.POST)
    public @ResponseBody List<Address> getPickupSpots(@RequestBody LocationDto locationDto)  {
        // System.out.println("Channel id: " + channelId);
        return locationService.getPickupSpot(locationDto.getLng(), locationDto.getLat());
    }
}
