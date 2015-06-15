package shiep.daoImpl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shiep.bean.Announce;
import shiep.bean.Courseoutline;
import shiep.bean.Teacher;
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
	
	public List<Courseoutline> showAllOutline() {
		// TODO Auto-generated method stub
		return (List<Courseoutline>)getHibernateTemplate().find("from shiep.bean.Courseoutline");
	}
}
