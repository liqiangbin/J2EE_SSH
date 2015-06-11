package shiep.dao;

import java.util.List;

import shiep.bean.PageBean;
import shiep.bean.Teacher;

public interface TeacherDao {
	public List<Teacher> showAllTeacher();
	public boolean teacherLogin(String id, String password);
	public void deleteTeacher(String tid);
	public void addTeacher(Teacher tea);
	public void updatePwd(Teacher tea);
	public List queryForPage(final String hql,final int offset,final int length);
	public int getAllRowCount(String hql);
	//------------------
	public List<Teacher> showTeacherBydid(String did);
}
