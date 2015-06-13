package shiep.daoImpl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shiep.bean.Courseopen;
import shiep.dao.BaseDao;
import shiep.dao.CourseOpenDao;
@Service("courseOpenDao")
public class CourseOpenDaoImpl extends BaseDao implements CourseOpenDao {

	@Override
	@SuppressWarnings("unchecked")
	public List<Courseopen> showCourseOpenInfo() {
		// TODO Auto-generated method stub
		return (List<Courseopen>)getHibernateTemplate().find("from shiep.bean.Courseopen");
	}

	@Override
	@Transactional
	public void deleteCourseOpenInfo(String coid) {
		Courseopen courseopen=(Courseopen)this.getHibernateTemplate().get(Courseopen.class, coid);
		if(courseopen!=null)
			this.getHibernateTemplate().delete(courseopen);
		
	}

	public List queryForPage(final String hql, final int offset, final int length) {
		List list=getHibernateTemplate().executeFind(new HibernateCallback() {

			
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
