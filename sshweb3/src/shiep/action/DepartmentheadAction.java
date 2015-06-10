package shiep.action;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import shiep.bean.Departmenthead;
import shiep.dao.DepartmentheadDao;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@SuppressWarnings("serial")
@Controller
public class DepartmentheadAction  extends ActionSupport{
	private Departmenthead departmenthead;
	private String username;
	private String password;
	private String enter;
	@Resource
	private DepartmentheadDao departmentheaddao;
	
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
	@SuppressWarnings("unchecked")
	public String all() throws Exception {
		 List<Departmenthead> list=departmentheaddao.findAllDepartmenthead();
		 ActionContext context=ActionContext.getContext();
		 context.getSession().put("list", list);
		return "success";
    }
	public String findbyId() throws Exception{
		 ActionContext context=ActionContext.getContext();
		 List<Departmenthead> list=departmentheaddao.findDepartmentheadById(departmenthead.getId());
		context.getSession().put("self", list);
		 return "self";
	}
	public String updatemyself() throws Exception{
		 departmentheaddao.updatemyself(departmenthead);
		 return "updated";
	}
	public String login() throws Exception{
		if(departmentheaddao.login(username, password)&&"ÏµÖ÷ÈÎµÇÂ¼".equals(enter)){
			//System.out.println(departmentheaddao.login(username, password));
		return  "success";}
		return  "false";
	}
}
