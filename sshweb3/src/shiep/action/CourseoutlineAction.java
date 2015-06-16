package shiep.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import shiep.bean.Course;
import shiep.bean.Courseoutline;
import shiep.bean.Term;
import shiep.dao.CourseDao;
import shiep.dao.CourseoutlineDao;
import shiep.dao.TermDao;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
public class CourseoutlineAction  extends ActionSupport{
	private  Courseoutline  courseoutline;
	private  Term  term;
	private  Course  course;
	@Resource
	private  CourseoutlineDao courseoutlinedao;
	@Resource
	private  CourseDao coursedao;
	@Resource
	private  TermDao termdao;
	
	//------------------------------
	
	public Courseoutline getCourseoutline() {
		return courseoutline;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public CourseDao getCoursedao() {
		return coursedao;
	}
	public void setCoursedao(CourseDao coursedao) {
		this.coursedao = coursedao;
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
		 context.getSession().put("NoStatusOutline", list);
		 return "nostatus";
	}
	public String checked() throws Exception{
		System.out.println("*******");
		courseoutlinedao.checked(courseoutline);
		return "checked";
	}
	
	public String view() throws Exception{
		//System.out.println(courseoutline.getAddress());
		String address=courseoutline.getAddress();
		System.out.println(address);
		 ActionContext context=ActionContext.getContext();
		 context.getSession().put("outlineview",address );
		return "view";
	}
	
	public String showAllOutline() throws Exception{
	
		List<Courseoutline> outline=courseoutlinedao.showAllOutline();
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("outlinelist", outline);
		return "outline";
	}
	public String findByTeacher() throws Exception{
		 ActionContext context=ActionContext.getContext();
		 List<Courseoutline> list=(List<Courseoutline>)courseoutlinedao.findByTeacher(courseoutline.getTid());
		 List<Term> term=(List<Term>)termdao.findAll();
		 List<Course> course=(List<Course>)coursedao.showAllCourseInfo();
		 context.getSession().put("term", term);
		 context.getSession().put("TeacherOutline", list);
		 context.getSession().put("course", course);
		 return "TeacherOutline";
	}
	public String findByTerm() throws Exception{
		 ActionContext context=ActionContext.getContext();
		 List<Courseoutline> list=(List<Courseoutline>)courseoutlinedao.findByTerm(courseoutline.getTid(), courseoutline.getTerm());
		 List<Term> term=(List<Term>)termdao.findAll();
		 List<Course> course=(List<Course>)coursedao.showAllCourseInfo();
		 context.getSession().put("term", term);
		 context.getSession().put("TeacherOutline", list);
		 context.getSession().put("course", course);
		 return "TeacherOutline";
	}
}
