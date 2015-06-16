package shiep.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import shiep.bean.Teachingprogress;
import shiep.bean.Term;
import shiep.dao.TeachingprogressDao;
import shiep.dao.TermDao;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
public class TeachingprogressAction  extends ActionSupport{
	private  Teachingprogress  teachingprogress;
	private  Term  term;
	@Resource
	private  TermDao termdao;
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
	
	public Term getTerm() {
		return term;
	}
	public void setTerm(Term term) {
		this.term = term;
	}
	public TermDao getTermdao() {
		return termdao;
	}
	public void setTermdao(TermDao termdao) {
		this.termdao = termdao;
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
	public String findall() throws Exception{
		
		 ActionContext context=ActionContext.getContext();
		 List<Teachingprogress> list=(List<Teachingprogress>)teachingprogressdao.findall();
		 context.getSession().put("NoStatusTeaching", list);
		 return "all";
	}
	public String findByTid() throws Exception{
		 ActionContext context=ActionContext.getContext();
		 List<Teachingprogress> list=(List<Teachingprogress>)teachingprogressdao.findByTid(teachingprogress.getTid());
		 context.getSession().put("NofillTeaching", list);
		 return "NofillTeaching";
	}
	public String findByTeacher() throws Exception{
		 ActionContext context=ActionContext.getContext();
		 List<Teachingprogress> list=(List<Teachingprogress>)teachingprogressdao.findByTeacher(teachingprogress.getTid());
		 List<Term> term=(List<Term>)termdao.findAll();
		 context.getSession().put("term", term);
		 context.getSession().put("oneTeacherTeaching", list);
		 return "oneTeacherTeaching";
	}
	public String findByTerm() throws Exception{
		 ActionContext context=ActionContext.getContext();
		 List<Teachingprogress> list=(List<Teachingprogress>)teachingprogressdao.findByTerm(teachingprogress.getTid(), teachingprogress.getTerm());
		 List<Term> term=(List<Term>)termdao.findAll();
		 context.getSession().put("term", term);
		 context.getSession().put("oneTeacherTeaching", list);
		 return "oneTeacherTeaching";
	}
	
}
