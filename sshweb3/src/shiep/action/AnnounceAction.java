package shiep.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import shiep.bean.Announce;
import shiep.bean.Departmenthead;
import shiep.dao.AnnounceDao;
import shiep.dao.DepartmentheadDao;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
public class AnnounceAction  extends ActionSupport{
	private Announce announce;
	private Departmenthead departmenthead;
	@Resource
	private AnnounceDao announcedao;
	@Resource
	private DepartmentheadDao deptheaddao;
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
	public Departmenthead getDepartmenthead() {
		return departmenthead;
	}
	public void setDepartmenthead(Departmenthead departmenthead) {
		this.departmenthead = departmenthead;
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
		 List<Departmenthead> list1=(List<Departmenthead>)deptheaddao.findDepartmentheadById(departmenthead.getId());
		List<Announce> list=(List<Announce>)announcedao.findBydept(list1.get(0).getDid());
		 Map request=(Map) ActionContext.getContext().get("request");
        request.put("list", list); 
		 return "deptAnnounce";
	}
	public String searchdept() throws Exception{
		 List<Departmenthead> list1=(List<Departmenthead>)deptheaddao.findDepartmentheadById(departmenthead.getId());
		 List<Announce> list=(List<Announce>)announcedao.searchBydept(list1.get(0).getDid(),announce);
		 Map request=(Map) ActionContext.getContext().get("request");
        request.put("list", list); 
		 return "deptsearch";
	}
	public String delete() throws Exception{
		announcedao.delete(announce.getId());
		 return "deleted";
	}
	public String add() throws Exception{
		announcedao.add(announce);
		 return "add";
	}
}
