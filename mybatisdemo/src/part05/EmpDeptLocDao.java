package part05;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import part03.dto.EmpDTO;

public class EmpDeptLocDao {
	SqlSession session;
	
	public EmpDeptLocDao() {

		String resource = "config/configuration.xml";

		try {
			Reader reader = Resources.getResourceAsReader(resource);

			SqlSessionFactoryBuilder build = new SqlSessionFactoryBuilder();

			SqlSessionFactory factory = build.build(reader);

			session = factory.openSession(true);

			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}//end EmpDepDao()
	
	
	public List<part05.EmpDTO> listMethod(){
		return session.selectList("join.emp_dept_loc");
	}
	
	public List<part05.EmpDTO> lastMethod(){
		return session.selectList("join.emp_dept_loc2");
	}
	
	
}//end class
