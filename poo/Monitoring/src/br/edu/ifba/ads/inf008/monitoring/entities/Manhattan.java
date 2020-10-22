package br.edu.ifba.ads.inf008.monitoring.entities;

public class Manhattan extends Unity {

	public Manhattan(String id, float latitude, float longitude, boolean videoCamera, boolean thermomether, boolean co2,
			boolean ch4) {
		super(id, latitude, longitude, videoCamera, thermomether, co2, ch4);
	}

	@Override
	public float calculateDistance(Point monitoringPoint) {
		Point point = this.getPoint();
		return (Math.abs(point.getLatitude() - monitoringPoint.getLatitude()))
				+ (Math.abs(point.getLongitude() - monitoringPoint.getLongitude()));
	}

	@Override
	public void updatePosition(float latitude, float longitude) {
		this.setPoint(latitude, longitude);

	}

	@Override
	public void updateAvailable(boolean available) {
		this.setAvailable(available);
	}
	
	

}
