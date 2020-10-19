package br.edu.ifba.ads.inf008.monitoring.entities;

public class Euclidean extends Unity {

	public Euclidean(String id, float latitude, float longitude, boolean videoCamera, boolean thermomether, boolean co2,
			boolean ch4) {
		super(id, latitude, longitude, videoCamera, thermomether, co2, ch4);
	}

	@Override
	public float calculateDistance(Point monitoringPoint) {
		Point point = this.getPoint();

		return (float)Math.sqrt(Math.pow(Math.abs(point.getLatitude() - monitoringPoint.getLatitude()), 2)
				+ Math.pow(Math.abs(point.getLongitude() - monitoringPoint.getLongitude()), 2));
	}

	@Override
	public void updatePosition(float latitude, float longitude) {
		this.setPoint(latitude, longitude);
	}

	@Override
	public void updateAvailable(boolean availabe) {
		this.setAvailable(availabe);
		
	}
	
	

}
