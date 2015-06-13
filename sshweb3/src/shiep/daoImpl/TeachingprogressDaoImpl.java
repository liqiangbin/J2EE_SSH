package shiep.daoImpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import shiep.bean.Teachingprogress;
import shiep.dao.BaseDao;
import shiep.dao.TeachingprogressDao;

@Service("TeachingprogressDao")
public class TeachingprogressDaoImpl extends BaseDao implements TeachingprogressDao {

	@Override
	public List<Teachingprogress> findByStatus(String did) {
		try{
			String queryStr="from shiep.bean.Teachingprogress  where did='"+did+"' and status=0";
			return (List<Teachingprogress>)getHibernateTemplate().find(queryStr);
		}catch(RuntimeException e){
			throw e;
		}
	}

	@Transactional
	public void checked(Teachingprogress teachingprogress) {
		try{
			getHibernateTemplate().saveOrUpdate(teachingprogress);
		}
		catch (RuntimeException e) {
			throw e;
		}
		
	}

}
