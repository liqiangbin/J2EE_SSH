package shiep.daoImpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;

import shiep.bean.Departmenthead;
import shiep.dao.BaseDao;
import shiep.dao.DepartmentheadDao;

@Service("DepartmentheadDao")
public class DepartmentheadImpl extends BaseDao implements DepartmentheadDao {
	@SuppressWarnings("unchecked")
	public List<Departmenthead> findAllDepartmenthead() {
		 return (List<Departmenthead>)getHibernateTemplate().find("from shiep.bean.Departmenthead");
	}

	@Override
	public List<Departmenthead> findDepartmentheadById(String id) {
		
		return (List<Departmenthead>)getHibernateTemplate().find("from shiep.bean.Departmenthead where id='"+id+"'");
	}


	@Transactional
	public void updatemyself(Departmenthead depthead) {
		try{
			getHibernateTemplate().saveOrUpdate(depthead);
		}
		catch (RuntimeException e) {
			throw e;
		}
		
	}

	@Override
	public boolean login(String username, String password) {
		List<Departmenthead> depthead=this.getHibernateTemplate().find("from shiep.bean.Departmenthead where id=? and password=?", username,password);
		boolean flag=false;
		if(depthead.size()>0){
			 ActionContext context=ActionContext.getContext();
			 context.getSession().put("person", depthead);
			flag=true;
		}
		return flag;

	}
	
}
