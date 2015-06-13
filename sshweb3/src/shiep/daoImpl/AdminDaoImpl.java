package shiep.daoImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import shiep.bean.Super;
import shiep.dao.AdminDao;
import shiep.dao.BaseDao;

@Service("adminDao")
public class AdminDaoImpl extends BaseDao implements AdminDao {

	@Override
	public boolean adminLogin(String username, String password) {
//		System.out.println(username+"   "+password);
		@SuppressWarnings("unchecked")
//		getHibernateTemplate().find("from shiep.bean.Super where name=? and password=?", username,password);
		
		List<Super> admin=this.getHibernateTemplate().find("from shiep.bean.Super where name=? and password=?", username,password);
		boolean flag=false;
		if(admin.size()>0){
			flag=true;
		}
//		System.out.println(flag);
		return flag;
	}

}
