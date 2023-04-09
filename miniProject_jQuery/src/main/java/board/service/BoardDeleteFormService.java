package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

public class BoardDeleteFormService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		
		//������
		String seq = request.getParameter("seq");
		
		//����
		request.setAttribute("seq", seq);
		request.setAttribute("display", "/board/boardDeleteForm.jsp");
		return "/index.jsp";
	}

}