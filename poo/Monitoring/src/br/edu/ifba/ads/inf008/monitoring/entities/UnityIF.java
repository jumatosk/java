package br.edu.ifba.ads.inf008.monitoring.entities;

public interface UnityIF {
	public float calculateDistance(Point monitoringPoint);
	public void updatePosition(float latitude, float longitude);
	public void updateAvailable(boolean availabe);
}
