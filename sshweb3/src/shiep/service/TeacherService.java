package shiep.service;

import shiep.bean.PageBean;
import shiep.bean.Teacher;

public interface TeacherService {
	public PageBean queryForPage(int pageSize,int currentPage);
	public PageBean search(int pageSize,int currentPage,Teacher teacher);
}
