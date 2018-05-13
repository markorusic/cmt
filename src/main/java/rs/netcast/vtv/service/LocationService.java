package rs.netcast.vtv.service;

import rs.netcast.vtv.domain.Address;
import rs.netcast.vtv.dto.LocationDto;

import java.util.List;

public interface LocationService {

    void extendLocationInfo();

    List<Address> getPickupSpot(double lon, double lat, int pageNumber, int nPerPage);
}
