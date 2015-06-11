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

        final String hql = "from shiep.bean.Customer";        //��ѯ���
        int allRow = customerdao.getAllRowCount(hql);    //�ܼ�¼��
        int totalPage = PageBean.countTotalPage(pageSize, allRow);    //��ҳ��
        final int offset = PageBean.countOffset(pageSize, page);    //��ǰҳ��ʼ��¼
        final int length = pageSize;    //ÿҳ��¼��
        final int currentPage = PageBean.countCurrentPage(page);
        List<Customer> list = customerdao.queryForPage(hql,offset, length);        //"һҳ"�ļ�¼
        
        //�ѷ�ҳ��Ϣ���浽Bean��
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
