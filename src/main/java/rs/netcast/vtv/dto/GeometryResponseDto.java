package rs.netcast.vtv.dto;

public class GeometryResponseDto {

    private LocationDto location;

    private String location_type;


    public GeometryResponseDto() {
    }

    public LocationDto getLocation() {
        return location;
    }

    public void setLocation(LocationDto location) {
        this.location = location;
    }

    public String getLocation_type() {
        return location_type;
    }

    public void setLocation_type(String location_type) {
        this.location_type = location_type;
    }
}
