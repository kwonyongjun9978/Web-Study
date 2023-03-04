package com.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/HelloServlet") //web.xml에서 servlet을 설정해서 쓸 필요가 없다, 둘다쓰면 error
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	public void init() {
		System.out.println("init()");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter(); //생성
		out.println("<html>");
		out.println("<body>");
		out.println("안녕하세요!!");
		out.println("</body>");
		out.println("</html>");
	}
	
	public void destroy() {
		System.out.println("destroy()");
	}

}
