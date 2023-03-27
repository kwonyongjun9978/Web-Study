package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import member.dao.MemberDAO;

public class CheckIdService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		//데이터
		String id = request.getParameter("id");
		//DB
		MemberDAO memberDAO = MemberDAO.getInstance();
		boolean existId = memberDAO.isExistID(id); //아이디가 있다 -> true, 사용 불가능
		
		//응답
		request.setAttribute("id", id);
		if(existId) {
			return "/member/checkIdFail.jsp";
		}else {
			return "/member/checkIdOK.jsp";
		}
		
	}

}
