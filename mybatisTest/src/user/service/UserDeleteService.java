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
		
		System.out.print("���̵� �Է� : ");
		String id = scan.next();
		
		//DB
		UserDAO userDAO = UserDAO.getInstance();
		UserDTO userDTO = userDAO.getUser(id);
		
		if(userDTO == null) {
			System.out.println("�����ϴ� ���̵� �����ϴ�");
			return;
		}
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		userDAO.delete(map);
		
		System.out.println("�����͸� �����Ͽ����ϴ�.");

	}

}
