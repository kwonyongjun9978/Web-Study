package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.dao.BoardDAO;

public class BoardDeleteService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		
		//������
		String seq = request.getParameter("seq");
		
		//DB
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.boardDelete(seq);
		System.out.println("hi"  +seq);
		
		//����
		return "/board/boardDelete.jsp";
	}

}