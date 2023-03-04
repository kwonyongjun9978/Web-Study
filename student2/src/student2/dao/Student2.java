package student2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Student2 {
	Scanner scn = new Scanner(System.in);
	private Connection conn;
	private PreparedStatement pstmt; //���̵忪��
	private ResultSet rs; //select�Ҷ� �ʿ��ϴ�(���̺� ���¸� �����´�)
	
	private String driver = "oracle.jdbc.driver.OracleDriver"; //Ǯ ���� �������� ����(��Ű���� ����)
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "C##JAVA";
	private String password = "1234";
	
	public Student2() {
		//�����ڴ� �ѹ��� ����
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
	
	public void menu() {
		while(true) {	
			System.out.println("****************");
			System.out.println("  ����");
			System.out.println("****************");
			System.out.println(" 1.�Է�");
			System.out.println(" 2.�˻�");
			System.out.println(" 3.����");
			System.out.println(" 4.����");
			System.out.println("****************");
			System.out.print(" ��ȣ���� : ");
			int num = scn.nextInt();
			
			System.out.println();
			if(num == 4) {
				System.out.print("���α׷��� �����մϴ�");
				break;
			}
			else if(num == 1) insertArticle();
			else if(num == 2) selectArticle();
			else if(num == 3) deleteArticle();
		}//while
	}//menu
	
	public void insertArticle() {
	      int num;
	      
	      while(true) {
	         System.out.println();
	         System.out.println("****************");
	         System.out.println("   1. �л�");
	         System.out.println("   2. ����");
	         System.out.println("   3. ������");
	         System.out.println("   4. �����޴�");
	         System.out.println("****************");
	         System.out.print("   ��ȣ �Է� : ");
	         num = scn.nextInt();
	         if(num == 4) break;
	         
	         System.out.println();
	         
	         String name, value=null;
	         
	         System.out.print("�̸� �Է� : ");
	         name = scn.next();
	         
	         if(num == 1) {
	            System.out.print("�й� �Է� : ");
	            value = scn.next();
	         }else if(num == 2) {
	            System.out.print("���� �Է� : ");
	            value = scn.next();
	         }else if(num == 3) {
	            System.out.print("�μ� �Է� : ");
	            value = scn.next();
	         }
	         
	         //DB - insert
	         getConnection(); //����
	         
	         String sql = "INSERT INTO STUDENT2 VALUES(?,?,?)";
	         try {
	            pstmt = conn.prepareStatement(sql); //����
	            
	            //?�� ������ ����
	            pstmt.setString(1, name);
	            pstmt.setString(2, value);
	            pstmt.setInt(3, num);
	            
	            int su = pstmt.executeUpdate();//����
	            System.out.println(su + " ���� ���� �Ǿ����ϴ�.");
	            
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
	         
	      }//while
	      
	}//insertArticle
	
	private void selectArticle() {
		int num;
		
		while(true) {
			 System.out.println();
	         System.out.println("****************");
	         System.out.println("   1. �̸� �˻� (1�� ���ڰ� ���Ե� �̸��� ��� �˻�)");
	         System.out.println("   2. ��ü �˻�");
	         System.out.println("   3. �����޴�");
	         System.out.println("****************");
	         System.out.print("   ��ȣ �Է� : ");
	         num = scn.nextInt();
	         if(num == 3) break;
	         
	         System.out.println();
	         
	         //������
	         String name=null;
	         if(num == 1) {
	        	 System.out.print("�˻��� �̸� �Է�(1���� �Է�) : ");
	        	 name = scn.next();
	         }
	         
	         //DB - select
	         getConnection(); //����
	         
	         String sql =null;
	         if(num == 1) {
	        	 sql = "select * from STUDENT2 where name like ?";
	         }
	         else
	        	 sql = "select * from STUDENT2";
	         try {
	            pstmt = conn.prepareStatement(sql); //����
	            
	            if(num == 1) pstmt.setString(1, "%"+name+"%");
	        
	             rs = pstmt.executeQuery();//����
	            while(rs.next()) {
	            	System.out.print("�̸� = " +rs.getString("name")+"\t");
	            	
	            	if(rs.getInt("code") == 1)
	            		System.out.println("�й� = " +rs.getString("value"));
	            	else if(rs.getInt("code") == 2)
	            		System.out.println("���� = " +rs.getString("value"));
	            	else if(rs.getInt("code") == 3)
	            		System.out.println("�μ� = " +rs.getString("value"));
	            }//while
	      
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
		}//while
		
	}//selectArticle
	
	private void deleteArticle() {
		System.out.print("������ �̸� �Է� : ");
		String name = scn.next();
		
		getConnection(); //����
		
		String sql = "DELETE FROM STUDENT2 WHERE NAME=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			int su = pstmt.executeUpdate();//���� - ���� ����
			System.out.println(su+"�� ��(��) ���� �Ǿ����ϴ�.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//finally
	}//deleteArticle
	
	public static void main(String[] args) {
		Student2 student2 = new Student2();
		student2.menu();

	}

}
/*
[����]
Project  : student
Package : student.dao
Class    : Student.java

# ���̺� �ۼ�
create table student2(
name  varchar2(15)  not  null, -- �̸�
value   varchar2(15), -- �й� or ���� or �μ�
code   number   -- 1�̸� �л�, 2�̸� ����, 3�̸� ������
);

menu()
****************
   ����
****************
  1. �Է�
  2. �˻�
  3. ����
  4. ����
****************
  ��ȣ���� : 4
���α׷� �����մϴ�


1���� ���
insertArticle()
****************
   1. �л�
   2. ����
   3. ������
   4. �����޴�
****************
   ��ȣ���� : 

1�� �л��� ���
�̸��Է� : 
�й��Է� : 

2�� ������ ���
�̸��Է� : 
�����Է� : 

3�� �������� ���
�̸��Է� : 
�μ��Է� : 

2���� ���
selectArticle()
****************
   1. �̸� �˻� (1�� ���ڰ� ���Ե� �̸��� ��� �˻�)
   2. ��ü �˻�
   3. �����޴�
****************
   ��ȣ���� : 1

1�� ���
�˻��� �̸� �Է� : ��
�̸�=����	�й�=2015
�̸�=�̱���	����=JAVA

3���� ���
deleteArticle()
������ ���ϴ� �̸� �Է� : (��Ȯ�ϰ� 3���� ���ڰ� ��� �Էµ� ����)
*/
