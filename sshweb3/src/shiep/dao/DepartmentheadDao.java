package shiep.dao;

import java.util.List;

import shiep.bean.Departmenthead;

public interface DepartmentheadDao {
public List<Departmenthead> findAllDepartmenthead();
public List<Departmenthead> findDepartmentheadById(String id);
public boolean login(String username,String password);
public void updatemyself(Departmenthead depthead);

}
