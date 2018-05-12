package rs.netcast.vtv.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="adress")
public class Address {
	@Id
	private String id;
	
	private String street;
	
	private int number;
	
	private double latitude;
	
	private double longitude;
	
	private ScorePerHour scorePerHour;
	
	public Address() {
		super();
	}
	
	public Address(String id, String street, int number, double latitude, double longitude) {
		super();
		this.id = id;
		this.street = street;
		this.number = number;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Address(String id, String street, int number, double latitude, double longitude, ScorePerHour scorePerHour) {
		super();
		this.id = id;
		this.street = street;
		this.number = number;
		this.latitude = latitude;
		this.longitude = longitude;
		this.scorePerHour = scorePerHour;
	}

	public ScorePerHour getScorePerHour() {
		return scorePerHour;
	}

	public void setScorePerHour(ScorePerHour scorePerHour) {
		this.scorePerHour = scorePerHour;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	
}
