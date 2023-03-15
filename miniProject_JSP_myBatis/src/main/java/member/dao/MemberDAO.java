package member.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import member.bean.MemberDTO;
import user.bean.UserDTO;

public class MemberDAO {
	private SqlSessionFactory sqlSessionFactory;
	private static MemberDAO memberDAO = new MemberDAO();
	
	public static MemberDAO getInstance() {
		
		return memberDAO;
	}
	
	
	public MemberDAO() {
		//byte단위
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public MemberDTO getEmailTo(String id, String pwd) {
		HashMap<String, String> param = new HashMap<String, String>();
		
		param.put("id", id);
		param.put("pwd", pwd);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MemberDTO memberDTO = sqlSession.selectOne("memberSQL.memberLogin", param);
		
		String sql ="select * from member where id=? and pwd=?";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2,pwd);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				memberDTO = new MemberDTO();
				memberDTO.setName(rs.getString("email1"));
				memberDTO.setName(rs.getString("email2"));
			}
			}catch (SQLException e) {
				e.printStackTrace();
			} finally {
				MemberDAO.close(conn, pstmt,rs);
			}
				
		return memberDTO;
	}
	
	public String memberLogin(String id, String pwd) {
		HashMap<String, String> param = new HashMap<String, String>();
		
		param.put("id", id);
		param.put("pwd", pwd);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		String name = sqlSession.selectOne("memberSQL.memberLogin", param);
		sqlSession.close();
	
		return name;	
	}
	
	public MemberDTO getMember(String id) {
		MemberDTO memberDTO = null;
		
		String sql = "select * from member where id=?";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql); //가이드 생성
			pstmt.setString(1, id);//?에 데이터 대입
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				memberDTO = new MemberDTO(); //생성
				memberDTO.setName(rs.getString("name"));
				memberDTO.setId(rs.getString("id"));
				memberDTO.setPwd(rs.getString("pwd"));
				memberDTO.setGender(rs.getString("gender"));
				memberDTO.setEmail1(rs.getString("email1"));
				memberDTO.setEmail2(rs.getString("email2"));
				memberDTO.setTel1(rs.getString("tel1"));
				memberDTO.setTel2(rs.getString("tel2"));
				memberDTO.setTel3(rs.getString("tel3"));
				memberDTO.setZipcode(rs.getString("zipcode"));
				memberDTO.setAddr1(rs.getString("addr1"));
				memberDTO.setAddr2(rs.getString("addr2"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MemberDAO.close(conn, pstmt, rs);
		}
		
		System.out.println(memberDTO);
		return memberDTO;
	}
	
	public int memberWrite(MemberDTO memberDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		int su  = sqlSession.insert("memberSQL.memberWrite", memberDTO);
		sqlSession.commit();
		sqlSession.close();

		return su;
	}
	
	public boolean memberUpdate(MemberDTO memberDTO){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		int resultReturn = sqlSession.update("memberSQL.memberUpdate",  memberDTO);
		sqlSession.commit();
		sqlSession.close();
		
		boolean result = resultReturn > 0 ? true : false;
		
		return result;
	}
	
	public boolean isExistPwd(String id, String pwd) {
		boolean exist = false;
		
		String sql = "select * from member where id=? and pwd=?";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) exist = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MemberDAO.close(conn, pstmt, rs);
		}
		
		return exist;
	}
	
	public boolean isExistID(String id) {
		boolean existId = false;
		
		String sql = "select * from member where id=?";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) existId = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MemberDAO.close(conn, pstmt, rs);
		}
		
		return existId;
	}
	
	public void memberDelete(String id) {
		
	}
}
