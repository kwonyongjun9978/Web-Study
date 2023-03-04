package com.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/HelloServlet") //web.xml���� servlet�� �����ؼ� �� �ʿ䰡 ����, �Ѵپ��� error
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	public void init() {
		System.out.println("init()");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter(); //����
		out.println("<html>");
		out.println("<body>");
		out.println("�ȳ��ϼ���!!");
		out.println("</body>");
		out.println("</html>");
	}
	
	public void destroy() {
		System.out.println("destroy()");
	}

}
