package shiep.daoImpl;

import java.util.List;

import org.springframework.stereotype.Service;

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

}