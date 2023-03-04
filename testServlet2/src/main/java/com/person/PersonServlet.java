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
				//������(name �Ӽ��� �ҷ��´�, id �Ӽ� X)
				String name = request.getParameter("name"); 
				int gender = Integer.parseInt(request.getParameter("gender"));
				String color = request.getParameter("color");
				String[] hobby = request.getParameterValues("hobby");
				String[] subject = request.getParameterValues("subject");
				
				//����
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter(); //������ ������ ��� ��Ʈ�� ����
				out.println("<html>");
				out.println("<body style='background: yellow;'>");
				out.println("<h3>");
				out.println("<ul style='border: 1px solid red; background: "+color+"'>");
				
				out.println("<li>");
				out.println("�̸� : "+name);
				out.println("</li>");
				
				out.println("<li>");
				out.print("���� : ");
				if(gender == 0) out.println("����");
				else if(gender == 1) out.println("����");
				out.println("</li>");
				
				out.println("<li>");
				out.print("���� : ");
				out.println(color);
				out.println("</li>");
				
				out.println("<li>");
				out.print("��� : ");
				for(int i=0; i<hobby.length; i++) {
					out.println(hobby[i]);
				}
				out.println("</li>");
				
				out.println("<li>");
				out.print("���� : ");
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
