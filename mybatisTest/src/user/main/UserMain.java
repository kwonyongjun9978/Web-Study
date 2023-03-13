package user.main;

import java.util.Scanner;

import user.service.UserDeleteService;
import user.service.UserInsertService;
import user.service.UserSearchService;
import user.service.UserSelectService;
import user.service.UserService;
import user.service.UserUpdateService;

public class UserMain {

	public void menu() {
		Scanner scan = new Scanner(System.in);
		UserService userService = null;
		int num;
		
		while(true) {
			System.out.println();
			System.out.println("************");
			System.out.println("    1. �Է�");
			System.out.println("    2. ���");
			System.out.println("    3. ����");
			System.out.println("    4. ����");
			System.out.println("    5. �˻�");
			System.out.println("    6. ����");
			System.out.println("************");
			System.out.print("��ȣ �Է� : ");
			num = scan.nextInt();
			if(num == 6) {
				System.out.print("���α׷��� �����մϴ�");
				break;
			}
			if(num == 1) {
				userService = new UserInsertService(); //�θ� = �ڽ�, ������
			}else if(num == 2) {
				userService = new UserSelectService(); 
			}else if(num == 3) {
				userService = new UserUpdateService(); 
			}else if(num == 4) {
				userService = new UserDeleteService();
			}else if(num == 5) {
				userService = new UserSearchService();
			}
			
			userService.execute(); //ȣ��
		}//while
	}
	
	public static void main(String[] args) {
		UserMain userMain = new UserMain();
		userMain.menu();
	}

}
