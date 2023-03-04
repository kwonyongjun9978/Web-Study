package guestbook.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.bean.GuestbookDTO;
import guestbook.dao.GuestbookDAO;

@WebServlet("/GuestbookSearchServlet")
public class GuestbookSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//������
		String seq = request.getParameter("seq"); 

		//DB
		GuestbookDAO guestbookDAO = GuestbookDAO.getInstance();
		GuestbookDTO guestbookDTO = guestbookDAO.guestbookSearch(seq);
		
		//����
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();//��Ʈ�� ����
		
		//������ out ��ü�� ��(������)�� ������
		//�׷� �������� ������ �ؼ� ȭ�鿡 ����� �����ش�.
		
		out.println("<html>");
		out.println("<body>");
		if(guestbookDTO != null) {
			out.println("<table border='1' cellpadding='5' cellspacing='0'>");
			out.println("<tr>");
			out.println("<td width='150'>�ۼ���</td>");
			out.println("<td width='150'>" + guestbookDTO.getName() + "</td>");
			out.println("<td width='150'>�ۼ���</td>");
			out.println("<td width='150'>" + guestbookDTO.getLogtime() + "</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>�̸���</td>");
			out.println("<td colspan='3'>" + guestbookDTO.getEmail() + "</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>Ȩ������</td>");
			out.println("<td colspan='3'>" + guestbookDTO.getHomepage() + "</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>����</td>");
			out.println("<td colspan='3'>" + guestbookDTO.getSubject() + "</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td colspan='4' height='150'><pre>" + guestbookDTO.getContent() + "</pre></td>");
			out.println("</tr>");
			out.println("<table>");
		}else {
			out.println("<h3>�۹�ȣ�� �����ϴ�</h3>");
		}
		out.println("</body>");
	    out.println("</html>");
	}
}
