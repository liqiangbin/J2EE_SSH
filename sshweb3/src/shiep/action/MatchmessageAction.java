package shiep.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import shiep.bean.Course;
import shiep.bean.Depart;
import shiep.bean.Matchmessage;
import shiep.bean.Teacher;
import shiep.dao.CourseDao;
import shiep.dao.DepartDao;
import shiep.dao.MatchmessageDao;
import shiep.dao.TeacherDao;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
public class MatchmessageAction extends ActionSupport{
	private Matchmessage matchmessage;
	private Teacher teacher;
	private Depart depart;
	private Course course;
	@Resource
	private CourseDao coursedao;
	
	@Resource
	private DepartDao departDao;
	@Resource
	private MatchmessageDao matchmessagedao;
	@Resource
	private TeacherDao teacherDao;
	
	
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
	//	List<Teacher> tlist= teacherDao.showTeacherBydid(matchmessage.getDid());
		context.getSession().put("teacheroutline", list);
		//context.getSession().put("teacher", tlist);
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
