package shiep.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import shiep.bean.Customer;
import shiep.bean.PageBean;
import shiep.dao.CustomerDao;
import shiep.dao.CustomerService;
@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {
	@Resource
	private CustomerDao customerdao;
	
	public CustomerDao getCustomerdao() {
		return customerdao;
	}

	public void setCustomerdao(CustomerDao customerdao) {
		this.customerdao = customerdao;
	}

	@Override
	 public PageBean queryForPage(int pageSize,int page){

        final String hql = "from shiep.bean.Customer";        //查询语句
        int allRow = customerdao.getAllRowCount(hql);    //总记录数
        int totalPage = PageBean.countTotalPage(pageSize, allRow);    //总页数
        final int offset = PageBean.countOffset(pageSize, page);    //当前页开始记录
        final int length = pageSize;    //每页记录数
        final int currentPage = PageBean.countCurrentPage(page);
        List<Customer> list = customerdao.queryForPage(hql,offset, length);        //"一页"的记录
        
        //把分页信息保存到Bean中
        PageBean pageBean = new PageBean();
        pageBean.setPageSize(pageSize);    
        pageBean.setCurrentPage(currentPage);
        pageBean.setAllRow(allRow);
        pageBean.setTotalPage(totalPage);
        pageBean.setList(list);
        pageBean.init();
        return pageBean;
    }

}
