package shiep.dao;

import java.util.List;

import shiep.bean.Course;

public interface CourseDao {
	
	public List<Course> showAllCourseInfo();
	public void deleteCourse(String cid);
	public void addCourse(Course course);
	public List<Course> searchBytable(Course course);
	public List queryForPage(final String hql,final int offset,final int length);
	public int getAllRowCount(String hql);
	
	

}
