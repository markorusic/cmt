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
            String key = "&key=" + "AIzaSyDHPnkz7R1qmZA0KnYphb8k0HEBRxMbN6U";
            String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + key;
            if(address.getNumber() != 0)
                url += address.getNumber() + "+";
            String street = address.getStreet();
            url += street.replace(" ", "+");

            AddressResponseDto addressDto = restTemplate.postForObject(url, null, AddressResponseDto.class);
            System.out.println(" " + addressDto.getGeometry().getLocation().getLat() + " " + addressDto.getGeometry().getLocation().getLng());
            address.setLatitude(addressDto.getGeometry().getLocation().getLat());
            address.setLongitude(addressDto.getGeometry().getLocation().getLng());


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


    public List<Address> getPickupSpot(double lon, double lat, int pageNumber, int nPerPage) {


//        int latitude = (int) Math.round(lat);
//        int longitude = (int) Math.round(lon);

        double minlat = lat - 1, maxlat = lat + 1;
        double minlon = lon - 1, maxlon = lon + 1;

        Query query = new Query();
        query.addCriteria(Criteria.where("latitude").gte(minlat));
//        query.addCriteria(Criteria.where("latitude").lte(maxlat));

        query.addCriteria(Criteria.where("longitude").gte(minlon));
//        query.addCriteria(Criteria.where("longitude").lte(maxlon));
        query.limit(nPerPage);
        query.skip(pageNumber);
        List<Address> addresses = mongoTemplate.find(query, Address.class);

        return addresses;
    }

    public void removePickupSpot(){

            Query query = new Query();
            query.addCriteria(Criteria.where("latitude").gt(0));
            mongoTemplate.remove(query, Address.class);
    }
}
