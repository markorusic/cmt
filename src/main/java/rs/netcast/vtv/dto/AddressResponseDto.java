package rs.netcast.vtv.dto;

public class AddressResponseDto {

    private String formatted_address;

    private String status;

    private GeometryResponseDto geometry;

    public AddressResponseDto() {
    }

    public String getFormatted_address() {
        return formatted_address;
    }

    public void setFormatted_address(String formatted_address) {
        this.formatted_address = formatted_address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public GeometryResponseDto getGeometry() {
        return geometry;
    }

    public void setGeometry(GeometryResponseDto geometry) {
        this.geometry = geometry;
    }
}
