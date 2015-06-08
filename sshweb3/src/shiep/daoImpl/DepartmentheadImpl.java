package shiep.daoImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import shiep.bean.Customer;
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

	@Override
	public List<Departmenthead> Departmentheadlogin(String id, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
