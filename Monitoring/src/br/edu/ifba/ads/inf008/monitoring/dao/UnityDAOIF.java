package br.edu.ifba.ads.inf008.monitoring.dao;

import java.util.ArrayList;

import br.edu.ifba.ads.inf008.monitoring.entities.Unity;

public interface UnityDAOIF {
	public void save(Unity unity) throws Exception;
	public ArrayList<Unity> getAllPossibleUnity(boolean videoCamera, boolean thermomether, boolean co2, boolean ch4) throws Exception;
	public Unity getUnity(String id) throws Exception;
	public ArrayList<Unity> getAll() throws Exception;
	public void update(Unity unity) throws Exception;
	public void delete(String id) throws Exception;
}
