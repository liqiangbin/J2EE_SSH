package shiep.dao;

import java.util.List;

import shiep.bean.Courseoutline;

public interface CourseoutlineDao {
	public List<Courseoutline> findByStatus(String did);
	public void checked(Courseoutline  courseoutline);

}
