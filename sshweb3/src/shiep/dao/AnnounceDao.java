package shiep.dao;

import java.util.List;

import shiep.bean.Announce;

public interface AnnounceDao {
	public List<Announce> findByStatus();
	public List <Announce> searchBytable(Announce announce);
	public List<Announce> findBydept(String did);
	public List <Announce> searchBydept(String did,Announce announce);
	public void delete(int id);
	public void add(Announce announce);

}
