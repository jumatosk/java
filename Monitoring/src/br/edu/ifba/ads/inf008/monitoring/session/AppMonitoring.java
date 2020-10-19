package br.edu.ifba.ads.inf008.monitoring.session;

import java.sql.SQLException;
import java.util.ArrayList;

import br.edu.ifba.ads.inf008.monitoring.dao.UnityDAOIF;
import br.edu.ifba.ads.inf008.monitoring.dao.UnitySQLDAO;
import br.edu.ifba.ads.inf008.monitoring.entities.Euclidean;
import br.edu.ifba.ads.inf008.monitoring.entities.Manhattan;
import br.edu.ifba.ads.inf008.monitoring.entities.Point;
import br.edu.ifba.ads.inf008.monitoring.entities.Unity;

public class AppMonitoring implements AppMonitoringIF {
	private UnityDAOIF unityDAOIF;

	public AppMonitoring() throws SQLException {
		this.unityDAOIF = new UnitySQLDAO();
	}

	public void addEuclideanUnity(String id, float latitude, float longitude, boolean videoCamera, boolean thermomether,
			boolean co2, boolean ch4) throws Exception {
		Euclidean euclidean = new Euclidean(id, latitude, longitude, videoCamera, thermomether, co2, ch4);
		
		this.unityDAOIF.save(euclidean);
	};

	public void addManhattanUnity(String id, float latitude, float longitude, boolean videoCamera, boolean thermomether,
			boolean co2, boolean ch4) throws Exception {
		Manhattan manhattan = new Manhattan(id, latitude, longitude, videoCamera, thermomether, co2, ch4);

		this.unityDAOIF.save(manhattan);
	}

	@Override
	public Unity possibleUnity(float latitude, float longitude, boolean videoCamera, boolean thermomether, boolean co2,
			boolean ch4) throws Exception {

		Unity selectedUnity = null;
		ArrayList<Unity> allPossible = this.unityDAOIF.getAllPossibleUnity(videoCamera, thermomether, co2, ch4);
		Point areaPoint = new Point(latitude, longitude);
		double distance = 0;
		double shortestDistance = 0;

		distance = allPossible.get(0).calculateDistance(areaPoint);


		for (Unity unity : allPossible) {
			shortestDistance = unity.calculateDistance(areaPoint);
			if (shortestDistance <= distance) {
				selectedUnity = unity;
			}
		}

		return selectedUnity;
	}
	
	@Override
	public String monitorar(float abscissa, float ordenada, boolean video, boolean termometro, boolean co2, boolean ch4)
			throws Exception {
		Unity possibleUnity = this.possibleUnity(abscissa, ordenada, video, termometro, co2, ch4);

		if (possibleUnity instanceof Euclidean) {
			Unity euclidean = new Euclidean(possibleUnity.getId(), abscissa, ordenada, video, termometro, co2, ch4);
			this.unityDAOIF.update(euclidean);
		} 
		else if (possibleUnity instanceof Manhattan) {
			Unity manhattan = new Manhattan(possibleUnity.getId(), abscissa, ordenada, video, termometro, co2, ch4);
			this.unityDAOIF.update(manhattan);
		}

		return possibleUnity.getId();

	}
}
