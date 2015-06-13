package shiep.dao;

import java.util.List;

import shiep.bean.Courseopen;

public interface CourseOpenDao {
	
	public List<Courseopen> showCourseOpenInfo();
	public void deleteCourseOpenInfo(String coid);
	public List queryForPage(final String hql,final int offset,final int length);
	public int getAllRowCount(String hql);

}
