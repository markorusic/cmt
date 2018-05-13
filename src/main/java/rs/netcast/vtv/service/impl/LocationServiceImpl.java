package rs.netcast.vtv.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rs.netcast.vtv.dao.AddressDao;
import rs.netcast.vtv.domain.Address;
import rs.netcast.vtv.domain.Score;
import rs.netcast.vtv.domain.ScorePerHour;
import rs.netcast.vtv.dto.AddressResponseDto;
import rs.netcast.vtv.dto.LocationDto;
import rs.netcast.vtv.service.LocationService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;


@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    AddressDao addressDao;

    public void extendLocationInfo(){
        List<Address> addresses = addressDao.findAll();
        for (Address address : addresses) {
//            if(address.getLatitude() != null && address.getLongitude() != null)
//                continue;

            RestTemplate restTemplate = new RestTemplate();
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_JSON_VALUE);

            String url = "https://maps.googleapis.com/maps/api/geocode/json?address=";
            if(address.getNumber() != 0)
                url += address.getNumber() + "+";
            String street = address.getStreet();
            url += street.replace(" ", "+");

            AddressResponseDto addressDto = restTemplate.postForObject(url, null, AddressResponseDto.class);

            address.setLatitude(addressDto.getGeometry().getLocation().getLat());
            address.setLongitude(addressDto.getGeometry().getLocation().getLng());

            String key = "&key=" + "AIzaSyDHPnkz7R1qmZA0KnYphb8k0HEBRxMbN6U";

            addressDao.save(address);

        }
    }


    @Autowired
    MongoTemplate mongoTemplate;


//    to do
//    public void successPickUp(LocationDto locationDto){
//        List<Address> pickupAddresses = addressDao.findByLatitudeAndLongitude(locationDto.getLat(), locationDto.getLng());
//        for (Address address:pickupAddresses) {
//            //ScorePerHour scorePerHour = new ScorePerHour();
//           // Score score = new Score();
//            //score.setTotal(score.ge);
//
//
//            Query query = new Query();
//            GregorianCalendar calendar = new GregorianCalendar();
//            int h = calendar.get(GregorianCalendar.HOUR);
//            if(h == 0)
//                h = 24;
//            String hour = "h" + h;
//
//            query.addCriteria(Criteria.where(hour).is());
//            address.setScorePerHour();
//        }
//    }


    public List<Address> getPickupSpot(double lon, double lat){

        Query query = new Query();
        query.addCriteria(Criteria.where("latitude").gt(0));
        List<Address> addresses = mongoTemplate.find(query, Address.class);
        return addresses;


//        List<String> result = addresses.stream()                // convert list to stream
//                .filter(line -> !"".equals(line))     // we dont like mkyong
//                .collect(Collectors.toList());
//                .stream()
//                .filter(line -> !"mkyong".equals(line))     // we dont like mkyong
//                .collect(Collectors.toList());  ;

    }
}
