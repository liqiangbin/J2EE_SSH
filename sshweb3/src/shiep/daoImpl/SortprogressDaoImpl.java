package shiep.daoImpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shiep.bean.Matchmessage;
import shiep.bean.Sortprogress;
import shiep.dao.BaseDao;
import shiep.dao.SortprogressDao;
@Service("SortprogressDao")
public class SortprogressDaoImpl  extends BaseDao implements SortprogressDao{

	@Transactional
	public void sortTeacher(Sortprogress sortprogress) {
		try{
		       this.getHibernateTemplate().saveOrUpdate(sortprogress);
			}catch(Exception ex){
				ex.printStackTrace();
			}
	}
	@Override
	public List<Sortprogress> findByDeptstatus(String dept) {
		try{
			String queryStr="from shiep.bean.Sortprogress  where did='"+dept+"' ";
			return (List<Sortprogress>)getHibernateTemplate().find(queryStr);
		}catch(RuntimeException e){
			throw e;
		}
	}
@Transactional
	public void save(Sortprogress sortprogress) {
	try{
	       this.getHibernateTemplate().save(sortprogress);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
}
