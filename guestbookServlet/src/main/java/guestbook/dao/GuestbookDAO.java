package guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import guestbook.bean.GuestbookDTO;

public class GuestbookDAO {
	private Connection conn; //Connection�������̽��� conn���� ���� ->�޼ҵ�� ��ü ����
	private PreparedStatement pstmt; //PreparedStatement pstmt���� ����, ���̵忪�� ->�޼ҵ�� ��ü ����
	private ResultSet rs;
	
	private String driver = "oracle.jdbc.driver.OracleDriver"; //Ǯ ���� �������� ����(��Ű���� ����)
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "C##JAVA";
	private String password = "1234";
	
	//static���� �����ϸ� �޸𸮿� 1���� ����(�̱���)(�ѹ���������� ��� ����ִ�)
	private static GuestbookDAO guestbookDAO = new GuestbookDAO();
	
	public static GuestbookDAO getInstance() {
		return guestbookDAO;
	}
	
	//driver loading
		public GuestbookDAO() {
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
		
		public void guestbookWrite(GuestbookDTO guestbookDTO) {
			String sql = "insert into guestbook values(seq_guestbook.nextval, ?, ?, ?, ?, ?, sysdate)";
			
			getConnection(); //����
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, guestbookDTO.getName());
				pstmt.setString(2, guestbookDTO.getEmail());
				pstmt.setString(3, guestbookDTO.getHomepage());
				pstmt.setString(4, guestbookDTO.getSubject());
				pstmt.setString(5, guestbookDTO.getContent());
				
				pstmt.executeUpdate(); //����
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				GuestbookDAO.close(conn, pstmt);
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

		public GuestbookDTO guestbookSearch(String seq) {
			GuestbookDTO guestbookDTO = null;
			String sql = "select seq, name, email, homepage, subject, content, "
					+ "to_char(logtime, 'YYYY.MM.DD')as logtime from guestbook where seq=?";
			
			getConnection();
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(seq)); //seq�� int�� Ÿ��
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					guestbookDTO = new GuestbookDTO();
					guestbookDTO.setSeq(rs.getInt("seq"));
					guestbookDTO.setName(rs.getString("name"));
					guestbookDTO.setEmail(rs.getString("email"));
					guestbookDTO.setHomepage(rs.getString("homepage"));
					guestbookDTO.setSubject(rs.getString("subject"));
					guestbookDTO.setContent(rs.getString("content"));
					guestbookDTO.setLogtime(rs.getString("logtime"));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				GuestbookDAO.close(conn, pstmt, rs);
			}
			return guestbookDTO;
		}

		public ArrayList<GuestbookDTO> guestbookList(int startNum, int endNum) {
			ArrayList<GuestbookDTO> list = new ArrayList<GuestbookDTO>();
			String sql = "select * from"
					   + " (select rownum rn, aa.* from"
					   + " (select seq, name, email, homepage, subject, content, to_char(logtime, 'YYYY.MM.DD') as logtime from guestbook order by seq desc) aa"
					   + ") where rn>=? and rn<=?";
			
			getConnection();
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, startNum);
				pstmt.setInt(2, endNum);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					GuestbookDTO guestbookDTO = new GuestbookDTO();
					guestbookDTO.setSeq(rs.getInt("seq"));
					guestbookDTO.setName(rs.getString("name"));
					guestbookDTO.setEmail(rs.getString("email"));
					guestbookDTO.setHomepage(rs.getString("homepage"));
					guestbookDTO.setSubject(rs.getString("subject"));
					guestbookDTO.setContent(rs.getString("content"));
					guestbookDTO.setLogtime(rs.getString("logtime"));
					
					list.add(guestbookDTO);
				}//while
			} catch (SQLException e) {
				e.printStackTrace();
				list = null;
			} finally {
				GuestbookDAO.close(conn, pstmt, rs);
			}
			
			return list;
		}

		public int getTotalA() {
			int totalA = 0;
			String sql = "select count(*) from guestbook";
			
			getConnection();
			
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				rs.next();
				totalA = rs.getInt(1);
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				GuestbookDAO.close(conn, pstmt, rs);
			}
			return totalA;
		}

}
