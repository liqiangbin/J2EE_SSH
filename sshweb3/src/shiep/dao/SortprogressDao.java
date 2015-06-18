package shiep.dao;

import java.util.List;

import shiep.bean.Sortprogress;

public interface SortprogressDao {
	public List<Sortprogress> findByDeptstatus(String dept);
	public void sortTeacher(Sortprogress sortprogress);
	public void save(Sortprogress sortprogress);
	public List<Sortprogress> findteachingByTeacher(String tid);
	public List<Sortprogress> findtestByTeacher(String tid);
	public void saveorupdate(Sortprogress sortprogress);
}
