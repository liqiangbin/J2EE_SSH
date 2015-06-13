package shiep.daoImpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shiep.bean.Announce;
import shiep.bean.Courseoutline;
import shiep.dao.BaseDao;
import shiep.dao.CourseoutlineDao;

@Service("CourseoutlineDao")
public class CourseoutlineDaoImpl extends BaseDao implements CourseoutlineDao{
	@Override
	public List<Courseoutline> findByStatus(String did) {
		try{
			String queryStr="from shiep.bean.Courseoutline  where did='"+did+"' and status=0";
			return (List<Courseoutline>)getHibernateTemplate().find(queryStr);
		}catch(RuntimeException e){
			throw e;
		}
	}
	 @Transactional
	public void checked(Courseoutline courseoutline) {
		try{
			getHibernateTemplate().saveOrUpdate(courseoutline);
		}
		catch (RuntimeException e) {
			throw e;
		}
	}
}
