package shiep.dao;

import java.util.List;

import shiep.bean.Testprogress;

public interface TestprogressDao {
	public List<Testprogress> findByStatus(String did);
	public void checked(Testprogress  testprogress);
}
