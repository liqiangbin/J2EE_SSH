package shiep.daoImpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
	@Transactional
	public void updatemyself(Departmenthead depthead) {
		try{
			getHibernateTemplate().saveOrUpdate(depthead);
		}
		catch (RuntimeException e) {
			throw e;
		}
		
	}
	
}
