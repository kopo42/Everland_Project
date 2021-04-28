import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Report {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File ("c:\\Users\\J\\Desktop\\source\\report.csv"); //경로 및 파일명 지정
		BufferedReader br = new BufferedReader (new FileReader(file)); //파일 읽기 객체 생성
		String str; //br.readLine으로 읽어들인 파일 내용을 저장할 변수
		ReportOptions ro = new ReportOptions();
		
		//0날짜	1권종	2연령구분	3발매수	 4결제금액 	5우대사항
		while((str = br.readLine()) != null) {
			String[] field = str.split(","); //필드 내용 (tab 기준)
			
			
		}
	}
