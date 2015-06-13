package shiep.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import shiep.bean.Teachingprogress;
import shiep.dao.TeachingprogressDao;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
public class TeachingprogressAction  extends ActionSupport{
	private  Teachingprogress  teachingprogress;
	@Resource
	private  TeachingprogressDao teachingprogressdao;
	public Teachingprogress getTeachingprogress() {
		return teachingprogress;
	}
	public void setTeachingprogress(Teachingprogress teachingprogress) {
		this.teachingprogress = teachingprogress;
	}
	public TeachingprogressDao getTeachingprogressdao() {
		return teachingprogressdao;
	}
	public void setTeachingprogressdao(TeachingprogressDao teachingprogressdao) {
		this.teachingprogressdao = teachingprogressdao;
	}
	public String findByStatus() throws Exception{
		
		 ActionContext context=ActionContext.getContext();
		 List<Teachingprogress> list=(List<Teachingprogress>)teachingprogressdao.findByStatus(teachingprogress.getDid());
		 context.getSession().put("NoStatusTeaching", list);
		 return "nostatus";
	}
	public String checked() throws Exception{
		teachingprogressdao.checked(teachingprogress);
		return "checked";
	}

}
