package shiep.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import shiep.dao.AdminDao;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class AdminAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private AdminDao adminDao;
	private String username;
	private String password;
	private String enter;
	
	public AdminDao getAdminDao() {
		return adminDao;
	}
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	
	
	public String getEnter() {
		return enter;
	}
	public void setEnter(String enter) {
		this.enter = enter;
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
	
//	public String superLogin(){
////		System.out.println(username+"@@@@@@@@@"+password);
//		String pwd=password.replace(",", " ").trim();
//	
//		boolean flag=adminDao.adminLogin(username, pwd);
//		ActionContext ctx=ActionContext.getContext();
//		ctx.getSession().put("username", username);
//
//		if(flag&&"π‹¿Ì‘±µ«¬º".equals(enter)){
//			return "adminsuccess";
//		}else{
//			return "input";
//		}
//		}
	
	
	

}
