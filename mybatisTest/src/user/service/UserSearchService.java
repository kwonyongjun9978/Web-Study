package user.service;

import java.util.List;
import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserSearchService implements UserService {

	@Override
	public void execute() {
		System.out.println();
		Scanner scan = new Scanner(System.in);
		int num;
		
		System.out.println("1.�̸� �˻�");
		System.out.println("2.���̵� �Է�");
		System.out.print("��ȣ �Է� : ");
		num = scan.nextInt();
		//DB
		UserDAO userDAO = UserDAO.getInstance();
		if(num == 1) {
			System.out.print("�˻��� �̸� �Է� :");
			String name = scan.next();
			
			List<UserDTO> list = userDAO.getUserName(name);
			
			if(list == null) {
				System.out.println("�����ϴ� �̸��� �����ϴ�");
			}else {
			System.out.println();
			System.out.println("�̸�\t���̵�\t��й�ȣ");
			for(UserDTO userDTO : list) {
				System.out.println(userDTO.getName()+"\t"+userDTO.getId()+"\t"+userDTO.getPwd());
				}
			}
		}else if(num == 2) {
			System.out.println("�˻��� ���̵� �Է� :");
			String id = scan.next();
			
			UserDTO userDTO = userDAO.getUserId(id);
			if(userDTO == null) {
			System.out.println("�����ϴ� ���̵� �����ϴ�.");
			}else {
				System.out.println(userDTO.getName()+"\t"+userDTO.getId()+"\t"+userDTO.getPwd());
			}
		}
		
		

	}

}
/*
      1. �̸� �˻�
      2. ���̵� �˻�
      ��ȣ �Է� : 1
      
      1���� ���
      ã���� �ϴ� �̸� �Է� : ȫ
      
      �̸�      ���̵�      ��й�ȣ
      ȫ�浿
      ȫ�繫
      
      1���� ���
      ã���� �ϴ� ���̵� �Է� : n
      
      �̸�      ���̵�      ��й�ȣ
            hong
            conan
            
      
      �̸����� �˻��ϰ� �Ǵ� ���̵�� �˻��ϰ� ������ userDAO.search(~~) �� ȣ���Ѵ�.
            
   }
 */
