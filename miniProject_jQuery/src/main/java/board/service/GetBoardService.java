package board.service;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class GetBoardService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		//������
		int seq = Integer.parseInt(request.getParameter("seq"));
		//System.out.println(pg);
		
		//DB
		BoardDAO boardDAO = BoardDAO.getInstance();
		BoardDTO boardDTO = boardDAO.getBoard(seq);
		
		//BoardDTO -> JSON
		JSONObject json = new JSONObject();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		
		json.put("seq", boardDTO.getSeq());
		json.put("id", boardDTO.getId());
		json.put("name", boardDTO.getName());
		json.put("email", boardDTO.getEmail());
		json.put("subject", boardDTO.getSubject());
		json.put("content", boardDTO.getContent());
		json.put("ref", boardDTO.getRef());
		json.put("lev", boardDTO.getLev());
		json.put("step", boardDTO.getStep());
		json.put("pseq", boardDTO.getPseq());
		json.put("reply", boardDTO.getReply());
		json.put("hit", boardDTO.getHit());
		json.put("logtime", sdf.format(boardDTO.getLogtime())); //Data Ÿ���� -> StringŸ������ ��ȯ���Ѿ��Ѵ�.

		//����
		HttpSession session = request.getSession();
		String memId = (String)session.getAttribute("memId");
		
		//����
		request.setAttribute("json", json);
		request.setAttribute("memId", memId);
		return "/board/getBoard.jsp";
	}

}
