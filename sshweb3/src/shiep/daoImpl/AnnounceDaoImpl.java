package shiep.daoImpl;

import java.util.List;

import org.springframework.stereotype.Service;

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
	public List<Announce> findBydept(Announce announce) {
		try{
			String hql="from shiep.bean.Announce  where did="+announce.getDid()+"";
			return (List<Announce>)getHibernateTemplate().find(hql);
		}catch(RuntimeException e){
			throw e;
		}
	}
	@Override
	public List<Announce> searchBydept(Announce announce) {
		try{
			String hql="from shiep.bean.Announce  where did="+announce.getDid()+" and  title like '%"+announce.getTitle()+"%'";
			return (List<Announce>)getHibernateTemplate().find(hql);
		}catch(RuntimeException e){
			throw e;
		}
	}
}
