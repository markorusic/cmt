package rs.netcast.vtv.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import rs.netcast.vtv.domain.Address;

@RepositoryRestResource(collectionResourceRel="pickup_data_web", path="pickup-data")
public interface PickupDataWebDao extends MongoRepository<Address, String> {
}
