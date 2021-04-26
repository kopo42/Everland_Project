package everland;

import java.io.IOException;
import java.util.Scanner;

public class InputClass {
	public static void main(String[] args) throws IOException {
		TypeClass t; //선언만, 생성은 반복문 내에서
		ProcessingClass pc;
		Scanner scan = new Scanner(System.in);
		SelectorClass s;
		
		do {
			pc = new ProcessingClass();
			t = new TypeClass();
			s = new SelectorClass();
			
			System.out.println("티켓 발권을 시작합니다");
			System.out.println("권종을 선택하세요: ");
			System.out.println("1. 주간권\n2.야간권\n3. 종료");
			t.time = scan.nextInt();
			s.timeSelect(t);
			
			
			System.out.println("주민등록번호를 입력하세요: ");
			t.minbun = scan.next();
			
			System.out.println("발권하실 티켓 매수를 입력하세요: ");
			t.amnt = scan.nextInt();
			
			System.out.println("우대사항을 선택하세요(연령에 따른 우대는 자동 처리됩니다): ");
			System.out.println("1. 없음"); 
			System.out.println("2. 장애인");
			System.out.println("3. 국가유공자");
			System.out.println("4. 다자녀");
			System.out.println("5. 임산부");
			t.discnt = scan.nextInt();
			
		} while (t.time != Options.exit); //반복 종료
	}
}
