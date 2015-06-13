package shiep.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import shiep.bean.PageBean;
import shiep.bean.Teacher;
import shiep.dao.TeacherDao;
import shiep.service.TeacherService;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {
	@Resource
	private TeacherDao teacherDao;
	
	public void setTeacherDao(TeacherDao teacherDao){
		this.teacherDao=teacherDao;
	}

	public PageBean queryForPage(int pageSize, int page) {
		final String hql = "from shiep.bean.Teacher";        //鏌ヨ璇彞
        int allRow = teacherDao.getAllRowCount(hql);    //鎬昏褰曟暟
        int totalPage = PageBean.countTotalPage(pageSize, allRow);    //鎬婚〉鏁�
        final int offset = PageBean.countOffset(pageSize, page);    //褰撳墠椤靛紑濮嬭褰�
        final int length = pageSize;    //姣忛〉璁板綍鏁�
        final int currentPage = PageBean.countCurrentPage(page);
        @SuppressWarnings("unchecked")
		List<Teacher> list = teacherDao.queryForPage(hql,offset, length);        //"涓�〉"鐨勮褰�
        
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
	public PageBean search(int pageSize, int page,Teacher teacher) {
		final String hql="from shiep.bean.Teacher  where name like '%"+teacher.getName()+"%'";       //鏌ヨ璇彞
        int allRow = teacherDao.getAllRowCount(hql);    //鎬昏褰曟暟
        int totalPage = PageBean.countTotalPage(pageSize, allRow);    //鎬婚〉鏁�
        final int offset = PageBean.countOffset(pageSize, page);    //褰撳墠椤靛紑濮嬭褰�
        final int length = pageSize;    //姣忛〉璁板綍鏁�
        final int currentPage = PageBean.countCurrentPage(page);
        @SuppressWarnings("unchecked")
		List<Teacher> list = teacherDao.queryForPage(hql,offset, length);        //"涓�〉"鐨勮褰�
        
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
