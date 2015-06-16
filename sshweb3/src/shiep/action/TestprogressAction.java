package shiep.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import shiep.bean.Teachingprogress;
import shiep.bean.Term;
import shiep.bean.Testprogress;
import shiep.dao.TermDao;
import shiep.dao.TestprogressDao;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
public class TestprogressAction  extends ActionSupport{
	private  Testprogress  testprogress;
	private  Term  term;
	@Resource
	private  TermDao termdao;
	@Resource
	private  TestprogressDao testprogressdao;
	
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
	public Testprogress getTestprogress() {
		return testprogress;
	}
	public void setTestprogress(Testprogress testprogress) {
		this.testprogress = testprogress;
	}
	public TestprogressDao getTestprogressdao() {
		return testprogressdao;
	}
	public void setTestprogressdao(TestprogressDao testprogressdao) {
		this.testprogressdao = testprogressdao;
	}
	
	public String findByStatus() throws Exception{
		
		 ActionContext context=ActionContext.getContext();
		 List<Testprogress> list=(List<Testprogress>)testprogressdao.findByStatus(testprogress.getDid());
		 context.getSession().put("NoStatusTest", list);
		 return "nostatus";
	}
	public String checked() throws Exception{
		testprogressdao.checked(testprogress);
		return "checked";
	}
	public String findall() throws Exception{
		
		 ActionContext context=ActionContext.getContext();
		 List<Testprogress> list=(List<Testprogress>)testprogressdao.findall();
		 context.getSession().put("NoStatusTest", list);
		 return "all";
	}
	public String findByTeacher() throws Exception{
		 ActionContext context=ActionContext.getContext();
		 List<Testprogress> list=(List<Testprogress>)testprogressdao.findByTeacher(testprogress.getTid());
		 List<Term> term=(List<Term>)termdao.findAll();
		 context.getSession().put("term", term);
		 context.getSession().put("oneTestTeaching", list);
		 return "onetestTeaching";
	}
	public String findByTerm() throws Exception{
		 ActionContext context=ActionContext.getContext();
		 List<Testprogress> list=(List<Testprogress>)testprogressdao.findByTerm(testprogress.getTid(), testprogress.getTerm());
		 List<Term> term=(List<Term>)termdao.findAll();
		 context.getSession().put("term", term);
		 context.getSession().put("oneTestTeaching", list);
		 return "onetestTeaching";
	}
}
