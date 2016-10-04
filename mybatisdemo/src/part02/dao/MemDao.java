package part02.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import part02.dto.MemDTO;

public class MemDao {
	SqlSession session;

	public MemDao() {

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

	}//end MemDao()

	public List<MemDTO> allMethod() {

		return session.selectList("mem.all");
	}

	public void insertMethod(MemDTO dto){
		session.insert("mem.ins",dto);
		session.commit();
	}
	
	public void updateMethod(HashMap<String, Object> map){
		session.update("mem.upt",map);
		session.commit();
	}
	
	public void deleteMethod(int num){
		session.delete("mem.del",num);
		session.commit();
	}
	
	public int keyMethod(){
		return session.selectOne("mem.keyNum");
	}
	
	public void multiInsertMethod(List<MemDTO> list){
		session.insert("mem.multiIns", list);
	}
	
	public int MultiDeleteMethod(List<Integer> list){
		return session.delete("mem.multiDel",list);
	}
	
	public int MultiDeleteMethod(Integer[] list){
		return session.delete("mem.multiDel2",list);
	}
	
}// end class
