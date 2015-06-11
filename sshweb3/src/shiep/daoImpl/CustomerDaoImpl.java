package shiep.daoImpl;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shiep.bean.Customer;
import shiep.dao.BaseDao;
import shiep.dao.CustomerDao;

@Service("CustomerDao")
public class CustomerDaoImpl extends BaseDao implements CustomerDao {
	
	 @Transactional
	public void addCustomer(Customer cus){
		try{
	       this.getHibernateTemplate().save(cus);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	 @Transactional
	public void deleteCustomer(String cid){
		     Customer cus=(Customer)this.getHibernateTemplate().get(Customer.class, cid);
			 if(cus!=null)
		       this.getHibernateTemplate().delete(cus);
	}
	@SuppressWarnings("unchecked")
	public List<Customer> findAllCustomers() {
	       return (List<Customer>)getHibernateTemplate().find("from shiep.bean.Customer");
	}
	@Override
	public List queryForPage(final String hql,final int offset, final int length) {
		 List list = getHibernateTemplate().executeFind(new HibernateCallback(){
	            public Object doInHibernate(Session session) throws HibernateException,SQLException{
	                Query query = session.createQuery(hql);
	                query.setFirstResult(offset);
	                query.setMaxResults(length);
	                List list = query.list();
	                return list;
	            }
	        });
	        return list;
	}
	@Override
	public int getAllRowCount(final String hql) {
		   return getHibernateTemplate().find(hql).size();
	}
	
	
	
}

