package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import board.bean.BoardDTO;

public class BoardDAO {
	private Connection conn; //Connection�������̽��� conn���� ���� ->�޼ҵ�� ��ü ����
	private PreparedStatement pstmt; //PreparedStatement pstmt���� ����, ���̵忪�� ->�޼ҵ�� ��ü ����
	private ResultSet rs;
	
	private String driver = "oracle.jdbc.driver.OracleDriver"; //Ǯ ���� �������� ����(��Ű���� ����)
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "C##JAVA";
	private String password = "1234";
	
	//static���� �����ϸ� �޸𸮿� 1���� ����(�̱���)(�ѹ���������� ��� ����ִ�)
	private static BoardDAO boardDAO = new BoardDAO();
	
	public static BoardDAO getInstance() {
		return boardDAO;
	}
	
	//driver loading
	public BoardDAO() {
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
	
	public int boardWrite(BoardDTO boardDTO) {
		String sql = "insert into board(seq,id,name,email,subject,content,ref)values(seq_board.nextval,?,?,?,?,?,seq_board.nextval)";
		int su =0;
		getConnection(); //����
		try {
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setString(1, boardDTO.getId());
			pstmt.setString(2, boardDTO.getName());
			pstmt.setString(3, boardDTO.getEmail());
			pstmt.setString(4, boardDTO.getSubject());
			pstmt.setString(5, boardDTO.getContent());
			
			su = pstmt.executeUpdate(); //����
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BoardDAO.close(conn, pstmt);
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
}
