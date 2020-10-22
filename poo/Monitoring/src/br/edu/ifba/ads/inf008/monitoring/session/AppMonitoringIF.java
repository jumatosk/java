package br.edu.ifba.ads.inf008.monitoring.session;

import br.edu.ifba.ads.inf008.monitoring.entities.Unity;

public interface AppMonitoringIF {
	public Unity possibleUnity(float latitude, float longitude, boolean cameraVideo, boolean thermomether, boolean co2, boolean ch4) throws Exception;
	public String monitorar(float abscissa, float ordenada, boolean cameraVideo, boolean thermomether, boolean co2, boolean ch4) throws Exception;
}
