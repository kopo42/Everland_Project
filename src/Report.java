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
		
		File file = new File ("c:\\Users\\J\\Desktop\\source\\report\\report.csv");
		BufferedReader br = new BufferedReader (new FileReader(file));
		String str;
		
		ReportOptions ReOptions;
		ReportType ReType;
		ReportFileWrite ReFileWrite;
		
		//0��¥	1����	2���ɱ���	 3�߸ż�	 4�����ݾ� 	5������
		//1 ���ں� 2������ 3 ��뺰
		int i = 0;
			System.out.println("�۾��� �����ϼ���");
			System.out.println("1.���ں� 2.������ 3.��뺰");
			
			i = scan.nextInt();
			
			if(i == 1) {
				try {
					String filename = "c:\\Users\\J\\Desktop\\source\\report\\���ں�.csv";
					ReFileWrite = new ReportFileWrite(filename);
					ReOptions = new ReportOptions();
					ReType = new ReportType();
					String datestr = "";
					int datetotal = 0;
					ArrayList<String> priceList = new ArrayList<String>();
					ArrayList <String> dateArrList1 = new ArrayList <String>(); //get dates
					while((str = br.readLine()) != null) {
						String[] field = str.split(",");
						dateArrList1.add(field[0]);
						priceList.add(field[4]);
					}
					HashSet<String> dateList = new HashSet<String>(dateArrList1); //hashset of dateArrlist1
					ArrayList <String> dateArrList2 = new ArrayList <String>(dateList); //get dates through a hashset
					dateArrList2.sort(null); //sort (date, date, ..., txt)
					
					//System.out.println(dateArrList1); //check up
					//System.out.println(dateArrList2);//check up
					
					String[][]dateArr = new String[dateArrList2.size()][2]; //size of only dates
					dateArr[0][0] = "����"; dateArr[0][1] = "�Ѹ���"; //headers
					
					for (int k = 0; k < dateArrList2.size()-1; k ++) { //dateArrList2 = (date, date, ..., txt)
						for(int j = 1; j < dateArrList1.size(); j ++) {
							if(dateArrList1.get(j).equals(dateArrList2.get(k))) { //String list elements => equals
								dateArr[k+1][0] = dateArrList2.get(k);
								datetotal += Integer.parseInt(priceList.get(j));
							}
						}dateArr[k+1][1] = Integer.toString(datetotal);
					}
					
					ReType.printArr(dateArr); //check up
					
					ReFileWrite.arrWrite(dateArr);
					ReFileWrite.fileClose();
					} catch(NoSuchElementException e) {
						e.printStackTrace();
					} catch(NumberFormatException e) {
						e.printStackTrace();
					}
			} else if (i == 2) {
				String filename = "c:\\Users\\J\\Desktop\\source\\report\\������.csv";
				String[][] dayArr = new String[8][3];
				ReFileWrite = new ReportFileWrite(filename);
				ReOptions = new ReportOptions();
				ReType = new ReportType();
				
				while((str = br.readLine()) != null) {
					String[] field = str.split(",");
					ReType.TypeDay(dayArr, field, ReOptions, ReFileWrite);
				}
				
				dayArr[dayArr.length-2][1] = Integer.toString(ReOptions.daysum); 
				dayArr[dayArr.length-2][2] = Integer.toString(ReOptions.nightsum);
				
				dayArr[dayArr.length-1][1] = Integer.toString(ReOptions.dayTotal);
				dayArr[dayArr.length-1][2] = Integer.toString(ReOptions.nightTotal);
				
				ReType.printArr(dayArr); //Ȯ�ο�
				
				ReFileWrite.arrWrite(dayArr);
				ReFileWrite.fileClose();
				
			} else if (i == 3) {
				String filename = "c:\\Users\\J\\Desktop\\source\\report\\��뺰.csv";
				ReFileWrite = new ReportFileWrite(filename);
				ReOptions = new ReportOptions();
				ReType = new ReportType();
				
				String[][] discArr = new String [3][7];
				
				discArr[0][0]="����"; discArr[0][1]="������ ����"; discArr[0][2]="�����";discArr[0][3]="����������";
				discArr[0][4]="���ڳ�";discArr[0][5]="�ӻ��";discArr[0][6]="�հ�";
				discArr[1][0] = "����"; discArr[2][0] = "����";
				
				while((str = br.readLine()) != null) {
					String[] field = str.split(","); //�ʵ� ���� (tab ����)
					ReType.TypeDiscnt(field, ReOptions, ReFileWrite);
					discArr[1][1]=Integer.toString(ReOptions.noncnt); discArr[2][1]=Integer.toString(ReOptions.nonTotal);
					discArr[1][2]=Integer.toString(ReOptions.disabledcnt); discArr[2][2]=Integer.toString(ReOptions.disabledTotal);
					discArr[1][3]=Integer.toString(ReOptions.veterancnt); discArr[2][3]=Integer.toString(ReOptions.veteranTotal);
					discArr[1][4]=Integer.toString(ReOptions.multichildcnt); discArr[2][4]=Integer.toString(ReOptions.multichildTotal);
					discArr[1][5]=Integer.toString(ReOptions.pregcnt); discArr[2][5]=Integer.toString(ReOptions.pregTotal);
				} //more intelligent way required...
				int cntsum = ReOptions.noncnt + ReOptions.disabledcnt + ReOptions.veterancnt + ReOptions.multichildcnt + ReOptions.pregcnt;
				int totalsum = ReOptions.nonTotal + ReOptions.disabledTotal + ReOptions.veteranTotal + ReOptions.multichildTotal + ReOptions.pregTotal;
				discArr[1][6] = Integer.toString(cntsum);
				discArr[2][6] = Integer.toString(totalsum);
				
				ReType.printArr(discArr);
				ReFileWrite.arrWrite(discArr);
				ReFileWrite.fileClose();
		}
	}
}
