package shiep.daoImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import shiep.bean.Customer;
import shiep.bean.Term;
import shiep.dao.BaseDao;
import shiep.dao.TermDao;

@Service("TermDao")
public class TermDaoImpl extends BaseDao implements  TermDao{

	@Override
	public List<Term> findAll() {
		  return (List<Term>)getHibernateTemplate().find("from shiep.bean.Term");
	}

}
