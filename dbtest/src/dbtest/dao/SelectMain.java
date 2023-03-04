package dbtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectMain {
	private Connection conn;
	private PreparedStatement pstmt; //���̵忪��
	private ResultSet rs; //select�Ҷ� �ʿ��ϴ�(���̺� ���¸� �����´�)
	
	private String driver = "oracle.jdbc.driver.OracleDriver"; //Ǯ ���� �������� ����(��Ű���� ����)
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "C##JAVA";
	private String password = "1234";
	
	public SelectMain() {
	//�����ڴ� ��ü�� �����Ҷ� �ѹ��� ����
		
	//driver loading
	try {
		Class.forName(driver); //ClassŸ������ ����
		System.out.println("driver loading ����"); 
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
				} 
	}
	
	//������ �ȿ��� ���� �ϸ� �ȵ�(�ѹ��� �����)
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("connection ����");
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
		
	public void selectArticle() {
		
		getConnection(); //����
			
		String sql = "SELECT * FROM DBTEST";
			
		try {
			 pstmt = conn.prepareStatement(sql); //���̵� ����
			 rs = pstmt.executeQuery(); //���� = ResultSet ����
	
			 while(rs.next()) { //rs.next() : ��ġ�� ���߰� ���ڵ尡 ������ true -> ���� ���ڵ�� �̵�, ������ false 
					System.out.println(rs.getString("name")+"\t"
									  +rs.getInt("age")+"\t"
									  +rs.getDouble("height")+"\t"
									  +rs.getString("logtime"));
					}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null)conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	public static void main(String[] args) {
		SelectMain sm = new SelectMain();
		sm.selectArticle();

	}

}
