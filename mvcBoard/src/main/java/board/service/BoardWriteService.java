package board.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.dao.BoardDAO;

public class BoardWriteService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		
		//데이터
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		String name = "차무식";
		String id = "casino";
		String email = "casino@gmail.com";
			
		//map에 데이터 저장
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("name", name);
		map.put("email", email);
		map.put("subject", subject);
		map.put("content", content);
		
		//DB 연동
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.boardWrite(map);
		
		//응답
		return "/board/boardWrite.jsp";
	}

}
