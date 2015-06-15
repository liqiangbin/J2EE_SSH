package shiep.service;

import shiep.bean.Courseoutline;
import shiep.bean.PageBean;
import shiep.bean.Teachingprogress;
import shiep.bean.Testprogress;

public interface AllmessageService {
	public PageBean queryForPageOutline(int pageSize,int currentPage,int status,String term);
	public PageBean queryForPageTeaching(int pageSize,int currentPage,int status,String term);
	public PageBean queryForPageTest(int pageSize,int currentPage,int status,String term);

}
