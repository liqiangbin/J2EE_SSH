package shiep.dao;

import java.util.List;

import shiep.bean.Courseopen;

public interface CourseOpenDao {
	
	public List<Courseopen> showCourseOpenInfo();
	public void deleteCourseOpenInfo(String coid);

}
