package dbtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertMain {
	private Connection conn; //Connection�������̽��� conn���� ���� ->�޼ҵ�� ��ü ����
	private PreparedStatement pstmt; //PreparedStatement pstmt���� ����, ���̵忪�� ->�޼ҵ�� ��ü ����
	
	private String driver = "oracle.jdbc.driver.OracleDriver"; //Ǯ ���� �������� ����(��Ű���� ����)
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "C##JAVA";
	private String password = "1234";
	
	
	public InsertMain() {
		//�����ڴ� ��ü�� �����Ҷ� �ѹ��� ����
		
		//driver loading
		//"OracleDriver.class" Ŭ����? �������̽�? => Class Ÿ������ ����(public class Class)
		//���⼭ class�� public class Class�� �̸��� Class��� ���� ����
		try {
			Class.forName(driver); //new�� �ƴ϶�ClassŸ������ ����
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
	
	public void insertArticle() {
		String sql = "INSERT INTO DBTEST VALUES(?,?,?,SYSDATE)";
		
		Scanner scan = new Scanner(System.in);
		System.out.print("�̸� �Է� : ");
		String name = scan.next();
		System.out.print("���� �Է� : ");
		int age = scan.nextInt();
		System.out.print("Ű �Է� : ");
		double height = scan.nextDouble();

		this.getConnection(); // ����
		
		try {
			pstmt = conn.prepareStatement(sql); //���̵� ����
			//?�� ������ ����
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setDouble(3, height);
			int su = pstmt.executeUpdate();//���� - ���� ����
			System.out.println(su+"�� ��(��) ���ԵǾ����ϴ�.");
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
		InsertMain im = new InsertMain();
		im.insertArticle();
	
	}

}
