package user.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserDeleteService implements UserService {

	@Override
	public void execute() {
		System.out.println();
		Scanner scan = new Scanner(System.in);
		
		System.out.print("아이디 입력 : ");
		String id = scan.next();
		
		//DB
		UserDAO userDAO = UserDAO.getInstance();
		UserDTO userDTO = userDAO.getUser(id);
		
		if(userDTO == null) {
			System.out.println("존재하는 아이디가 없습니다");
			return;
		}
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		userDAO.delete(map);
		
		System.out.println("데이터를 삭제하였습니다.");

	}

}
