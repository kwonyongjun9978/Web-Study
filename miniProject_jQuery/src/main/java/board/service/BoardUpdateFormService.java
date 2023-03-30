package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

public class BoardUpdateFormService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		//ตฅภฬลอ
		int pg = Integer.parseInt(request.getParameter("pg"));
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		request.setAttribute("pg", pg);
		request.setAttribute("seq", seq);
		request.setAttribute("display", "/board/boardUpdateForm.jsp");
		return "/index.jsp";
	}

}
