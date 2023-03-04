package dbtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateMain {
	private Connection conn;
	private PreparedStatement pstmt; //���̵忪��
	private String driver = "oracle.jdbc.driver.OracleDriver"; //Ǯ ���� �������� ����(��Ű���� ����)
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "C##JAVA";
	private String password = "1234";
	
	public UpdateMain() {
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
	
	public void updateArticle() {
		Scanner scan = new Scanner(System.in);
		System.out.print("�˻��� �̸� �Է� : ");
		String name = scan.next();
	
		getConnection(); // ����
		
		String sql = "update dbtest set age=age+1, height=height+1 where name like ?";
		
		try {
			pstmt = conn.prepareStatement(sql); //���̵� ����
			pstmt.setString(1,"%"+name+"%"); //?�� ������ ����
			int su = pstmt.executeUpdate();//���� - ���� ����
			System.out.println(su+"�� ��(��) ������Ʈ �Ǿ����ϴ�.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		UpdateMain um = new UpdateMain();
		um.updateArticle();

	}
}
/*
�˻� �� �̸� �Է� : ȫ

�̸��� ȫ�� �� ���ڵ带 ���̸� 1����, Ű�� 1���� �Ͻÿ�
 */