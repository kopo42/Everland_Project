package everland;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class InputClass {
	public static void main(String[] args) throws IOException {
		TypeClass t; //선언만, 생성은 반복문 내에서
		Scanner scan = new Scanner(System.in);
		SelectorClass s;
		FileWriteClass f = new FileWriteClass();
		ArrayList <String> subinfoList = new ArrayList<String>();
		ArrayList <Integer> totalList = new ArrayList<Integer>();
		String subinfo = "";
		int ctn1;
		//파일 헤더 쓰기
		f.headerWrite();

		while(true){
			System.out.println("발권을 시작합니다");
			System.out.println("1. 시작\n2. 종료");
			ctn1 = scan.nextInt();
			if(ctn1 == 1) {
				t = new TypeClass();
				s = new SelectorClass();
	
				s.timeSelect(t);
				s.ageSelect(t);
				s.amntInput(t);
				t.subtotal = s.discntSelect(t);
				
				subinfo = t.timestr + " " + t.agestr + " X " + t.amnt + " " + t.subtotal+ "원" + " " + t.discntstr;
				subinfoList.add(subinfo);
				
				totalList.add(t.subtotal);
				for(int i = 0; i < totalList.size(); i++) {
					t.total += totalList.get(i);
				}
				
				//파일 내용 쓰기
				f.dataWrite(t);
				
				System.out.println("추가로 발권하시겠습니까?: ");
				System.out.println("1. 추가 \n2. 종료");
				int ctn2 = scan.nextInt();
				
				if(ctn2 == 1) {
					continue;
				} else {
					System.out.println("티켓 발권을 종료합니다.");
					System.out.println("****EVERLAND RESORT****");
					
					for(int i = 0; i < subinfoList.size(); i++) {
						System.out.println(subinfoList.get(i));
					}
					System.out.printf("결제하실 금액: %d원\n", t.total);
					System.out.println("=======================");
				}
			}else if(ctn1 == 2) {
				//파일 쓰기 닫기
				f.fileClose();
				break;
			}
		} 
	}
}
