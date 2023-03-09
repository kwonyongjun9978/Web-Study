package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import board.bean.BoardDTO;



public class BoardDAO {
	private Connection conn; //Connection�������̽��� conn���� ���� ->�޼ҵ�� ��ü ����
	private PreparedStatement pstmt; //PreparedStatement pstmt���� ����, ���̵忪�� ->�޼ҵ�� ��ü ����
	private ResultSet rs;
	
	private DataSource ds;
	
	//static���� �����ϸ� �޸𸮿� 1���� ����(�̱���)(�ѹ���������� ��� ����ִ�)
	private static BoardDAO boardDAO = new BoardDAO();
	
	public static BoardDAO getInstance() {
		return boardDAO;
	}
	
	//driver loading
	public BoardDAO() {
		
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle"); //Tomcat������ java:comp/env/ �پ�� �Ѵ�.
		} catch (NamingException e) {
			e.printStackTrace();
		} 
		
	}
			
	/*
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
	*/
	
	//map���
	public void boardWrite(Map<String, String> map) {
		String sql = "insert into board(seq,id,name,email,subject,content,ref)values(seq_board.nextval,?,?,?,?,?,seq_board.currval)";
		int su =0;
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setString(1, map.get("id"));
			pstmt.setString(2, map.get("name"));
			pstmt.setString(3, map.get("email"));
			pstmt.setString(4, map.get("subject"));
			pstmt.setString(5, map.get("content"));
			
			su = pstmt.executeUpdate(); //����
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BoardDAO.close(conn, pstmt);
	    }
	}
	
	public List<BoardDTO> boardList() {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		String sql = "select * from board order by ref desc, step asc";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); //���� - ResultSet����
			
			while(rs.next()) {
				BoardDTO boardDTO = new BoardDTO();
				boardDTO.setSeq(rs.getInt("seq"));
				boardDTO.setId(rs.getString("id"));
				boardDTO.setName(rs.getString("name"));
				boardDTO.setEmail(rs.getString("email"));
				boardDTO.setSubject(rs.getString("subject"));
				boardDTO.setContent(rs.getString("content"));
				boardDTO.setRef(rs.getInt("ref"));
				boardDTO.setLev(rs.getInt("lev"));
				boardDTO.setStep(rs.getInt("step"));
				boardDTO.setPseq(rs.getInt("pseq"));
				boardDTO.setReply(rs.getInt("reply"));
				boardDTO.setHit(rs.getInt("hit"));
				boardDTO.setLogtime(rs.getDate("logtime"));

				list.add(boardDTO);
			}//while
		} catch (SQLException e) {
			e.printStackTrace();
			list = null;
		} finally {
			BoardDAO.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public int getTotalA() {
		int totalA = 0;
		String sql = "select count(*) from board";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			rs.next();
			totalA = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BoardDAO.close(conn, pstmt, rs);
		}
		return totalA;
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
