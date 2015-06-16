package shiep.daoImpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shiep.bean.Matchmessage;
import shiep.dao.AnnounceDao;
import shiep.dao.BaseDao;
import shiep.dao.MatchmessageDao;
@Service("MatchmessageDao")
public class MatchmessageDaoImpl extends BaseDao implements MatchmessageDao {

	@Override
	public List<Matchmessage> findByDeptstatus(String dept) {
		try{
			String queryStr="from shiep.bean.Matchmessage  where did='"+dept+"' ";
			return (List<Matchmessage>)getHibernateTemplate().find(queryStr);
		}catch(RuntimeException e){
			throw e;
		}
	}
	@Transactional
	public void sortTeacher(Matchmessage matchmessage) {
		try{
		       this.getHibernateTemplate().saveOrUpdate(matchmessage);
			}catch(Exception ex){
				ex.printStackTrace();
			}
	}
	@Override
	public List<Matchmessage> findAll() {
		
		try{
			String queryStr="from shiep.bean.Matchmessage";
			return (List<Matchmessage>)getHibernateTemplate().find(queryStr);
		}catch(RuntimeException e){
			throw e;
		}
	}
	@Override
	@Transactional
	public void save(Matchmessage matchmessage) {
		try{
		       this.getHibernateTemplate().save(matchmessage);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		
	}
	@Override
	public List<Matchmessage> findBytstatus(String dept) {
		try{
			String queryStr="from shiep.bean.Matchmessage  where tstatus='0' and did='"+dept+"' ";
			return (List<Matchmessage>)getHibernateTemplate().find(queryStr);
		}catch(RuntimeException e){
			throw e;
		}
	}
}
