package user.service;

import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserInsertService implements UserService {

	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		System.out.println();
		
		//������
		System.out.print("�̸� �Է� : ");
		String name = scan.next();
		System.out.print("���̵� �Է� : ");
		String id = scan.next();
		System.out.print("��й�ȣ �Է� : ");
		String pwd = scan.next();
		
		UserDTO userDTO = new UserDTO();
		userDTO.setName(name);
		userDTO.setId(id);
		userDTO.setPwd(pwd);
		
		//DB
		UserDAO userDAO = new UserDAO();
		userDAO.write(userDTO);
		
		System.out.println("�����͸� �����Ͽ����ϴ�.");
	}

}
