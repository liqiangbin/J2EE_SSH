package shiep.daoImpl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
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

	@Override
	public List queryForPage(final String hql, final int offset, final int length) {
		List list=getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) 
					throws HibernateException, SQLException {
				Query query=session.createQuery(hql);
				query.setFirstResult(offset);
                query.setMaxResults(length);
                List list = query.list();
                return list;
			}
		});
		return list;
	}

	@Override
	public int getAllRowCount(String hql) {
		return getHibernateTemplate().find(hql).size();
	}
	

}
