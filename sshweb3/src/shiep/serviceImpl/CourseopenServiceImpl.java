package shiep.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import shiep.bean.Courseopen;
import shiep.bean.PageBean;
import shiep.bean.Teacher;
import shiep.dao.CourseDao;
import shiep.dao.CourseOpenDao;
import shiep.service.CourseopenService;

@Service("courseopenService")
public class CourseopenServiceImpl implements CourseopenService {
	@Resource
	private CourseOpenDao courseOpenDao;
	
	public void setCourseDao(CourseDao courseDao) {
		this.courseOpenDao = courseOpenDao;
	}
	
	

	@Override
	public PageBean queryForPage(int pageSize, int page) {
		final String hql = "from shiep.bean.Courseopen";        //鏌ヨ璇彞
        int allRow = courseOpenDao.getAllRowCount(hql);    //鎬昏褰曟暟
     //   System.out.println(allRow+"@@@@@@@@");
        int totalPage = PageBean.countTotalPage(pageSize, allRow);    //鎬婚〉鏁�
        final int offset = PageBean.countOffset(pageSize, page);    //褰撳墠椤靛紑濮嬭褰�
        final int length = pageSize;    //姣忛〉璁板綍鏁�
        final int currentPage = PageBean.countCurrentPage(page);
        @SuppressWarnings("unchecked")
		List<Courseopen> list = courseOpenDao.queryForPage(hql,offset, length);        //"涓�〉"鐨勮褰�
        
        //鎶婂垎椤典俊鎭繚瀛樺埌Bean涓�
        PageBean pageBean = new PageBean();
        pageBean.setPageSize(pageSize);    
        pageBean.setCurrentPage(currentPage);
        pageBean.setAllRow(allRow);
        pageBean.setTotalPage(totalPage);
        pageBean.setList(list);
        pageBean.init();
        return pageBean;
	}

	@Override
	public PageBean search(int pageSize, int page, Courseopen courseopen) {
		final String hql="from shiep.bean.Courseopen  where cname like '%"+courseopen.getCname()+"%'";       //鏌ヨ璇彞
        int allRow = courseOpenDao.getAllRowCount(hql);    //鎬昏褰曟暟
        int totalPage = PageBean.countTotalPage(pageSize, allRow);    //鎬婚〉鏁�
        final int offset = PageBean.countOffset(pageSize, page);    //褰撳墠椤靛紑濮嬭褰�
        final int length = pageSize;    //姣忛〉璁板綍鏁�
        final int currentPage = PageBean.countCurrentPage(page);
        @SuppressWarnings("unchecked")
		List<Courseopen> list = courseOpenDao.queryForPage(hql,offset, length);        //"涓�〉"鐨勮褰�
        
        //鎶婂垎椤典俊鎭繚瀛樺埌Bean涓�
        PageBean pageBean = new PageBean();
        pageBean.setPageSize(pageSize);    
        pageBean.setCurrentPage(currentPage);
        pageBean.setAllRow(allRow);
        pageBean.setTotalPage(totalPage);
        pageBean.setList(list);
        pageBean.init();
        return pageBean;
	}

}
