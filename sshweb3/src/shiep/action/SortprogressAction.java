package shiep.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import shiep.bean.Course;
import shiep.bean.Sortprogress;
import shiep.bean.Teacher;
import shiep.bean.Term;
import shiep.dao.CourseDao;
import shiep.dao.SortprogressDao;
import shiep.dao.TeacherDao;
import shiep.dao.TermDao;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
public class SortprogressAction extends ActionSupport {
	private Teacher teacher;
	private Sortprogress sortprogress;
	private Term term;
	private Course course;
	@Resource
	private CourseDao coursedao;
	@Resource
	private SortprogressDao sortprogressdao;
	@Resource
	private TeacherDao teacherDao;
	@Resource
	private TermDao termdao;
	
	
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
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Sortprogress getSortprogress() {
		return sortprogress;
	}
	public void setSortprogress(Sortprogress sortprogress) {
		this.sortprogress = sortprogress;
	}
	public SortprogressDao getSortprogressdao() {
		return sortprogressdao;
	}
	public void setSortprogressdao(SortprogressDao sortprogressdao) {
		this.sortprogressdao = sortprogressdao;
	}
	public TeacherDao getTeacherDao() {
		return teacherDao;
	}
	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
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
	public String findbydept() throws Exception{
		 ActionContext context=ActionContext.getContext();
		List<Sortprogress> list= sortprogressdao.findByDeptstatus(sortprogress.getDid());
		List<Term> term=termdao.findAll();
		List<Teacher> tlist= teacherDao.showTeacherBydid(sortprogress.getDid());
		List<Course> courselist= coursedao.showAllCourseInfo();

		context.getSession().put("sortmessage", list);
		context.getSession().put("teacher", tlist);
		context.getSession().put("term", term);
		context.getSession().put("course", courselist);
		 return "success";
	}
	public String sort() throws Exception{
		System.out.println(sortprogress.getCid());
		System.out.println(sortprogress.getTid());
		System.out.println(sortprogress.getStatus());
		sortprogressdao.save(sortprogress);
		return "dd";
	}


}
