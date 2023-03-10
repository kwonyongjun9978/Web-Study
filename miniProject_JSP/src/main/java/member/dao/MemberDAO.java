package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import member.bean.MemberDTO;

public class MemberDAO {
	private Connection conn; //Connection�������̽��� conn���� ���� ->�޼ҵ�� ��ü ����
	private PreparedStatement pstmt; //PreparedStatement pstmt���� ����, ���̵忪�� ->�޼ҵ�� ��ü ����
	private ResultSet rs;

	private DataSource ds;
	//static���� �����ϸ� �޸𸮿� 1���� ����(�̱���)(�ѹ���������� ��� ����ִ�)  
	private static MemberDAO memberDAO = new MemberDAO();
	
	public static MemberDAO getInstance() {
		
		return memberDAO;
	}
	
	
	public MemberDAO() {
		
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle"); //Tomcat������ java:comp/env/ �پ�� �Ѵ�.
		} catch (NamingException e) {
			e.printStackTrace();
		} 
	}
	
	
	/*
	public String getEmailTo(String id, String pwd) {
		String email = null;
		String sql ="select * from member where id=? and pwd=?";
		getConnection(); //����
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2,pwd);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				email = rs.getString("email1")+"@"+rs.getString("email2");
			}
			}catch (SQLException e) {
				e.printStackTrace();
			} finally {
				MemberDAO.close(conn, pstmt,rs);
			}
				
		return email;
	}
	*/
	
	public MemberDTO getEmailTo(String id, String pwd) {
		MemberDTO memberDTO = null;
		
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
		String name = null;
		String sql ="select * from member where id=? and pwd=?";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2,pwd);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				name = rs.getString("name");
			}
			}catch (SQLException e) {
				e.printStackTrace();
			} finally {
				MemberDAO.close(conn, pstmt,rs);
			}
				
		return name;
	}
	
	public MemberDTO getMember(String id) {
		MemberDTO memberDTO = null;
		
		String sql = "select * from member where id=?";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql); //���̵� ����
			pstmt.setString(1, id);//?�� ������ ����
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				memberDTO = new MemberDTO(); //����
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
		int su = 0;
		
		String sql = "insert into member values(?,?,?,?,?,?,?,?,?,?,?,?,sysdate)";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql); //����
			
			//?�� ������ ����
			pstmt.setString(1, memberDTO.getName());
			pstmt.setString(2, memberDTO.getId());
			pstmt.setString(3, memberDTO.getPwd());
			pstmt.setString(4, memberDTO.getGender());
			pstmt.setString(5, memberDTO.getEmail1());
			pstmt.setString(6, memberDTO.getEmail2());
			pstmt.setString(7, memberDTO.getTel1());
			pstmt.setString(8, memberDTO.getTel2());
			pstmt.setString(9, memberDTO.getTel3());
			pstmt.setString(10, memberDTO.getZipcode());
			pstmt.setString(11, memberDTO.getAddr1());
			pstmt.setString(12, memberDTO.getAddr2());
			
			su = pstmt.executeUpdate();//���� - ���� ����
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MemberDAO.close(conn, pstmt);
		}
		
		return su;
	}
	
	public void memberUpdate(MemberDTO memberDTO){
		String sql = "update member set name=?, pwd=?, gender=?, email1=?, email2=?, tel1=?, tel2=?, tel3=?, zipcode=?, addr1=?, addr2=?, logtime=sysdate where id=?";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			//?�� ������ ����
			pstmt.setString(1, memberDTO.getName());
			pstmt.setString(2, memberDTO.getPwd());
			pstmt.setString(3, memberDTO.getGender());
			pstmt.setString(4, memberDTO.getEmail1());
			pstmt.setString(5, memberDTO.getEmail2());
			pstmt.setString(6, memberDTO.getTel1());
			pstmt.setString(7, memberDTO.getTel2());
			pstmt.setString(8, memberDTO.getTel3());
			pstmt.setString(9, memberDTO.getZipcode());
			pstmt.setString(10, memberDTO.getAddr1());
			pstmt.setString(11, memberDTO.getAddr2());
			pstmt.setString(12, memberDTO.getId());
			
			pstmt.executeUpdate(); //���� ����
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MemberDAO.close(conn, pstmt);
		}
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
		String sql = "delete member where id=?";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MemberDAO.close(conn, pstmt);
		}
	}

	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			if(pstmt != null) pstmt.close();
			if(conn != null)conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null)conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
