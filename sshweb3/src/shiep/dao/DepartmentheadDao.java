package shiep.dao;

import java.util.List;

import shiep.bean.Departmenthead;

public interface DepartmentheadDao {
public List<Departmenthead> findAllDepartmenthead();
public List<Departmenthead> findDepartmentheadById(String id);
public List<Departmenthead> Departmentheadlogin(String id,String password);
}
