package rs.netcast.vtv.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import rs.netcast.vtv.domain.Address;

@RepositoryRestResource(collectionResourceRel="address", path="address")
public interface AddressDao extends MongoRepository<Address, String>{

}
