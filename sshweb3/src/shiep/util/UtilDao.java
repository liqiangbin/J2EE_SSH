package shiep.util;

import java.util.List;

import shiep.bean.Course;

public class UtilDao {
	public void InsertCourse(List<Course> list){
		try{
			for(int i=0;i<list.size();i++){
				Course s=list.get(i);
			String sql = "insert into course values('"+s.getId()+"','"+s.getName()+"','"+s.getTextbook()+"')";	
			DBhelper. executeUpdate(sql);
			}}
			catch(Exception e){
				e.printStackTrace();
				
			}
		
	}

}
