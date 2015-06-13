package shiep.serviceImpl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import shiep.bean.PageBean;
import shiep.bean.Teacher;
import shiep.dao.CourseDao;
import shiep.service.CourseService;

@Service("courseService")
public class CourseServiceImpl implements CourseService {
	@Resource
	private CourseDao courseDao;
	
//	private PageUtil pageUtil;
	
	
	
	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}
	
	

	@Override
	public PageBean queryForPage(int pageSize, int page) {
		final String hql = "from shiep.bean.Course";        //鏌ヨ璇彞
        int allRow = courseDao.getAllRowCount(hql);    //鎬昏褰曟暟
     //   System.out.println(allRow+"@@@@@@@@");
        int totalPage = PageBean.countTotalPage(pageSize, allRow);    //鎬婚〉鏁�
        final int offset = PageBean.countOffset(pageSize, page);    //褰撳墠椤靛紑濮嬭褰�
        final int length = pageSize;    //姣忛〉璁板綍鏁�
        final int currentPage = PageBean.countCurrentPage(page);
        @SuppressWarnings("unchecked")
		List<Teacher> list = courseDao.queryForPage(hql,offset, length);        //"涓�〉"鐨勮褰�
        
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
