package shiep.service;

import shiep.bean.Course;
import shiep.bean.PageBean;

public interface CourseService {
	public PageBean queryForPage(int pageSize,int currentPage);
	public PageBean search(int pageSize,int currentPage,Course course);

}
