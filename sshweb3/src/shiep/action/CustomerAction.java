package shiep.action;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import shiep.bean.Customer;
import shiep.bean.PageBean;
import shiep.dao.CustomerDao;
import shiep.service.CustomerService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@SuppressWarnings("serial")
@Controller
public class CustomerAction extends ActionSupport {
	
	    private int page;    //第几页
	    private PageBean pageBean;    //包含分布信息的bean
	private Customer customer;
	@Resource
	private CustomerDao customerDao;
	@Resource
	 private CustomerService customerService;
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public CustomerService getCustomerService() {
		return customerService;
	}
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public PageBean getPageBean() {
		return pageBean;
	}
	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
	public CustomerDao getCustomerDao() {
		return customerDao;
	}
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
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
	public String pagesort() throws Exception {
		//System.out.println("############");
        //分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
       this.pageBean= customerService.queryForPage(2, page);
        return "page";
    }
	
}
