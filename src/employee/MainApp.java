package employee;

import java.util.Scanner;

import employee.dao.EmployeeDao;

public class MainApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String name;
		int low,high;
		
		int select;
		
		System.out.println("1.이름검색 2.연봉검색");
		
		select = scan.nextInt();
		if(select == 1)
		{
		
		System.out.println("검색 할 이름을 넣으세요.");
		name = scan.nextLine();
		name = scan.nextLine();
		
		new EmployeeDao().select(name);
				
		}
		else if(select==2)
		{
		 System.out.println("최소 연봉과 최대 연봉을 입력하세요.");
		 low = scan.nextInt();
		 high = scan.nextInt();
		 new EmployeeDao().select(low,high);
		}
		
		scan.close();
	}

}
