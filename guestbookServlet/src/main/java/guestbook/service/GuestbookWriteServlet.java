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

@WebServlet("/GuestbookWriteServlet")
public class GuestbookWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//������
		request.setCharacterEncoding("UTF-8"); //post�� ���
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String homepage = request.getParameter("homepage");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		GuestbookDTO guestbookDTO = new GuestbookDTO();
		guestbookDTO.setName(name);
		guestbookDTO.setEmail(email);
		guestbookDTO.setHomepage(homepage);
		guestbookDTO.setSubject(subject);
		guestbookDTO.setContent(content);
		
		//DB ����(+ .jar���� lib������ ����)
		GuestbookDAO guestbookDAO = GuestbookDAO.getInstance();
		guestbookDAO.guestbookWrite(guestbookDTO);
		
		//����
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();//��Ʈ�� ����
		out.println("<html>");
		out.println("<body>");
		out.println("<h3>�ۼ��Ͻ� ���� �����Ͽ����ϴ�.<h3>");
		out.println("<button type='button' onclick=\"location.href='guestbookServlet/GuestbookListServlet'\">�۸��</button>");
		out.println("</body>");
	    out.println("</html>");
}
}
