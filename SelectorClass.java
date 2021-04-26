package everland;

import java.util.Scanner;

public class SelectorClass {
	ProcessingClass pc = new ProcessingClass();
	Scanner scan = new Scanner(System.in);
	
	public void timeSelect(TypeClass t) {
		System.out.println("티켓 발권을 시작합니다");
		System.out.println("권종을 선택하세요: ");
		System.out.println("1. 주간권  2. 야간권");
		t.time = scan.nextInt();
		pc.getTime(t);
	}
	
	public void ageSelect(TypeClass t) {
		System.out.println("생년월일 8자리를 입력하세요: ");
		t.minbun = scan.next();
		pc.getAge(t);
	}
	
	public void amntInput(TypeClass t) {
		System.out.println("발권하실 티켓 매수를 입력하세요: ");
		t.amnt = scan.nextInt();
	}
	
	public int discntSelect(TypeClass t) {
		System.out.println("우대사항을 선택하세요(연령에 따른 우대는 자동 처리됩니다): ");
		System.out.println("1. 없음  2. 장애인  3. 국가유공자  4. 다자녀  5. 임산부"); 
		t.discnt = scan.nextInt();
		t.subtotal = pc.getDiscnt(t);
		return t.subtotal;
	}
}

