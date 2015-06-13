package shiep.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import shiep.bean.Teachingprogress;
import shiep.bean.Testprogress;
import shiep.dao.TestprogressDao;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
public class TestprogressAction  extends ActionSupport{
	private  Testprogress  testprogress;
	@Resource
	private  TestprogressDao testprogressdao;
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

}