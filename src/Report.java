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
		
		File file = new File ("c:\\Users\\J\\Desktop\\source\\report\\report.csv"); //경로 및 파일명 지정
		BufferedReader br = new BufferedReader (new FileReader(file)); //파일 읽기 객체 생성
		String str; //br.readLine으로 읽어들인 파일 내용을 저장할 변수
		
		ReportOptions ro;
		ReportType rt;
		ReportFileWrite rf;
		
		//0날짜	1권종	2연령구분	 3발매수	 4결제금액 	5우대사항
		//1 일자별 2권종별 3 우대별
		int i = 0;
			System.out.println("작업을 선택하세요");
			System.out.println("1.일자별 2.권종별 3.우대별");
			
			i = scan.nextInt();
			
			if(i == 1) {
				try {
				String filename = "c:\\Users\\J\\Desktop\\source\\report\\일자별.csv";
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
				String filename = "c:\\Users\\J\\Desktop\\source\\report\\권종별.csv";
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
				
				rt.printArr(dayArr); //확인용
				
				rf.arrWrite(dayArr);
				rf.fileClose();
				
			} else if (i == 3) {
				ro = new ReportOptions();
				rt = new ReportType();
				String filename = "c:\\Users\\J\\Desktop\\source\\report\\우대별.csv";
				rf = new ReportFileWrite(filename);
				
				String head = "우대사항 없음,"+"장애인,"+"국가유공자,"+ "다자녀," + "임산부," + "\n";
				rf.headerWrite(head);
				
				while((str = br.readLine()) != null) {
					String[] field = str.split(","); //필드 내용 (tab 기준)
					rt.TypeDiscnt(field, ro, rf);
				}
				
				String sum = ro.nonTotal + "," + ro.disabledTotal + "," + ro.veteranTotal + "," + ro.multichildTotal + "," + ro.pregTotal + "\n";
				rf.TailWrite(ro, sum);
				rf.fileClose();
			
		}
	}
}
