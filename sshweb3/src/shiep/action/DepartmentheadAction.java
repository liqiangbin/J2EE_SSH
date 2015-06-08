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
        // Map request=(Map) ActionContext.getContext().get("request");
         //request.put("list1",list); 
		 ActionContext context=ActionContext.getContext();
		 context.getSession().put("list", list);
		return "success";
    }
	
}
