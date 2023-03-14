package user.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import user.bean.UserDTO;

public class UserDAO {
	private SqlSessionFactory sqlSessionFactory;
	private static UserDAO userDAO = new UserDAO();
	
	public static UserDAO getInstance() {
		return userDAO;
	}
	
	public UserDAO() {
		//巩磊 窜困
		//Reader reader = Resources.getResourceAsReader("mybatis-config.xml"); //Reader绰 眠惑努贰胶
		
		//byte窜困
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void write(UserDTO userDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession(); //积己
		sqlSession.insert("userSQL.write", userDTO);
		sqlSession.commit();
		sqlSession.close();
	}

	public List<UserDTO> getUserList() {
		SqlSession sqlSession = sqlSessionFactory.openSession(); //积己
		List<UserDTO> list = sqlSession.selectList("userSQL.getUserList");
		sqlSession.close();
		return list;
	}

	public UserDTO getUser(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession(); //积己
		UserDTO userDTO = sqlSession.selectOne("userSQL.getUser", id);
		sqlSession.close();
		return userDTO;
	}

	public void update(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession(); //积己
		sqlSession.update("userSQL.update", map);
		sqlSession.commit();
		sqlSession.close();
	}

	public void delete(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession(); //积己
		sqlSession.delete("userSQL.delete", map);
		sqlSession.commit();
		sqlSession.close();
	}

	public List<UserDTO> getUserName(String name) {
		SqlSession sqlSession = sqlSessionFactory.openSession(); //积己
		List<UserDTO> list = sqlSession.selectList("userSQL.getUserName", name);
		sqlSession.close();
		return list;
	}
	
	public UserDTO getUserId(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession(); //积己
		UserDTO userDTO = sqlSession.selectOne("userSQL.getUserId", id);
		sqlSession.close();
		return userDTO;
	}

}
