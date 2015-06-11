package shiep.dao;

import java.util.List;
import shiep.bean.Matchmessage;

public interface MatchmessageDao {
	public List<Matchmessage> findByDeptstatus(String dept);
	public void sortTeacher(Matchmessage matchmessage);
}
