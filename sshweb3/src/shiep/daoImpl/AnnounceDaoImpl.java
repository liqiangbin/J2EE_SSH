package shiep.daoImpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shiep.bean.Announce;
import shiep.bean.Customer;
import shiep.dao.AnnounceDao;
import shiep.dao.BaseDao;
@Service("AnnounceDao")
public class AnnounceDaoImpl  extends BaseDao implements AnnounceDao{
	@Override
	public List<Announce> findByStatus() {
		try{
			String queryStr="from shiep.bean.Announce  where status=1";
			return (List<Announce>)getHibernateTemplate().find(queryStr);
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@Override
	public List<Announce> searchBytable(Announce announce) {
		try{
			String hql="from shiep.bean.Announce  where status=1 and  title like '%"+announce.getTitle()+"%'";
			return (List<Announce>)getHibernateTemplate().find(hql);
		}catch(RuntimeException e){
			throw e;
		}
	}
	@Override
	public List<Announce> findBydept(String did) {
		try{
			String hql="from shiep.bean.Announce  where did="+did+"";
			return (List<Announce>)getHibernateTemplate().find(hql);
		}catch(RuntimeException e){
			throw e;
		}
	}
	@Override
	public List<Announce> searchBydept( String did,Announce announce) {
		try{
			String hql="from shiep.bean.Announce  where did="+did+" and  title like '%"+announce.getTitle()+"%'";
			return (List<Announce>)getHibernateTemplate().find(hql);
		}catch(RuntimeException e){
			throw e;
		}
	}
	@Override
	public void delete(int id) {
		Announce a=(Announce)this.getHibernateTemplate().get(Announce.class, id);
		 if(a!=null)
	       this.getHibernateTemplate().delete(a);
		
	}
	
	 @Transactional
		public void add(Announce announce){
			try{
		       this.getHibernateTemplate().save(announce);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
}
