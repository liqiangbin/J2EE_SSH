package shiep.dao;

import java.util.List;

import shiep.bean.Courseoutline;
import shiep.bean.Teachingprogress;

public interface TeachingprogressDao {
	public List<Teachingprogress> findByStatus(String did);
	public void checked(Teachingprogress  teachingprogress);
	public List queryForPage(final String hql,final int offset,final int length);
	public int getAllRowCount(String hql);
	public List<Teachingprogress> findall();
	public List<Teachingprogress> findByTid(String tid);
	public List<Teachingprogress> findByTeacher(String tid);
	public List<Teachingprogress> findByTerm(String tid,String term);
	public void save(Teachingprogress  teachingprogress);
}
