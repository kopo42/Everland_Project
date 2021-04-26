package everland;

import java.util.Scanner;

public class SelectorClass {
	ProcessingClass pc = new ProcessingClass();
	Scanner scan = new Scanner(System.in);
	
	public void timeSelect(TypeClass t) {
		System.out.println("티켓 발권을 시작합니다");
		System.out.println("권종을 선택하세요: ");
		System.out.println("1. 주간권\n2. 야간권");
		t.time = scan.nextInt();
		pc.getTime(t);
	}
	
	public void ageSelect(TypeClass t) {
		System.out.println("주민등록번호를 입력하세요: ");
		t.minbun = scan.next();
		pc.getAge(t);
	}
	
	public void amntInput(TypeClass t) {
		System.out.println("발권하실 티켓 매수를 입력하세요: ");
		t.amnt = scan.nextInt();
	}
	
	public void discntSelect(TypeClass t) {
		System.out.println("우대사항을 선택하세요(연령에 따른 우대는 자동 처리됩니다): ");
		System.out.println("1. 없음"); 
		System.out.println("2. 장애인");
		System.out.println("3. 국가유공자");
		System.out.println("4. 다자녀");
		System.out.println("5. 임산부");
		t.discnt = scan.nextInt();
		pc.getDiscnt(t);
	}
}

