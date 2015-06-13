package shiep.service;

import shiep.bean.Courseopen;
import shiep.bean.PageBean;

public interface CourseopenService {
	public PageBean queryForPage(int pageSize,int currentPage);
	public PageBean search(int pageSize,int currentPage,Courseopen course);

}
