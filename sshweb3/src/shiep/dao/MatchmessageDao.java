package shiep.dao;

import java.util.List;
import shiep.bean.Matchmessage;

public interface MatchmessageDao {
	public List<Matchmessage> findByDeptstatus(String dept);
	public void sortTeacher(Matchmessage matchmessage);
	public List<Matchmessage> findAll();
	public void save(Matchmessage matchmessage);
	public List<Matchmessage> findBytstatus(String dept);
	
}
