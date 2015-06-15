package shiep.daoImpl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shiep.bean.Course;
import shiep.dao.BaseDao;
import shiep.dao.CourseDao;
@Service("courseDao")
public class CourseDaoImpl extends BaseDao implements CourseDao {

	@Override
	@SuppressWarnings("unchecked")
	public List<Course> showAllCourseInfo() {
//		System.out.println("!!!!!!!!!!!!!!!!!!!!");
		return (List<Course>)getHibernateTemplate().find("from shiep.bean.Course");
	}

	@Override
	@Transactional
	public void deleteCourse(String cid) {
		Course course=(Course)this.getHibernateTemplate().get(Course.class,cid);
		if(course!=null)
			this.getHibernateTemplate().delete(course);
		
	}

	@Override
	@Transactional
	public void addCourse(Course course) {
		try{
		       this.getHibernateTemplate().save(course);
			}catch(Exception ex){
				ex.printStackTrace();
			}
	}

	@Override
	public List<Course> searchBytable(Course course) {
		
			String hql="from shiep.bean.Course where name like '%"+course.getName()+"%'";
	
		return (List<Course>)getHibernateTemplate().find(hql);
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

	@Override
	public List<Course> showone(String cid) {
		return (List<Course>)getHibernateTemplate().find("from shiep.bean.Course where id='"+cid+"'");
	}
	

}
