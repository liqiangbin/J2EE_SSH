package shiep.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import shiep.bean.Announce;
import shiep.bean.Departmenthead;
import shiep.dao.AnnounceDao;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
public class AnnounceAction  extends ActionSupport{
	private Announce announce;
	@Resource
	private AnnounceDao announcedao;
	public Announce getAnnounce() {
		return announce;
	}
	public void setAnnounce(Announce announce) {
		this.announce = announce;
	}
	public AnnounceDao getAnnouncedao() {
		return announcedao;
	}
	public void setAnnouncedao(AnnounceDao announcedao) {
		this.announcedao = announcedao;
	}
	public String findByStatus() throws Exception{
		 List<Announce> list=(List<Announce>)announcedao.findByStatus();
		 Map request=(Map) ActionContext.getContext().get("request");
         request.put("list", list); 
		 return "instAnnounce";
	}
	public String search() throws Exception{
		 List<Announce> list=(List<Announce>)announcedao.searchBytable(announce);
		 Map request=(Map) ActionContext.getContext().get("request");
         request.put("list", list); 
		 return "search";
	}
	public String findBydept() throws Exception{
		List<Announce> list=(List<Announce>)announcedao.findBydept(announce);
		 Map request=(Map) ActionContext.getContext().get("request");
         request.put("list", list); 
		 return "deptAnnounce";
	}
	public String searchdept() throws Exception{
		 List<Announce> list=(List<Announce>)announcedao.searchBydept(announce);
		 Map request=(Map) ActionContext.getContext().get("request");
        request.put("list", list); 
		 return "deptsearch";
	}
}
