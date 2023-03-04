package guestbook.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.bean.GuestbookDTO;
import guestbook.dao.GuestbookDAO;

@WebServlet("/GuestbookListServlet")
public class GuestbookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//������ 
		int pg = Integer.parseInt(request.getParameter("pg")); 
		
		//����¡ ó�� - 1�������� 2����
		/*
		      startNum  endNum 
		 pg=1 rn>=1 and rn<=2
		 pg=2 rn>=3 and rn<=4
		 pg=3 rn>=5 and rn<=6
		 */
		
		int endNum = pg*2;
		int startNum = endNum-1;
		
		//DB
		GuestbookDAO guestbookDAO = GuestbookDAO.getInstance();
		ArrayList<GuestbookDTO> list = guestbookDAO.guestbookList(startNum, endNum);
		
		//�ѱۼ�
		int totalA = guestbookDAO.getTotalA();
		System.out.println(totalA);
		
		//�� ��������
		int totalP = (totalA+1)/2 ;
		
		/*
		 �ѱۼ� : 7
		 ���������� : 4
		 
		 �ѱۼ� : 8
		 ���������� : 4
		 */
		
		//����
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();//��Ʈ�� ����
		
		out.println("<html>");
		out.println("<style>");
		
		out.println("#currentpagingdiv {float: left; border: 1px red solid; width: 20px; height: 20px; margin-left: 5px; text-align: center;}");
		out.println("#pagingDiv {float: left; width: 20px; height: 20px; margin-left: 5px; text-align: center;}");
		
		out.println("#currentpaging {color: red; text-decoration: none;}");
		out.println("#paging {color: black; text-decoration: none;}");
		
		out.println("</style>");
		out.println("<body>");
		
		//������ ��ȣ
		for(int i=1; i<=totalP; i++) {
			if(i == pg)
				out.println("<div id='currentPagingDiv'><a id='currentPaging' href='/guestbookServlet/GuestbookListServlet?pg=" + i +"'>" + i + "</a></div>");
			else
				out.println("<div id='pagingDiv'><a id='paging' href='/guestbookServlet/GuestbookListServlet?pg=" + i +"'>" + i + "</a></div>");
		}
		out.println("<br><br>");
		
		if(list != null) {
			for(GuestbookDTO guestbookDTO : list) {
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
				out.println("<td colspan='4'><pre>" + guestbookDTO.getContent() + "</pre></td>");
				out.println("</tr>");
				
				out.println("<table>");
				out.println("<hr style='border-color: red; width: 650px; margin: 10px 0;'>");
			}//for
		}//if
		
		out.println("</body>");
		out.println("</html>");
	}

}
