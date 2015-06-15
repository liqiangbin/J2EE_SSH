package shiep.daoImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import shiep.bean.Customer;
import shiep.bean.Depart;
import shiep.dao.BaseDao;
import shiep.dao.DepartDao;
@Service("DepartDao")
public class DepartDaoImpl extends BaseDao implements DepartDao {

	@Override
	public List<Depart> findAllDepart() {
		System.out.println("$$");
		return (List<Depart>)getHibernateTemplate().find("from shiep.bean.Depart");
	}

}
