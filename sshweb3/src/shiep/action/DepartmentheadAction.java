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
	@Resource
	private DepartmentheadDao departmentheaddao;
	
	public Departmenthead getDepartmenthead() {
		return departmenthead;
	}
	public void setDepartmenthead(Departmenthead departmenthead) {
		this.departmenthead = departmenthead;
	}
	@SuppressWarnings("unchecked")
	public String all() throws Exception {
		 List<Departmenthead> list=departmentheaddao.findAllDepartmenthead();
		 ActionContext context=ActionContext.getContext();
		// System.out.println(list.get(0).getName());
		 context.getSession().put("list", list);
		return "success";
    }
	public String findbyId() throws Exception{
		 ActionContext context=ActionContext.getContext();
		 List<Departmenthead> list=departmentheaddao.findDepartmentheadById(departmenthead.getId());
		context.getSession().put("self", list);
		 return "self";
	}
}
