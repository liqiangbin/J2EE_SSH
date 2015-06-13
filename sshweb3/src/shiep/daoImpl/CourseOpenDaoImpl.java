package shiep.daoImpl;

import java.util.List;

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

}
