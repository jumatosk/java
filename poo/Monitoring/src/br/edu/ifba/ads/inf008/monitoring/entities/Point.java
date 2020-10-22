package br.edu.ifba.ads.inf008.monitoring.entities;

public class Point {
	private float latitude;
	private float longitude;
	
	public Point(float latitude, float longitude) {
		this.setLatitude(latitude);
		this.setLongitude(longitude);
	}

	public float getLatitude() {
		return latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	private void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	private void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	
	
}
