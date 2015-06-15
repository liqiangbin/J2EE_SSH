package shiep.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import shiep.bean.Courseoutline;
import shiep.bean.Depart;
import shiep.bean.PageBean;
import shiep.bean.Term;
import shiep.dao.DepartDao;
import shiep.dao.TermDao;
import shiep.service.AllmessageService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
public class AllmessageAction  extends ActionSupport{
	@Resource
	private  AllmessageService  allmessageservice;
	@Resource
	private  TermDao  termdao;
	@Resource
	private  DepartDao  departdao;
	public AllmessageService getAllmessageservice() {
		return allmessageservice;
	}

	public void setAllmessageservice(AllmessageService allmessageservice) {
		this.allmessageservice = allmessageservice;
	}
	//-----------下拉框属性选择
	private String type;
	private String term;
	private String dept;
	private int status;
	
public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	//-----------

private int page;
	private PageBean pageBean;
	private  Courseoutline outline;


	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
	public Courseoutline getOutline() {
		return outline;
	}

	public void setOutline(Courseoutline outline) {
		this.outline = outline;
	}
	
	public TermDao getTermdao() {
		return termdao;
	}

	public void setTermdao(TermDao termdao) {
		this.termdao = termdao;
	}

	public DepartDao getDepartdao() {
		return departdao;
	}

	public void setDepartdao(DepartDao departdao) {
		this.departdao = departdao;
	}

	public String  top() throws Exception{
		 ActionContext context=ActionContext.getContext();
		 List<Term> termlist=termdao.findAll();
		 context.getSession().put("termlist", termlist);
		 List<Depart> departlist=departdao.findAllDepart();
		 context.getSession().put("departlist", departlist);
		 return "top";
	}
	public String  topadmin() throws Exception{
		 ActionContext context=ActionContext.getContext();
		 List<Term> termlist=termdao.findAll();
		 context.getSession().put("termlist", termlist);
		 List<Depart> departlist=departdao.findAllDepart();
		 context.getSession().put("departlist", departlist);
		 return "topadmin";
	}

	public String showPage() throws Exception{
		 ActionContext context=ActionContext.getContext();
		 if("教学大纲".equals(type)){
			 String s="1";
		context.getSession().put("messagetype", s);
		this.pageBean=allmessageservice.queryForPageOutline(5, 

page,status,term);
		return "outlinepagelist";
		}
		 else if("教学进度表".equals(type)){
			 String s="2";
		context.getSession().put("messagetype", s);
		this.pageBean=allmessageservice.queryForPageTeaching(5, 

page,status,term);
		//System.out.println(pageBean.getAllRow());
		return "teachingpagelist";
		}
		 else{
			 String s="3";
		context.getSession().put("messagetype", s);
		this.pageBean=allmessageservice.queryForPageTest(5, page,status,term);
		//System.out.println(pageBean.getAllRow());
		return "testpagelist";
		}
	}
	
	public String adminshowPage() throws Exception{
		 ActionContext context=ActionContext.getContext();
		 if("教学大纲".equals(type)){
			 String s="1";
		context.getSession().put("messagetypeadmin", s);
		this.pageBean=allmessageservice.queryForPageOutline(5, 

page,status,term,dept);
		return "outlinepagelistadmin";
		}
		 else if("教学进度表".equals(type)){
			 String s="2";
		context.getSession().put("messagetypeadmin", s);
		this.pageBean=allmessageservice.queryForPageTeaching(5, 

page,status,term,dept);
		System.out.println(pageBean.getAllRow());
		return "teachingpagelistadmin";
		}
		 else{
			 String s="3";
		context.getSession().put("messagetypeadmin", s);
		this.pageBean=allmessageservice.queryForPageTest(5, 

page,status,term,dept);
		System.out.println(pageBean.getAllRow());
		return "testpagelistadmin";
		}
	}

	
}