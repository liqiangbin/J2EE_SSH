package shiep.action;
import java.util.*;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import shiep.bean.Customer;
import shiep.dao.CustomerDao;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@SuppressWarnings("serial")
@Controller
public class CustomerAction extends ActionSupport {
	private Customer customer;
	@Resource
	private CustomerDao customerDao;

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
    public String save() throws Exception {
		try {
			customerDao.addCustomer(customer);
		} catch (Exception ex) {
			ex.printStackTrace();
			return INPUT;
		}
		return "disp";
    }
	@SuppressWarnings("unchecked")
	public String all() throws Exception {
		 List<Customer> list=customerDao.findAllCustomers();
         Map request=(Map) ActionContext.getContext().get("request");
         request.put("list", list); 
		return "index";
    }
	
   
	public String delete() throws Exception {
		customerDao.deleteCustomer(customer.getCustomerId());
		return "disp";
    }
	
	
}
