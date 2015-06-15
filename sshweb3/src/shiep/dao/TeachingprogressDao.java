package shiep.dao;

import java.util.List;

import shiep.bean.Courseoutline;
import shiep.bean.Teachingprogress;

public interface TeachingprogressDao {
	public List<Teachingprogress> findByStatus(String did);
	public void checked(Teachingprogress  teachingprogress);
	public List queryForPage(final String hql,final int offset,final int length);
	public int getAllRowCount(String hql);
}
