package user.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import user.bean.UserDTO;

public class UserDAO {
	private SqlSessionFactory sqlSessionFactory;
	
	public UserDAO() {
		//���� ����
		//Reader reader = Resources.getResourceAsReader("mybatis-config.xml"); //Reader�� �߻�Ŭ����
		
		//byte����
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	public void write(UserDTO userDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession(); //����
		sqlSession.insert("write", userDTO);
		sqlSession.commit();
		sqlSession.close();
	}

}
