import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Report {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File ("c:\\Users\\J\\Desktop\\source\\report.csv"); //��� �� ���ϸ� ����
		BufferedReader br = new BufferedReader (new FileReader(file)); //���� �б� ��ü ����
		String str; //br.readLine���� �о���� ���� ������ ������ ����
		ReportOptions ro = new ReportOptions();
		
		//0��¥	1����	2���ɱ���	3�߸ż�	 4�����ݾ� 	5������
		while((str = br.readLine()) != null) {
			String[] field = str.split(","); //�ʵ� ���� (tab ����)
			
			
		}
	}
