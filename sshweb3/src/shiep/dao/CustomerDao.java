package shiep.dao;
import java.util.List;

import shiep.bean.Customer;

public interface CustomerDao {
	public void addCustomer(Customer cus);
	public List<Customer> findAllCustomers();
	public void deleteCustomer(String cid);
}

