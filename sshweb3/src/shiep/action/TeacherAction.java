package shiep.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import shiep.bean.Announce;
import shiep.bean.PageBean;
import shiep.bean.Teacher;
import shiep.dao.TeacherDao;
import shiep.service.TeacherService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
public class TeacherAction extends ActionSupport{
	private Teacher teacher;
	@Resource
	private TeacherService teacherService;

	

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
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
	private TeacherDao teacherDao;
	private String username;
	private String password;
	private String enter;

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	@SuppressWarnings("unchecked")
	public String showAllTeacher() throws Exception{
		List<Teacher> tealist=teacherDao.showAllTeacher();
		Map request=(Map) ActionContext.getContext().get("request");
		request.put("tealist", tealist);
		return "index";
		
	}
	

	public String delete() throws Exception{
		teacherDao.deleteTeacher(teacher.getId());
		return "disp";
	}
	
	public String save() throws Exception{
		try {
			this.teacher.setPassword(teacher.getId());
			teacherDao.addTeacher(teacher);
		} catch (Exception e) {
			return "input";
		}
		return "add";
	}
	
	public String updatepwd() throws Exception{
		teacherDao.updatePwd(teacher);
		return "disp";
	}
	public String showPage() throws Exception{
		this.pageBean=teacherService.queryForPage(3, page);
		return "pagelist";
	}
	public String search() throws Exception{
		this.pageBean=teacherService.search(3, page,teacher);
		return "pagelist";
	}

}
