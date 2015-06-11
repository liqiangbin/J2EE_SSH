package shiep.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import shiep.bean.Teacher;
import shiep.dao.TeacherDao;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
public class TeacherAction extends ActionSupport{
	private Teacher teacher;
	
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
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEnter() {
		return enter;
	}

	public void setEnter(String enter) {
		this.enter = enter;
	}
	
	public String teacherLogin(){
		String pwd=password.replace(",", " ").trim();
		boolean flag=teacherDao.teacherLogin(username, pwd);
		ActionContext ctx=ActionContext.getContext();
		ctx.getSession().put("username", username);
		if(flag&&"教师登录".equals(enter)){
			return "success";
		}else{
			return "input";
		}
		
	}

	@SuppressWarnings("unchecked")
	public String showAllTeacher() throws Exception{
		List<Teacher> tealist=teacherDao.showAllTeacher();
//		ActionContext ctx=ActionContext.getContext();
//		ctx.getSession().put("list", list);
		Map request=(Map) ActionContext.getContext().get("request");
		request.put("tealist", tealist);
//		System.out.println(tealist.size());
		return "index";
		
	}
	
	public String delete() throws Exception{
		teacherDao.deleteTeacher(teacher.getId());
		return "disp";
	}
	
	public String save() throws Exception{
		try {
			teacherDao.addTeacher(teacher);
		} catch (Exception e) {
			return "input";
		}
		return "disp1";
	}
	
	public String updatePwd() throws Exception{
		
		teacherDao.updatePwd(teacher);
		return "updatepwd";
	}

}
