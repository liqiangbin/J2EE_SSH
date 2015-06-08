package shiep.daoImpl;
import java.util.List;
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
	
	
	
}

