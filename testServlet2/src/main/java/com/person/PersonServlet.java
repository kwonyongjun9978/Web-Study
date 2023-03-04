package com.person;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init() {
		
	}
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//데이터(name 속성을 불러온다, id 속성 X)
				String name = request.getParameter("name"); 
				int gender = Integer.parseInt(request.getParameter("gender"));
				String color = request.getParameter("color");
				String[] hobby = request.getParameterValues("hobby");
				String[] subject = request.getParameterValues("subject");
				
				//응답
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter(); //웹으로 가도록 출력 스트림 생성
				out.println("<html>");
				out.println("<body style='background: yellow;'>");
				out.println("<h3>");
				out.println("<ul style='border: 1px solid red; background: "+color+"'>");
				
				out.println("<li>");
				out.println("이름 : "+name);
				out.println("</li>");
				
				out.println("<li>");
				out.print("성별 : ");
				if(gender == 0) out.println("남자");
				else if(gender == 1) out.println("여자");
				out.println("</li>");
				
				out.println("<li>");
				out.print("색깔 : ");
				out.println(color);
				out.println("</li>");
				
				out.println("<li>");
				out.print("취미 : ");
				for(int i=0; i<hobby.length; i++) {
					out.println(hobby[i]);
				}
				out.println("</li>");
				
				out.println("<li>");
				out.print("과목 : ");
				for(int i=0; i<subject.length; i++) {
					out.println(subject[i]);
				}
				out.println("</li>");
				
				out.println("</ul>");
				out.println("</h3>");
				out.println("</body>");
				out.println("</html>");	
	}
	
	public void destroy() {
		
	}

}
