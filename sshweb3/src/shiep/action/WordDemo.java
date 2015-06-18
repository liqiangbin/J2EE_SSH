package shiep.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import shiep.bean.Courseoutline;
import shiep.bean.Matchmessage;
import shiep.bean.Sortprogress;
import shiep.bean.Teachingprogress;
import shiep.bean.Testprogress;
import shiep.dao.CourseoutlineDao;
import shiep.dao.MatchmessageDao;
import shiep.dao.SortprogressDao;
import shiep.dao.TeachingprogressDao;
import shiep.dao.TestprogressDao;

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
    
    private String address;
    private Courseoutline courseoutline;
    private Matchmessage matchmessage;
    //------------------教学进度表变量-------------------------------
    private  Sortprogress sortprogress;
    @Resource
    private SortprogressDao sortprogressdao;
    private Teachingprogress teachingprogress;
    @Resource
    private TeachingprogressDao teachingprogressdao;
    
    
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
	
	//--------------------------------------实验进度表变量声明------------
	 private Testprogress testprogress;
	    @Resource
	    private TestprogressDao testprogressdao;
	    
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
	@Resource
    private CourseoutlineDao courseoutlinedao;
    @Resource
    private MatchmessageDao matchmessagedao;
    
    
    public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public void setServletRequest(HttpServletRequest request) { 
        this.request = request; 
    }
    public void setServletResponse(HttpServletResponse response) { 
        this.response = response; 
    }
    
    public String getMessage(){
    	return message;
    }
//------------------------在线填写教学大纲---------------------------------
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
    //-----------------------在线添加教学进度表-----------------------
    public String openteachingword() throws Exception {
    	PageOfficeCtrl poCtrl1 = new PageOfficeCtrl(ServletActionContext.getRequest());
    	ActionContext context=ActionContext.getContext();
    	teachingprogressdao.save(teachingprogress);
    	sortprogressdao.saveorupdate(sortprogress);
    	poCtrl1.setServerPage("poserver.do"); //此行必须
    	poCtrl1.addCustomToolButton("保存并存档至系统", "SaveDocument()", 1);
    	poCtrl1.addCustomToolButton("-", "", 0);
    	poCtrl1.addCustomToolButton("-", "", 0);
    	poCtrl1.addCustomToolButton("全屏切换", "SetFullScreen()", 4);
    	poCtrl1.addCustomToolButton("-", "", 0);
    	poCtrl1.setSaveFilePage("saveteachingword.action?teachingprogress.address="+teachingprogress.getAddress()+"");
    	poCtrl1.webOpen("doc/teachingprogress.docx", OpenModeType.docNormalEdit, "张三");
    	poCtrl1.setTagId("PageOfficeCtrl1"); //此行必须
    	return "openword_"+SUCCESS;
    }
    public String saveteachingword() throws Exception {
    	FileSaver fs = new FileSaver(request, response);
    	request.setAttribute("FileSaver", fs);
    	String address=teachingprogress.getAddress();
    	fs.saveToFile(address);
    	fs.showPage(300, 300);
    	message = "显示自定义保存结果。";
    	return "saveword_"+SUCCESS;
    }
    //--------------------------------试验进度表填写----------------
    public String opentestword() throws Exception {
    	PageOfficeCtrl poCtrl1 = new PageOfficeCtrl(ServletActionContext.getRequest());
    	ActionContext context=ActionContext.getContext();
    	testprogressdao.save(testprogress);
    	sortprogressdao.saveorupdate(sortprogress);
    	poCtrl1.setServerPage("poserver.do"); //此行必须
    	poCtrl1.addCustomToolButton("保存并存档至系统", "SaveDocument()", 1);
    	poCtrl1.addCustomToolButton("-", "", 0);
    	poCtrl1.addCustomToolButton("-", "", 0);
    	poCtrl1.addCustomToolButton("全屏切换", "SetFullScreen()", 4);
    	poCtrl1.addCustomToolButton("-", "", 0);
    	poCtrl1.setSaveFilePage("savetestword.action?testprogress.address="+testprogress.getAddress()+"");
    	poCtrl1.webOpen("doc/testprogress.docx", OpenModeType.docNormalEdit, "张三");
    	poCtrl1.setTagId("PageOfficeCtrl1"); //此行必须
    	return "openword_"+SUCCESS;
    }
    public String savetestword() throws Exception {
    	FileSaver fs = new FileSaver(request, response);
    	request.setAttribute("FileSaver", fs);
    	String address=testprogress.getAddress();
    	fs.saveToFile(address);
    	fs.showPage(300, 300);
    	message = "显示自定义保存结果。";
    	return "saveword_"+SUCCESS;
    }
    //-------------------浏览word
    public String readonly() throws Exception {
    	PageOfficeCtrl poCtrl1 = new PageOfficeCtrl(ServletActionContext.getRequest());
    	//String address=courseoutline.getAddress();
    	ActionContext context=ActionContext.getContext();
		//context.getSession().put("address", address);
    	//courseoutlinedao.save(courseoutline);
    	//matchmessagedao.sortTeacher(matchmessage);
    	poCtrl1.setServerPage("poserver.do"); //此行必须
    	//poCtrl1.addCustomToolButton("保存并存档至系统", "SaveDocument()", 1);
    	poCtrl1.addCustomToolButton("-", "", 0);
    	poCtrl1.addCustomToolButton("-", "", 0);
    	poCtrl1.addCustomToolButton("全屏切换", "SetFullScreen()", 4);
    	poCtrl1.addCustomToolButton("-", "", 0);
    //	poCtrl1.setSaveFilePage("saveword.action?courseoutline.address="+courseoutline.getAddress()+"");
    	String s =address;
		String s1 = s.replace("F:/myeclipse/myclipseworkspace/sshweb3/WebRoot/","");
    	poCtrl1.webOpen(s1, OpenModeType.docReadOnly, "张三");
    	poCtrl1.setTagId("PageOfficeCtrl1"); //此行必须
    	return "openword_"+SUCCESS;
    }
    //-------------在线编辑---------------
    public String editword() throws Exception {
    	PageOfficeCtrl poCtrl1 = new PageOfficeCtrl(ServletActionContext.getRequest());
    	ActionContext context=ActionContext.getContext();
    	poCtrl1.setServerPage("poserver.do"); //此行必须
    	poCtrl1.addCustomToolButton("保存并存档至系统", "SaveDocument()", 1);
    	poCtrl1.addCustomToolButton("-", "", 0);
    	poCtrl1.addCustomToolButton("-", "", 0);
    	poCtrl1.addCustomToolButton("全屏切换", "SetFullScreen()", 4);
    	poCtrl1.addCustomToolButton("-", "", 0);
    	poCtrl1.setSaveFilePage("saveeditword.action?address="+address+"");
//    	System.out.println(address);
    	String s = address;
    			String s1 = s.replace("F:/myeclipse/myclipseworkspace/sshweb3/WebRoot/","");
    
    	poCtrl1.webOpen(s1, OpenModeType.docNormalEdit, "张三");
    	poCtrl1.setTagId("PageOfficeCtrl1"); //此行必须
    	return "openword_"+SUCCESS;
    }
    public String saveeditword() throws Exception {
    	FileSaver fs = new FileSaver(request, response);
    	request.setAttribute("FileSaver", fs);
    	//String address=testprogress.getAddress();
//    	System.out.println("%%%%%"+address);
    	fs.saveToFile(address);
    	fs.showPage(300, 300);
    	message = "显示自定义保存结果。";
    	return "saveword_"+SUCCESS;
    }

}