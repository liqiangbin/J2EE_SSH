package shiep.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import shiep.bean.Departmenthead;
import shiep.bean.Teacher;
import shiep.dao.AdminDao;
import shiep.dao.DepartmentheadDao;
import shiep.dao.TeacherDao;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
public class LoginAction  extends ActionSupport {
	private Departmenthead departmenthead;
	private Teacher teacher;
	private String username;
	private String password;
	private String enter;
	@Resource
	private DepartmentheadDao departmentheaddao;
	@Resource
	private TeacherDao teacherdao;
	@Resource
	private AdminDao adminDao;
	public Departmenthead getDepartmenthead() {
		return departmenthead;
	}
	public void setDepartmenthead(Departmenthead departmenthead) {
		this.departmenthead = departmenthead;
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
	public DepartmentheadDao getDepartmentheaddao() {
		return departmentheaddao;
	}
	public void setDepartmentheaddao(DepartmentheadDao departmentheaddao) {
		this.departmentheaddao = departmentheaddao;
	}
	
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public TeacherDao getTeacherdao() {
		return teacherdao;
	}
	public void setTeacherdao(TeacherDao teacherdao) {
		this.teacherdao = teacherdao;
	}
	public AdminDao getAdminDao() {
		return adminDao;
	}
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	public String login() throws Exception{
		if(departmentheaddao.login(username, password)&&"系主任登录".equals(enter)){
			//System.out.println(departmentheaddao.login(username, password));
		return  "deptsuccess";}
		else if(adminDao.adminLogin(username, password)&&"管理员登录".equals(enter)){
			ActionContext ctx=ActionContext.getContext();
			ctx.getSession().put("username", username);
			return "adminsuccess";
		}
		else if(teacherdao.teacherLogin(username, password)&&"教师登录".equals(enter)){
			return "teachersuccess";
		}
		return  "false";
	
	
	}
}
