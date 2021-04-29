

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class InputClass {
	public static void main(String[] args) throws IOException {
		TypeClass t; //선언만, 생성은 반복문 내에서
		Scanner scan = new Scanner(System.in);
		SelectorClass select; //select = 조건에 따라 실행할 동작들 저장
		FileWriteClass fileWrite = new FileWriteClass();
		ArrayList <String> subinfoList = new ArrayList<String>(); //콘솔에 출력할 정보들을 저장할 리스트
		ArrayList <Integer> totalList = new ArrayList<Integer>();
		int ctn1;
		fileWrite.headerWrite(); //파일 헤더 쓰기
		
		while(true){
			System.out.println("발권을 시작합니다");
			System.out.println("1. 시작  2. 종료");
			ctn1 = scan.nextInt();
			if(ctn1 == 1) {
				t = new TypeClass();
				select = new SelectorClass();
	
				select.timeSelect(t); //권종
				select.ageSelect(t); //연령
				select.amntInput(t); //수량
				t.subtotal = select.discntSelect(t);
				
				String subinfo = t.timestr + " " + t.agestr + " X " + t.amnt + " " + t.subtotal+ "원" + " " + t.discntstr;
				subinfoList.add(subinfo);
				
				totalList.add(t.subtotal); //subtotal = 소계
				
				for(int i = 0; i < totalList.size(); i++) {
					t.total += totalList.get(i);
				}
				
				fileWrite.dataWrite(t); //파일 내용 쓰기
				
				System.out.println("추가로 발권하시겠습니까?: ");
				System.out.println("1. 추가  2. 종료");
				int ctn2 = scan.nextInt(); //추가, 종료 여부를 받을 변수
				
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
			}else if(ctn1 == 2) { //사용자가 종료 선택 시
				fileWrite.fileClose();//파일 쓰기 닫기
				break;
			}
		} 
	}
}
