package everland;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class InputClass {
	public static void main(String[] args) throws IOException {
		TypeClass t; //����, ������ �ݺ��� ������
		Scanner scan = new Scanner(System.in);
		SelectorClass s;
		CalClass cal = new CalClass();
		FileWriteClass f = new FileWriteClass();
		ArrayList <String> subinfoList = new ArrayList<String>();
		String subinfo = "";
		int ctn1;
		
		f.headerWrite();

		do {
			System.out.println("�߱��� �����մϴ�");
			System.out.println("1. ����\n2. ����");
			ctn1 = scan.nextInt();
			
			t = new TypeClass();
			s = new SelectorClass();

			s.timeSelect(t);
			s.ageSelect(t);
			s.amntInput(t);
			s.discntSelect(t);
			
			subinfo = t.timestr + " " + t.agestr + " X " + t.amnt + " " + t.discntstr;
			subinfoList.add(subinfo);
			cal.CalSubtotal(t);
			
			t.total += t.subtotal;
			
			System.out.println("�߰��� �߱��Ͻðڽ��ϱ�?: ");
			System.out.println("1. �߰� \n2. ����");
			int ctn2 = scan.nextInt();
			if(ctn2 == 1) {
				continue;
			} else {
				System.out.println("Ƽ�� �߱��� �����մϴ�.");
				System.out.println("====EVERLAND RESORT====");
				
				for(int i = 0; i < subinfoList.size(); i++) {
					System.out.println(subinfoList.get(i));
				}
				System.out.printf("�����Ͻ� �ݾ�: %d��\n", t.total);
			}
			f.dataWrite(t);
		} while (ctn1 != 2); //�ݺ� ����
		f.fileClose();
	}
}
