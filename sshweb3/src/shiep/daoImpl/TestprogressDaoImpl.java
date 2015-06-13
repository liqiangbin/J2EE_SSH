package shiep.daoImpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shiep.bean.Teachingprogress;
import shiep.bean.Testprogress;
import shiep.dao.BaseDao;
import shiep.dao.TeachingprogressDao;
import shiep.dao.TestprogressDao;

@Service("TestprogressDao")
public class TestprogressDaoImpl extends BaseDao implements TestprogressDao {

	@Override
	public List<Testprogress> findByStatus(String did) {
		try{
			String queryStr="from shiep.bean.Testprogress  where did='"+did+"' and status=0";
			return (List<Testprogress>)getHibernateTemplate().find(queryStr);
		}catch(RuntimeException e){
			throw e;
		}
	}

	@Transactional
	public void checked(Testprogress testprogress) {
		//System.out.println("--"+testprogress.getStatus());
		try{
			getHibernateTemplate().saveOrUpdate(testprogress);
		}
		catch (RuntimeException e) {
			throw e;
		}
	}
	

}
