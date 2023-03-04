package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import member.bean.MemberDTO;

public class MemberDAO {
	private Connection conn; //Connection�������̽��� conn���� ���� ->�޼ҵ�� ��ü ����
	private PreparedStatement pstmt; //PreparedStatement pstmt���� ����, ���̵忪�� ->�޼ҵ�� ��ü ����
	private ResultSet rs;
	
	private String driver = "oracle.jdbc.driver.OracleDriver"; //Ǯ ���� �������� ����(��Ű���� ����)
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "C##JAVA";
	private String password = "1234";
	
	//static���� �����ϸ� �޸𸮿� 1���� ����(�̱���)(�ѹ���������� ��� ����ִ�)  
	private static MemberDAO memberDAO = new MemberDAO();
	
	public static MemberDAO getInstance() {
		
		return memberDAO;
	}
	
	//driver loading
	public MemberDAO() {
		try {
			Class.forName(driver); //new�� �ƴ϶�ClassŸ������ ����
			System.out.println("driver loading ����"); 
			} catch (ClassNotFoundException e) {
					e.printStackTrace();
			} 
	}
	
	public void getConnection() {
		try {
		conn = DriverManager.getConnection(url,username,password);
		System.out.println("connection ����");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String memberLogin(String id, String pwd) {
		String name = null;
		String sql ="select * from member where id=? and pwd=?";
		getConnection(); //����
		try {
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
	
	public int memberUpdate(MemberDTO dto) {
		
		int su=0;

		getConnection(); // ����
		
		String sql = "update member set name=?, pwd=?, gender=?, email1=?, email2=?, tel1=?, tel2=?, tel3=?, zipcode=?, addr1=?, addr2=? where id=?";
		
		try {
			pstmt = conn.prepareStatement(sql); //���̵� ����
			pstmt.setString(1, dto.getName());//?�� ������ ����
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getGender());
			pstmt.setString(4, dto.getEmail1());
			pstmt.setString(5, dto.getEmail2());
			pstmt.setString(6, dto.getTel1());
			pstmt.setString(7, dto.getTel2());
			pstmt.setString(8, dto.getTel3());
			pstmt.setString(9, dto.getZipcode());
			pstmt.setString(10, dto.getAddr1());
			pstmt.setString(11, dto.getAddr2());
			pstmt.setString(12, dto.getId());
			su = pstmt.executeUpdate();//���� - ���� ����
			System.out.println(su+"�� ��(��) ������Ʈ �Ǿ����ϴ�.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MemberDAO.close(conn, pstmt);
		}
		
		return su;
	}
	
	public int memberWrite(MemberDTO memberDTO) {
		int su = 0;
		
		this.getConnection(); //����
		String sql = "insert into member values(?,?,?,?,?,?,?,?,?,?,?,?,sysdate)";
		
		try {
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
