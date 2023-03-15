package user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserSearchService implements UserService {

	@Override
	public void execute() {
		System.out.println();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("1.�̸� �˻�");
		System.out.println("2.���̵� �˻�");
		System.out.print("��ȣ �Է� : ");
		int num = scan.nextInt();
		
		System.out.println();
		String columnName = null;
		String value = null;
		if(num == 1) {
			System.out.print("�˻��� �̸� �Է� :");
			value = scan.next();
			columnName= "name";
		}else if(num == 2) {
			System.out.print("�˻��� ���̵� �Է� :");
			value = scan.next();
			columnName= "id";
		}
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("columnName", columnName);
		map.put("value", value);
		
		//DB
		UserDAO userDAO = UserDAO.getInstance();
		List<UserDTO> list = userDAO.search(map);
		
		System.out.println("�̸�\t���̵�\t��й�ȣ");
		for(UserDTO userDTO : list) {
			System.out.println(userDTO.getName()+"\t"+userDTO.getId()+"\t"+userDTO.getPwd());
		}//for
		
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
