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
	private PreparedStatement pstmt; //가이드역할
	private ResultSet rs; //select할때 필요하다(테이블 형태를 가져온다)
	
	private String driver = "oracle.jdbc.driver.OracleDriver"; //풀 쿼리 네임으로 생성(패키지명 포함)
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "C##JAVA";
	private String password = "1234";
	
	public Student2() {
		//생성자는 한번만 실행
		//driver loading
		try {
			Class.forName(driver); //Class타입으로 생성
			System.out.println("driver loading 성공"); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}
	
	//생성자 안에서 접속 하면 안됨(한번만 실행됨)
	public void getConnection() {
		try {
		conn = DriverManager.getConnection(url,username,password);
		System.out.println("connection 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void menu() {
		while(true) {	
			System.out.println("****************");
			System.out.println("  관리");
			System.out.println("****************");
			System.out.println(" 1.입력");
			System.out.println(" 2.검색");
			System.out.println(" 3.삭제");
			System.out.println(" 4.종료");
			System.out.println("****************");
			System.out.print(" 번호선택 : ");
			int num = scn.nextInt();
			
			System.out.println();
			if(num == 4) {
				System.out.print("프로그램을 종료합니다");
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
	         System.out.println("   1. 학생");
	         System.out.println("   2. 교수");
	         System.out.println("   3. 관리자");
	         System.out.println("   4. 이전메뉴");
	         System.out.println("****************");
	         System.out.print("   번호 입력 : ");
	         num = scn.nextInt();
	         if(num == 4) break;
	         
	         System.out.println();
	         
	         String name, value=null;
	         
	         System.out.print("이름 입력 : ");
	         name = scn.next();
	         
	         if(num == 1) {
	            System.out.print("학번 입력 : ");
	            value = scn.next();
	         }else if(num == 2) {
	            System.out.print("과목 입력 : ");
	            value = scn.next();
	         }else if(num == 3) {
	            System.out.print("부서 입력 : ");
	            value = scn.next();
	         }
	         
	         //DB - insert
	         getConnection(); //접속
	         
	         String sql = "INSERT INTO STUDENT2 VALUES(?,?,?)";
	         try {
	            pstmt = conn.prepareStatement(sql); //생성
	            
	            //?에 데이터 대입
	            pstmt.setString(1, name);
	            pstmt.setString(2, value);
	            pstmt.setInt(3, num);
	            
	            int su = pstmt.executeUpdate();//실행
	            System.out.println(su + " 행이 삽입 되었습니다.");
	            
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
	         System.out.println("   1. 이름 검색 (1개 글자가 포함된 이름은 모두 검색)");
	         System.out.println("   2. 전체 검색");
	         System.out.println("   3. 이전메뉴");
	         System.out.println("****************");
	         System.out.print("   번호 입력 : ");
	         num = scn.nextInt();
	         if(num == 3) break;
	         
	         System.out.println();
	         
	         //데이터
	         String name=null;
	         if(num == 1) {
	        	 System.out.print("검색할 이름 입력(1글자 입력) : ");
	        	 name = scn.next();
	         }
	         
	         //DB - select
	         getConnection(); //접속
	         
	         String sql =null;
	         if(num == 1) {
	        	 sql = "select * from STUDENT2 where name like ?";
	         }
	         else
	        	 sql = "select * from STUDENT2";
	         try {
	            pstmt = conn.prepareStatement(sql); //생성
	            
	            if(num == 1) pstmt.setString(1, "%"+name+"%");
	        
	             rs = pstmt.executeQuery();//실행
	            while(rs.next()) {
	            	System.out.print("이름 = " +rs.getString("name")+"\t");
	            	
	            	if(rs.getInt("code") == 1)
	            		System.out.println("학번 = " +rs.getString("value"));
	            	else if(rs.getInt("code") == 2)
	            		System.out.println("과목 = " +rs.getString("value"));
	            	else if(rs.getInt("code") == 3)
	            		System.out.println("부서 = " +rs.getString("value"));
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
		System.out.print("삭제할 이름 입력 : ");
		String name = scn.next();
		
		getConnection(); //접속
		
		String sql = "DELETE FROM STUDENT2 WHERE NAME=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			int su = pstmt.executeUpdate();//실행 - 개수 리턴
			System.out.println(su+"행 이(가) 삭제 되었습니다.");
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
[문제]
Project  : student
Package : student.dao
Class    : Student.java

# 테이블 작성
create table student2(
name  varchar2(15)  not  null, -- 이름
value   varchar2(15), -- 학번 or 과목 or 부서
code   number   -- 1이면 학생, 2이면 교수, 3이면 관리자
);

menu()
****************
   관리
****************
  1. 입력
  2. 검색
  3. 삭제
  4. 종료
****************
  번호선택 : 4
프로그램 종료합니다


1번인 경우
insertArticle()
****************
   1. 학생
   2. 교수
   3. 관리자
   4. 이전메뉴
****************
   번호선택 : 

1번 학생인 경우
이름입력 : 
학번입력 : 

2번 교수인 경우
이름입력 : 
과목입력 : 

3번 관리자인 경우
이름입력 : 
부서입력 : 

2번인 경우
selectArticle()
****************
   1. 이름 검색 (1개 글자가 포함된 이름은 모두 검색)
   2. 전체 검색
   3. 이전메뉴
****************
   번호선택 : 1

1번 경우
검색할 이름 입력 : 이
이름=희동이	학번=2015
이름=이교수	과목=JAVA

3번인 경우
deleteArticle()
삭제를 원하는 이름 입력 : (정확하게 3개의 글자가 모두 입력된 상태)
*/
