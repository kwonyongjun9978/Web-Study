package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class GetBoardService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		//데이터
		int pg = Integer.parseInt(request.getParameter("pg"));
		int seq = Integer.parseInt(request.getParameter("seq"));
		//System.out.println(pg);
		
		//DB
		BoardDAO boardDAO = BoardDAO.getInstance();
		BoardDTO boardDTO = boardDAO.getBoard(seq);
		
		//JSON
		JSONObject json = new JSONObject();
		json.put("seq", boardDTO.getSeq());
		json.put("id", boardDTO.getId());
		json.put("subject", boardDTO.getSubject());
		json.put("content", boardDTO.getContent());
		json.put("hit", boardDTO.getHit());
		
		//응답
		request.setAttribute("json", json);
		return "/board/getBoard.jsp";
	}

}
