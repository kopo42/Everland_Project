import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Report {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		File file = new File ("c:\\Users\\J\\Desktop\\source\\report\\report.csv"); //��� �� ���ϸ� ����
		BufferedReader br = new BufferedReader (new FileReader(file)); //���� �б� ��ü ����
		String str; //br.readLine���� �о���� ���� ������ ������ ����
		
		ReportOptions ro;
		ReportType rt;
		ReportFileWrite rf;
		
		//0��¥	1����	2���ɱ���	 3�߸ż�	 4�����ݾ� 	5������
		//1 ���ں� 2������ 3 ��뺰
		int i = 0;
			System.out.println("�۾��� �����ϼ���");
			System.out.println("1.���ں� 2.������ 3.��뺰");
			
			i = scan.nextInt();
			
			if(i == 1) {
				try {
				String filename = "c:\\Users\\J\\Desktop\\source\\report\\���ں�.csv";
				rf = new ReportFileWrite(filename);
				ro = new ReportOptions();
				rt = new ReportType();
				String datestr = "";
				ArrayList <String> dateArrList1 = new ArrayList <String>();
				
				while((str = br.readLine()) != null) {
					String[] field = str.split(",");
					dateArrList1.add(field[0]);
					System.out.println(dateArrList1);
					datestr = rt.TypeDate(dateArrList1, field, ro, rf);
				}
				
				System.out.println(datestr);	
				
				} catch(NoSuchElementException e) {
					e.printStackTrace();
				} catch(NumberFormatException e) {
					e.printStackTrace();
				}
				
				
			} else if (i == 2) {
				String filename = "c:\\Users\\J\\Desktop\\source\\report\\������.csv";
				String[][] dayArr = new String[8][3];
				rf = new ReportFileWrite(filename);
				ro = new ReportOptions();
				rt = new ReportType();
				
				while((str = br.readLine()) != null) {
					
					String[] field = str.split(",");
					rt.TypeDay(dayArr, field, ro, rf);
				}
				
				dayArr[dayArr.length-2][1] = Integer.toString(ro.daysum); 
				dayArr[dayArr.length-2][2] = Integer.toString(ro.nightsum);
				
				dayArr[dayArr.length-1][1] = Integer.toString(ro.dayTotal);
				dayArr[dayArr.length-1][2] = Integer.toString(ro.nightTotal);
				
				rt.printArr(dayArr); //Ȯ�ο�
				
				rf.arrWrite(dayArr);
				rf.fileClose();
				
			} else if (i == 3) {
				ro = new ReportOptions();
				rt = new ReportType();
				String filename = "c:\\Users\\J\\Desktop\\source\\report\\��뺰.csv";
				rf = new ReportFileWrite(filename);
				
				String head = "������ ����,"+"�����,"+"����������,"+ "���ڳ�," + "�ӻ��," + "\n";
				rf.headerWrite(head);
				
				while((str = br.readLine()) != null) {
					String[] field = str.split(","); //�ʵ� ���� (tab ����)
					rt.TypeDiscnt(field, ro, rf);
				}
				
				String sum = ro.nonTotal + "," + ro.disabledTotal + "," + ro.veteranTotal + "," + ro.multichildTotal + "," + ro.pregTotal + "\n";
				rf.TailWrite(ro, sum);
				rf.fileClose();
			
		}
	}
}
