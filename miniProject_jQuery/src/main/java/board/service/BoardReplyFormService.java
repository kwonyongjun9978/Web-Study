package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

public class BoardReplyFormService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		//������
		String seq = request.getParameter("seq"); //���۹�ȣ
		String pg = request.getParameter("pg"); //������ �ִ� ������ ��ȣ
		
		request.setAttribute("seq", seq);
		request.setAttribute("pg", pg);
		
		request.setAttribute("display", "/board/boardReplyForm.jsp");
		return "/index.jsp";
	}

}
