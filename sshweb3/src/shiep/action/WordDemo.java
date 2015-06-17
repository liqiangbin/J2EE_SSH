package shiep.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import shiep.bean.Courseoutline;
import shiep.bean.Matchmessage;
import shiep.dao.CourseoutlineDao;
import shiep.dao.MatchmessageDao;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhuozhengsoft.pageoffice.FileSaver;
import com.zhuozhengsoft.pageoffice.OpenModeType;
import com.zhuozhengsoft.pageoffice.PageOfficeCtrl;

public class WordDemo extends ActionSupport implements ServletRequestAware, ServletResponseAware{ 

    private static final long serialVersionUID = -758686623642845302L;
    private HttpServletRequest request;
    private HttpServletResponse response; 
    private String message = "";
    private String name;
    private Courseoutline courseoutline;
    private Matchmessage matchmessage;
    @Resource
    private CourseoutlineDao courseoutlinedao;
    @Resource
    private MatchmessageDao matchmessagedao;
    
    
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
	public Courseoutline getCourseoutline() {
		return courseoutline;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setServletRequest(HttpServletRequest request) { 
        this.request = request; 
    }
    public void setServletResponse(HttpServletResponse response) { 
        this.response = response; 
    }
    
    public String getMessage(){
    	return message;
    }

    public String openword() throws Exception {
    	PageOfficeCtrl poCtrl1 = new PageOfficeCtrl(ServletActionContext.getRequest());
    	
    	String address=courseoutline.getAddress();
    	ActionContext context=ActionContext.getContext();
		context.getSession().put("address", address);
    	courseoutlinedao.save(courseoutline);
    	matchmessagedao.sortTeacher(matchmessage);
    	poCtrl1.setServerPage("poserver.do"); //此行必须
    	poCtrl1.addCustomToolButton("保存并存档至系统", "SaveDocument()", 1);
    	poCtrl1.addCustomToolButton("-", "", 0);
    	poCtrl1.addCustomToolButton("-", "", 0);
    	poCtrl1.addCustomToolButton("全屏切换", "SetFullScreen()", 4);
    	poCtrl1.addCustomToolButton("-", "", 0);
    	poCtrl1.setSaveFilePage("saveword.action?courseoutline.address="+courseoutline.getAddress()+"");
    	poCtrl1.webOpen("doc/outline.docx", OpenModeType.docNormalEdit, "张三");
    	poCtrl1.setTagId("PageOfficeCtrl1"); //此行必须
    	return "openword_"+SUCCESS;
    }
    public String saveword() throws Exception {
    	FileSaver fs = new FileSaver(request, response);
    	request.setAttribute("FileSaver", fs);
    	String address=courseoutline.getAddress();
    	fs.saveToFile(address);
    	fs.showPage(300, 300);
    	message = "显示自定义保存结果。";
    	return "saveword_"+SUCCESS;
    }

}