package shiep.dao;

import java.util.List;

import shiep.bean.Teachingprogress;
import shiep.bean.Testprogress;

public interface TestprogressDao {
	public List<Testprogress> findByStatus(String did);
	public void checked(Testprogress  testprogress);
	public List queryForPage(final String hql,final int offset,final int length);
	public int getAllRowCount(String hql);
	public List<Testprogress> findall();
	public List<Testprogress> findByTeacher(String tid);
	public List<Testprogress> findByTerm(String tid,String term);
}
