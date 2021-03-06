package shiep.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import shiep.bean.Course;
import shiep.bean.PageBean;
import shiep.dao.CourseDao;
import shiep.service.CourseService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
public class CourseAction extends ActionSupport{
	private Course course;
	private List<Course> list;
	//##########
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	//###############3
	@Resource
	private CourseService courseService;

	

	public List<Course> getList() {
		return list;
	}

	public void setList(List<Course> list) {
		this.list = list;
	}

	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
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
	private CourseDao courseDao;
	
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	@SuppressWarnings("unchecked")
	public String showAllCourse() throws Exception{
		List<Course> coulist=courseDao.showAllCourseInfo();
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("coulist", coulist);
		return "index";
	}
	
	public String delete() throws Exception{
//		System.out.println(course.getId());
		courseDao.deleteCourse(course.getId());
		return "disp";
	}
	
	public String save() throws Exception{
		try {
			courseDao.addCourse(course);
			
		} catch (Exception e) {
			return "input";
		}
		return "disp1";
	}
	

	
	public String showPage() throws Exception{
		this.pageBean=courseService.queryForPage(8, page);
		return "pagelist";
	}
	
	public String search() throws Exception{
		this.pageBean=courseService.search(8, page,course);
		return "pagelist";
	}
	public String importdata() throws Exception{
//		System.out.println("%%%%%%%%%"+course.getName());
		//ActionContext context=ActionContext.getContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
	
		//ArrayList<Course> list=(ArrayList<Course>)context.getSession().get("importcourse");
		//System.out.println(s);
//		System.out.println(list.get(0).getName());
		return "fgfg";
	}

	
	
	
}
