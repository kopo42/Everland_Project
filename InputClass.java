package everland;

import java.io.IOException;
import java.util.Scanner;

public class InputClass {
	public static void main(String[] args) throws IOException {
		TypeClass t; //����, ������ �ݺ��� ������
		ProcessingClass pc;
		Scanner scan = new Scanner(System.in);
		SelectorClass s;
		
		do {
			pc = new ProcessingClass();
			t = new TypeClass();
			s = new SelectorClass();
			
			System.out.println("Ƽ�� �߱��� �����մϴ�");
			System.out.println("������ �����ϼ���: ");
			System.out.println("1. �ְ���\n2.�߰���\n3. ����");
			t.time = scan.nextInt();
			s.timeSelect(t);
			
			
			System.out.println("�ֹε�Ϲ�ȣ�� �Է��ϼ���: ");
			t.minbun = scan.next();
			
			System.out.println("�߱��Ͻ� Ƽ�� �ż��� �Է��ϼ���: ");
			t.amnt = scan.nextInt();
			
			System.out.println("�������� �����ϼ���(���ɿ� ���� ���� �ڵ� ó���˴ϴ�): ");
			System.out.println("1. ����"); 
			System.out.println("2. �����");
			System.out.println("3. ����������");
			System.out.println("4. ���ڳ�");
			System.out.println("5. �ӻ��");
			t.discnt = scan.nextInt();
			
		} while (t.time != Options.exit); //�ݺ� ����
	}
}
