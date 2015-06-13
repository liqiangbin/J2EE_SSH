package shiep.service;

import shiep.bean.PageBean;

public interface CourseService {
	public PageBean queryForPage(int pageSize,int currentPage);

}
