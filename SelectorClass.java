package everland;

import java.util.Scanner;

public class SelectorClass {
	ProcessingClass pc = new ProcessingClass();
	Scanner scan = new Scanner(System.in);
	
	public void timeSelect(TypeClass t) {
		System.out.println("Ƽ�� �߱��� �����մϴ�");
		System.out.println("������ �����ϼ���: ");
		System.out.println("1. �ְ���\n2. �߰���");
		t.time = scan.nextInt();
		pc.getTime(t);
	}
	
	public void ageSelect(TypeClass t) {
		System.out.println("�ֹε�Ϲ�ȣ�� �Է��ϼ���: ");
		t.minbun = scan.next();
		pc.getAge(t);
	}
	
	public void amntInput(TypeClass t) {
		System.out.println("�߱��Ͻ� Ƽ�� �ż��� �Է��ϼ���: ");
		t.amnt = scan.nextInt();
	}
	
	public void discntSelect(TypeClass t) {
		System.out.println("�������� �����ϼ���(���ɿ� ���� ���� �ڵ� ó���˴ϴ�): ");
		System.out.println("1. ����"); 
		System.out.println("2. �����");
		System.out.println("3. ����������");
		System.out.println("4. ���ڳ�");
		System.out.println("5. �ӻ��");
		t.discnt = scan.nextInt();
		pc.getDiscnt(t);
	}
}

