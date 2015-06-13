package shiep.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import shiep.bean.Course;
import shiep.bean.Courseopen;
import shiep.bean.PageBean;
import shiep.dao.CourseDao;
import shiep.dao.CourseOpenDao;
import shiep.service.CourseService;
import shiep.service.CourseopenService;

import com.opensymphony.xwork2.ActionSupport;
@SuppressWarnings("serial")
@Controller
public class CourseopenAction extends ActionSupport{
	
	private Courseopen courseopen;
	@Resource
	private CourseopenService courseopenService;

	

	public void setCourseopenService(CourseopenService courseopenService) {
		this.courseopenService = courseopenService;
	}


	private int page;
	
	private PageBean pageBean;



	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
	
	
	@Resource
	private CourseOpenDao courseOpenDao;



	public Courseopen getCourseopen() {
		return courseopen;
	}

	public void setCourseopen(Courseopen courseopen) {
		this.courseopen = courseopen;
	}
	
	public String showPage() throws Exception{
		this.pageBean=courseopenService.queryForPage(2, page);
		return "pagelist";
	}
	
	public String search() throws Exception{
		this.pageBean=courseopenService.search(2, page,courseopen);
		return "pagelist";
	}
	
	public String delete() throws Exception{
		System.out.println(courseopen.getCid());
		courseOpenDao.deleteCourseOpenInfo(courseopen.getCid());
		System.out.println("####");
		return "disp";
	}
	
	
	

}
