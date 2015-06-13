package shiep.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import shiep.bean.Announce;
import shiep.bean.Courseoutline;
import shiep.dao.CourseoutlineDao;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
public class CourseoutlineAction  extends ActionSupport{
	private  Courseoutline  courseoutline;
	@Resource
	private  CourseoutlineDao courseoutlinedao;
	//------------------------------
	public Courseoutline getCourseoutline() {
		return courseoutline;
	}
	public void setCourseoutline(Courseoutline courseoutline) {
		this.courseoutline = courseoutline;
	}
	public CourseoutlineDao getCourseoutlinedao() {
		return courseoutlinedao;
	}
	public void setCourseoutlinedao(CourseoutlineDao courseoutlinedao) {
		this.courseoutlinedao = courseoutlinedao;
	}
	public String findByStatus() throws Exception{
		
		 ActionContext context=ActionContext.getContext();
		 List<Courseoutline> list=(List<Courseoutline>)courseoutlinedao.findByStatus(courseoutline.getDid());
		// Map request=(Map) ActionContext.getContext().get("request");
      //  request.put("list", list); 
		 context.getSession().put("NoStatusOutline", list);
		 return "nostatus";
	}
	public String checked() throws Exception{
//		System.out.println("*******");
//		System.out.println(courseoutline.getTerm());
//		System.out.println(courseoutline.getId());
//		System.out.println(courseoutline.getStatus());
//		System.out.println(courseoutline.getMessage());
		courseoutlinedao.checked(courseoutline);
		return "checked";
	}
}
