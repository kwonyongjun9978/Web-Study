package com.calc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//������
		int X = Integer.parseInt(request.getParameter("X"));
		int Y = Integer.parseInt(request.getParameter("Y"));
		
		//����
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();  
		out.println("<html>");
		out.println("<body>");
		out.println("<h3>");
		out.println(X+" + "+Y+" = "+(X+Y)+"<br>");
		out.println(X+" - "+Y+" = "+(X-Y)+"<br>");
		out.println(X+" * "+Y+" = "+(X*Y)+"<br>");
		out.println(X+" / "+Y+" = "+((double)X/Y)+"<br>");
		out.println("</h3>");
		out.println("<input type = 'button' value = '�ڷ�' onclick = 'javascript:history.go(-1)'>");
		out.println("<input type = 'button' value = '�ڷ�' onclick = location.href='http://localhost:8080/testServlet/calc/input.html'>");
		out.println("<input type = 'button' value = '��������' onclick = location.href='http://localhost:8080/testServlet/param.html'>");
		out.println("</body>");
		out.println("</html>");		
		}
			
		public void destroy() {
				
		}
}


