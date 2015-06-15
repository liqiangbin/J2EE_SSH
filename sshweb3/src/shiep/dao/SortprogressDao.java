package shiep.dao;

import java.util.List;

import shiep.bean.Sortprogress;

public interface SortprogressDao {
	public List<Sortprogress> findByDeptstatus(String dept);
	public void sortTeacher(Sortprogress sortprogress);
	public void save(Sortprogress sortprogress);

}
