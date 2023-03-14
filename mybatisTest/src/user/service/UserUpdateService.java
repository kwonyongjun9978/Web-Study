package user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserUpdateService implements UserService {

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
		
		System.out.println();
		System.out.println("�̸�\t���̵�\t��й�ȣ");
		System.out.println(userDTO.getName()+"\t"+userDTO.getId()+"\t"+userDTO.getPwd());
		
		System.out.println();
		System.out.print("������ �̸� �Է� : ");
		String name = scan.next();
		System.out.print("������ ��й�ȣ �Է� : ");
		String pwd = scan.next();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("id", id);
		map.put("pwd", pwd);
		
		userDAO.update(map);
		
		System.out.println("�����͸� �����Ͽ����ϴ�.");
	}
}
