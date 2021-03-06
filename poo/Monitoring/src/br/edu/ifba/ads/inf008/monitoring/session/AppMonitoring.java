package br.edu.ifba.ads.inf008.monitoring.session;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxCrud.Delete;
import com.mysql.cj.x.protobuf.MysqlxCrud.Update;

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
	
	public void deleteUnity(String id) throws Exception {
		this.unityDAOIF.delete(id);
	}
	
	public void update(Unity unity) throws Exception {
		this.unityDAOIF.update(unity);
	}
	
	public Unity getUnity(String id) throws Exception {
		return this.unityDAOIF.getUnity(id);
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
			this.unityDAOIF.updateMonitored(manhattan);
		}

		return possibleUnity.getId();
	}
	
	public ArrayList<Unity> getAll() throws Exception {
		ArrayList<Unity> unities = this.unityDAOIF.getAll();
		
		return unities;
	}
}
