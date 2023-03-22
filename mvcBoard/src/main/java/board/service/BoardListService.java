package board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.bean.BoardPaging;
import board.dao.BoardDAO;

public class BoardListService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		//데이터
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		String id = request.getParameter("id");
		
		//DB
		BoardDAO boardDAO = BoardDAO.getInstance();
	
		
		int endNum = pg*5;
		int startNum = endNum-4;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		List<BoardDTO> list = boardDAO.boardList(map);
		
		//페이징 처리
		int totalA = boardDAO.getTotalA(); //총 글수
		
		BoardPaging boardPaging = new BoardPaging(); 
		boardPaging.setCurrentPage(pg);
		boardPaging.setPageBlock(3);
		boardPaging.setPageSize(5);
		boardPaging.setTotalA(totalA);
		
		boardPaging.makePagingHTML();
		
		request.setAttribute("boardPaging", boardPaging);
		request.setAttribute("list", list);

		return "/board/boardList.jsp";
	}

}
