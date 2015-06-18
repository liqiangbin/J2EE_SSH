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

	@Override
	public List<Teachingprogress> findall() {
		try{
			String queryStr="from shiep.bean.Teachingprogress";
			return (List<Teachingprogress>)getHibernateTemplate().find(queryStr);
		}catch(RuntimeException e){
			throw e;
		}
	}

	@Override
	public List<Teachingprogress> findByTid(String tid) {
		try{
			String queryStr="from shiep.bean.Teachingprogress  where tid='"+tid+"' and status=0";
			return (List<Teachingprogress>)getHibernateTemplate().find(queryStr);
		}catch(RuntimeException e){
			throw e;
		}
	}

	@Override
	public List<Teachingprogress> findByTeacher(String tid) {
		try{
			String queryStr="from shiep.bean.Teachingprogress  where tid='"+tid+"'";
			return (List<Teachingprogress>)getHibernateTemplate().find(queryStr);
		}catch(RuntimeException e){
			throw e;
		}
	}

	@Override
	public List<Teachingprogress> findByTerm(String tid, String term) {
		try{
			String queryStr="from shiep.bean.Teachingprogress  where term='"+term+"' and tid='"+tid+"'";
			return (List<Teachingprogress>)getHibernateTemplate().find(queryStr);
		}catch(RuntimeException e){
			throw e;
		}
	}

	@Transactional
	public void save(Teachingprogress teachingprogress) {
		try{
		       this.getHibernateTemplate().saveOrUpdate(teachingprogress);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		
	}
	}
