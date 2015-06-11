package shiep.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import shiep.bean.Announce;
import shiep.bean.Departmenthead;
import shiep.bean.Matchmessage;
import shiep.bean.Teacher;
import shiep.dao.MatchmessageDao;
import shiep.dao.TeacherDao;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
public class MatchmessageAction extends ActionSupport{
	private Matchmessage matchmessage;
	private Teacher teacher;
	@Resource
	private MatchmessageDao matchmessagedao;
	@Resource
	private TeacherDao teacherDao;
	public Matchmessage getMatchmessage() {
		return matchmessage;
	}
	public void setMatchmessage(Matchmessage matchmessage) {
		this.matchmessage = matchmessage;
	}
	public MatchmessageDao getMatchmessagedao() {
		return matchmessagedao;
	}
	public void setMatchmessagedao(MatchmessageDao matchmessagedao) {
		this.matchmessagedao = matchmessagedao;
	}
	
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public TeacherDao getTeacherDao() {
		return teacherDao;
	}
	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}
	public String findbydept() throws Exception{
		//System.out.println(matchmessage.getDid());
		 ActionContext context=ActionContext.getContext();
		List<Matchmessage> list= matchmessagedao.findByDeptstatus(matchmessage.getDid());
		List<Teacher> tlist= teacherDao.showTeacherBydid(matchmessage.getDid());
		// Map request=(Map) ActionContext.getContext().get("request");
		context.getSession().put("outline", list);
		context.getSession().put("teacher", tlist);
     //  request.put("outline", list); 
     //  request.put("teacher", tlist); 
		 return "success";
	}
	public String sort() throws Exception{
		matchmessagedao.sortTeacher(matchmessage);
		 return "success";
	}

}
