

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class InputClass {
	public static void main(String[] args) throws IOException {
		TypeClass t; //����, ������ �ݺ��� ������
		Scanner scan = new Scanner(System.in);
		SelectorClass select; //select = ���ǿ� ���� ������ ���۵� ����
		FileWriteClass fileWrite = new FileWriteClass();
		ArrayList <String> subinfoList = new ArrayList<String>(); //�ֿܼ� ����� �������� ������ ����Ʈ
		ArrayList <Integer> totalList = new ArrayList<Integer>();
		int ctn1;
		fileWrite.headerWrite(); //���� ��� ����
		
		while(true){
			System.out.println("�߱��� �����մϴ�");
			System.out.println("1. ����  2. ����");
			ctn1 = scan.nextInt();
			if(ctn1 == 1) {
				t = new TypeClass();
				select = new SelectorClass();
	
				select.timeSelect(t); //����
				select.ageSelect(t); //����
				select.amntInput(t); //����
				t.subtotal = select.discntSelect(t);
				
				String subinfo = t.timestr + " " + t.agestr + " X " + t.amnt + " " + t.subtotal+ "��" + " " + t.discntstr;
				subinfoList.add(subinfo);
				
				totalList.add(t.subtotal); //subtotal = �Ұ�
				
				for(int i = 0; i < totalList.size(); i++) {
					t.total += totalList.get(i);
				}
				
				fileWrite.dataWrite(t); //���� ���� ����
				
				System.out.println("�߰��� �߱��Ͻðڽ��ϱ�?: ");
				System.out.println("1. �߰�  2. ����");
				int ctn2 = scan.nextInt(); //�߰�, ���� ���θ� ���� ����
				
				if(ctn2 == 1) {
					continue;
				} else {
					System.out.println("Ƽ�� �߱��� �����մϴ�.");
					System.out.println("****EVERLAND RESORT****");
					
					for(int i = 0; i < subinfoList.size(); i++) {
						System.out.println(subinfoList.get(i));
					}
					System.out.printf("�����Ͻ� �ݾ�: %d��\n", t.total);
					System.out.println("=======================");
				}
			}else if(ctn1 == 2) { //����ڰ� ���� ���� ��
				fileWrite.fileClose();//���� ���� �ݱ�
				break;
			}
		} 
	}
}
