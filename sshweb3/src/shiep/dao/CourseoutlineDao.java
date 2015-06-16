package shiep.dao;

import java.util.List;

import shiep.bean.Courseoutline;

public interface CourseoutlineDao {
	public List<Courseoutline> findByStatus(String did);
	public void checked(Courseoutline  courseoutline);
	public List queryForPage(final String hql,final int offset,final int length);
	public int getAllRowCount(String hql);
	public List<Courseoutline> showAllOutline();
	public List<Courseoutline> findByTeacher(String tid);
	public List<Courseoutline> findByTerm(String tid,String term);
}
