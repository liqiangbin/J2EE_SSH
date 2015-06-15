package shiep.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import shiep.bean.Courseoutline;
import shiep.bean.PageBean;
import shiep.service.AllmessageService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
public class AllmessageAction  extends ActionSupport{
	@Resource
	private  AllmessageService  allmessageservice;
	public AllmessageService getAllmessageservice() {
		return allmessageservice;
	}

	public void setAllmessageservice(AllmessageService allmessageservice) {
		this.allmessageservice = allmessageservice;
	}
	//-----------下拉框属性选择
	private String type;
	private String term;
	private int status;
	
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
	
	public String showPage() throws Exception{
		 ActionContext context=ActionContext.getContext();
		 if("教学大纲".equals(type)){
			 String s="1";
		context.getSession().put("messagetype", s);
		this.pageBean=allmessageservice.queryForPageOutline(3, page,status,term);
		//System.out.println(pageBean.getAllRow());
		//System.out.println(pageBean.getList());
		return "outlinepagelist";
		}
		 else if("教学进度表".equals(type)){
			 String s="2";
		context.getSession().put("messagetype", s);
		this.pageBean=allmessageservice.queryForPageTeaching(3, page,status,term);
		System.out.println(pageBean.getAllRow());
		return "teachingpagelist";
		}
		 else{
			 String s="3";
		context.getSession().put("messagetype", s);
		this.pageBean=allmessageservice.queryForPageTest(3, page,status,term);
		System.out.println(pageBean.getAllRow());
		return "testpagelist";
		}
	}

	
}