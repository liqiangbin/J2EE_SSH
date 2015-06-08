package shiep.dao;

import javax.annotation.Resource;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
@Repository
public class BaseDao extends HibernateDaoSupport{
	@Resource(name="sessionFactory") 
    public void setSuperSessionFactory(org.hibernate.SessionFactory sessionFactory){
      super.setSessionFactory(sessionFactory);
    }
}
