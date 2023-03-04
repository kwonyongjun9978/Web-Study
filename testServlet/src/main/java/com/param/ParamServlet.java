package com.param;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public void init() {
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//������
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		//����
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter(); //������ ������ ��� ��Ʈ�� ����
		out.println("<html>");
		out.println("<body>");
		out.println("<h3>");
		out.println("���� �̸��� "+name+"�̰� ���̴� "+age+"���̹Ƿ�");
		if(age>=20) out.println("���� �Դϴ�");
		else out.println("û�ҳ� �Դϴ�");
		out.println("</h3>");
		out.println("</body>");
		out.println("</html>");		
	}
	
	public void destroy() {
		
	}

}
