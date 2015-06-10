package shiep.dao;

import java.util.List;

import shiep.bean.Announce;

public interface AnnounceDao {
	public List<Announce> findByStatus();
	public List <Announce> searchBytable(Announce announce);
	public List<Announce> findBydept(Announce announce);
	public List <Announce> searchBydept(Announce announce);

}
