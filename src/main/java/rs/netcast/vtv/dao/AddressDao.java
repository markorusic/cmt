package rs.netcast.vtv.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import rs.netcast.vtv.domain.Address;

import java.util.List;

@RepositoryRestResource(collectionResourceRel="address", path="address")
public interface AddressDao extends MongoRepository<Address, String>{


    List<Address> findByLatitudeAndLongitude(double latitude, double longitude);

//    @Query
//    int incrementPickUpScore(String hoursKey, String lng, String lat);

}
