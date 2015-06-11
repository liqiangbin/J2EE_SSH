package shiep.daoImpl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shiep.bean.Teacher;
import shiep.dao.BaseDao;
import shiep.dao.TeacherDao;
@Service("teacherDao")
public class TeacherDaoImpl extends BaseDao implements TeacherDao  {

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> showAllTeacher() {
		
		return (List<Teacher>)getHibernateTemplate().find("from shiep.bean.Teacher");
	}
	
	public boolean teacherLogin(String id, String password){
		@SuppressWarnings("unchecked")
		List<Teacher> teacher=this.getHibernateTemplate().find("from shiep.bean.Teacher where id=? and password=?", id,password);
		boolean flag=false;
		if(teacher.size()>0){
			flag=true;
		}
		return flag;
	}
	
	@Transactional
	public void deleteTeacher(String tid){
		Teacher tea=(Teacher)this.getHibernateTemplate().get(Teacher.class, tid);
		if(tea!=null)
			this.getHibernateTemplate().delete(tea);
	}
	@Transactional
	public void addTeacher(Teacher tea){
		try{
			this.getHibernateTemplate().save(tea);
		}catch (Exception ex) {
			ex.printStackTrace();
	}
	
	}

	@Override
	@Transactional
	public void updatePwd(Teacher teacher) {
		Teacher tea=(Teacher)this.getHibernateTemplate().get(Teacher.class, teacher);
		if(tea!=null)
			this.getHibernateTemplate().saveOrUpdate(tea);
		
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
//-----------------
	@Override
	public List<Teacher> showTeacherBydid(String did) {
		return (List<Teacher>)getHibernateTemplate().find("from shiep.bean.Teacher where did='"+did+"'");
	}
}
