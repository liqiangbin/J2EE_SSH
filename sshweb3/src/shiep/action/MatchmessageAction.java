package shiep.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import shiep.bean.Course;
import shiep.bean.Courseopen;
import shiep.bean.Depart;
import shiep.bean.Matchmessage;
import shiep.bean.Teacher;
import shiep.bean.Term;
import shiep.dao.CourseDao;
import shiep.dao.CourseOpenDao;
import shiep.dao.DepartDao;
import shiep.dao.MatchmessageDao;
import shiep.dao.TeacherDao;
import shiep.dao.TermDao;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
public class MatchmessageAction extends ActionSupport{
	private Matchmessage matchmessage;
	private Teacher teacher;
	private Depart depart;
	private Course course;
	private  Courseopen  courseopen;
	private  Term  term;
	@Resource
	private CourseDao coursedao;
	@Resource
	private  CourseOpenDao  courseopendao;
	@Resource
	private DepartDao departDao;
	@Resource
	private MatchmessageDao matchmessagedao;
	@Resource
	private TeacherDao teacherDao;
	@Resource
	private TermDao termdao;
	
	
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
	public Courseopen getCourseopen() {
		return courseopen;
	}
	public void setCourseopen(Courseopen courseopen) {
		this.courseopen = courseopen;
	}
	public CourseOpenDao getCourseopendao() {
		return courseopendao;
	}
	public void setCourseopendao(CourseOpenDao courseopendao) {
		this.courseopendao = courseopendao;
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
	
	public DepartDao getDepartDao() {
		return departDao;
	}
	public void setDepartDao(DepartDao departDao) {
		this.departDao = departDao;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	
	public Depart getDepart() {
		return depart;
	}
	public void setDepart(Depart depart) {
		this.depart = depart;
	}
	public TeacherDao getTeacherDao() {
		return teacherDao;
	}
	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}
	public String findbydept() throws Exception{
		 ActionContext context=ActionContext.getContext();
		List<Matchmessage> list= matchmessagedao.findByDeptstatus(matchmessage.getDid());
		List<Teacher> tlist= teacherDao.showTeacherBydid(matchmessage.getDid());
		context.getSession().put("outline", list);
		context.getSession().put("teacher", tlist);
		 return "success";
	}
	public String findbydept1() throws Exception{
		 ActionContext context=ActionContext.getContext();
		List<Matchmessage> list= matchmessagedao.findBytstatus(matchmessage.getDid());
		List<Term> term= termdao.findAll();
		 List<Courseopen> courseopen=(List<Courseopen>)courseopendao.showCourseOpenInfo();
		 context.getSession().put("courseopen", courseopen);
		context.getSession().put("teacheroutline", list);
		context.getSession().put("term", term);
		 return "success1";
	}
	public String sort() throws Exception{
		matchmessagedao.sortTeacher(matchmessage);
		 return "success";
	}
	public String findall() throws Exception{
		List<Matchmessage> list= matchmessagedao.findAll();
		List<Depart> list1= departDao.findAllDepart();
		List<Teacher> tlist= teacherDao.showAllTeacher();
		List<Course> courselist= coursedao.showAllCourseInfo();
		 ActionContext context=ActionContext.getContext();
		context.getSession().put("outline", list);
		context.getSession().put("depart", list1);
		context.getSession().put("teacher", tlist);
		context.getSession().put("course", courselist);
		
		 return "findall";
	}
	public String save(){
		List<Course> c=coursedao.showone(matchmessage.getCid());
		matchmessage.setCname(c.get(0).getName());
		matchmessagedao.save(matchmessage);
		return "matchmessage";
	}
	

}
