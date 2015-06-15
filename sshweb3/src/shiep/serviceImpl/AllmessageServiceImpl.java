package shiep.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import shiep.bean.Courseoutline;
import shiep.bean.PageBean;
import shiep.bean.Teacher;
import shiep.bean.Teachingprogress;
import shiep.bean.Testprogress;
import shiep.dao.CourseoutlineDao;
import shiep.dao.TeachingprogressDao;
import shiep.dao.TestprogressDao;
import shiep.service.AllmessageService;

@Service("AllmessageService")
public class AllmessageServiceImpl  implements AllmessageService{
	@Resource
	private CourseoutlineDao courseoutlinedao;
	
	@Resource
	private TeachingprogressDao teachingprogressdao;
	@Resource
	private TestprogressDao testprogressdao;
//````````````````````构造方法
	public CourseoutlineDao getCourseoutlinedao() {
		return courseoutlinedao;
	}

	public void setCourseoutlinedao(CourseoutlineDao courseoutlinedao) {
		this.courseoutlinedao = courseoutlinedao;
	}

	public TeachingprogressDao getTeachingprogressdao() {
		return teachingprogressdao;
	}

	public void setTeachingprogressdao(TeachingprogressDao teachingprogressdao) {
		this.teachingprogressdao = teachingprogressdao;
	}

	public TestprogressDao getTestprogressdao() {
		return testprogressdao;
	}

	public void setTestprogressdao(TestprogressDao testprogressdao) {
		this.testprogressdao = testprogressdao;
	}
	//`````````````````````````

	@Override
	public PageBean queryForPageOutline(int pageSize, int page,int status,String term) {
		final String hql = "from shiep.bean.Courseoutline where status='"+status+"' and term='"+term+"'";        //鏌ヨ璇彞
        int allRow = courseoutlinedao.getAllRowCount(hql);    //鎬昏褰曟暟
        int totalPage = PageBean.countTotalPage(pageSize, allRow);    //鎬婚〉鏁�
        final int offset = PageBean.countOffset(pageSize, page);    //褰撳墠椤靛紑濮嬭褰�
        final int length = pageSize;    //姣忛〉璁板綍鏁�
        final int currentPage = PageBean.countCurrentPage(page);
        @SuppressWarnings("unchecked")
		List<Courseoutline> list = courseoutlinedao.queryForPage(hql,offset, length);        //"涓�〉"鐨勮褰�
        
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
	public PageBean queryForPageTeaching(int pageSize, int page,int status,String term) {
		final String hql = "from shiep.bean.Teachingprogress where status='"+status+"' and term='"+term+"'";        //鏌ヨ璇彞
        int allRow = courseoutlinedao.getAllRowCount(hql);    //鎬昏褰曟暟
        int totalPage = PageBean.countTotalPage(pageSize, allRow);    //鎬婚〉鏁�
        final int offset = PageBean.countOffset(pageSize, page);    //褰撳墠椤靛紑濮嬭褰�
        final int length = pageSize;    //姣忛〉璁板綍鏁�
        final int currentPage = PageBean.countCurrentPage(page);
        @SuppressWarnings("unchecked")
		List<Teachingprogress> list = teachingprogressdao.queryForPage(hql,offset, length);        //"涓�〉"鐨勮褰�
        
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
	public PageBean queryForPageTest(int pageSize, int page,int status,String term) {
		final String hql = "from shiep.bean.Testprogress where status='"+status+"' and term='"+term+"'";        //鏌ヨ璇彞
        int allRow = testprogressdao.getAllRowCount(hql);    //鎬昏褰曟暟
        int totalPage = PageBean.countTotalPage(pageSize, allRow);    //鎬婚〉鏁�
        final int offset = PageBean.countOffset(pageSize, page);    //褰撳墠椤靛紑濮嬭褰�
        final int length = pageSize;    //姣忛〉璁板綍鏁�
        final int currentPage = PageBean.countCurrentPage(page);
        @SuppressWarnings("unchecked")
		List<Testprogress> list = testprogressdao.queryForPage(hql,offset, length);        //"涓�〉"鐨勮褰�
        
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
