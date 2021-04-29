import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ReportType {
	//ReportOptions ro = new ReportOptions();
	
	public String TypeDate(ArrayList dateArrList1, String[] field, ReportOptions ro, ReportFileWrite rf) throws IOException {
		HashSet<String> dateList = new HashSet<String>(dateArrList1);
		String[][]dateArr = new String[dateList.size()][2];
		ArrayList <String> dateArrList2 = new ArrayList <String>(dateList);
		dateArrList2.sort(null);
		//1 [��¥, 2021-04-26, 2021-04-26, 2021-04-26, 2021-04-26, 2021-04-26, 2021-04-26, 2021-04-26, 2021-04-26, 2021-04-28, 2021-04-28, 2021-04-28, 2021-04-28]
		//2 [2021-04-26, 2021-04-28, ��¥]
		
		String datestr = "";
		int datetotal = 0;
		try {
			for (int i = 0; i < dateArrList2.size()-1; i ++) {
				for(int j = 1; j < dateArrList1.size(); j ++) {
					while(dateArrList1.get(j) != dateArrList2.get(i)) {
						datetotal += Integer.parseInt(field[4]);
					}
				}
			dateArr[i][1] = Integer.toString(datetotal);
			System.out.println(dateArr[i][1]);
			}
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		} catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
		
		return datestr;
	}
	
	public void TypeDay (String[][] dayArr, String[] field, ReportOptions ro, ReportFileWrite rf) throws IOException {
		//if(ro.isFileExist == false) { //�ʿ��Ѱ�??
		dayArr[0][0] = "����"; dayArr[0][1] = "�ְ���"; dayArr[0][2] = "�߰���"; //header
		String[] ages = {".", "����", "û�ҳ�", "���", "���", "36���� �̸� �����̿�", "�հ�", "����"};
		int daycnt = 0;
		int nightcnt = 0;
		int i = 1;
		while (i < dayArr.length) {
			dayArr[i][0] = ages[i]; //���� ����
			i++;
		}
		if (field[1].equals("�ְ�")) {
			ro.dayTotal += Integer.parseInt(field[4]);
			daycnt += Integer.parseInt(field[3]);
			TypeAge(field, ro, dayArr, 1);

			ro.daysum += daycnt;
		} else if (field[1].equals("�߰�")) {
			ro.nightTotal += Integer.parseInt(field[4]);
			nightcnt += Integer.parseInt(field[3]);
			TypeAge(field, ro, dayArr, 2);
				
			ro.nightsum += nightcnt;
		}
	}

	
	public void TypeDiscnt(String[] field, ReportOptions ro, ReportFileWrite rf) throws IOException {
		String filename = "c:\\Users\\J\\Desktop\\source\\��뺰.csv";
		rf = new ReportFileWrite(filename);
		
		String head = "����,"+"�ְ���,"+"�߰���"+"\n";
		rf.headerWrite(head);
		
		switch(field[5]) {
		case "������ ����":
			ro.discntType = "������ ����";
			ro.noncnt += Integer.parseInt(field[3]);
			ro.discntSubtotal = Integer.parseInt(field[4]);
			ro.nonTotal += Integer.parseInt(field[4]);
			break;
		case "�����":
			ro.discntType = "�����";
			ro.disabledcnt += Integer.parseInt(field[3]);
			ro.discntSubtotal = Integer.parseInt(field[4]);
			ro.disabledTotal += Integer.parseInt(field[4]);
			break;
		case "����������":
			ro.discntType = "����������";
			ro.veterancnt += Integer.parseInt(field[3]);
			ro.discntSubtotal = Integer.parseInt(field[4]);
			ro.veteranTotal += Integer.parseInt(field[4]);
			break;
		case "���ڳ�":
			ro.discntType = "���ڳ�";
			ro.multichildcnt += Integer.parseInt(field[3]);
			ro.discntSubtotal = Integer.parseInt(field[4]);
			ro.multichildTotal += Integer.parseInt(field[4]);
			break;
		case "�ӻ��":
			ro.discntType = "�ӻ��";
			ro.pregcnt += Integer.parseInt(field[3]);
			ro.discntSubtotal = Integer.parseInt(field[4]);
			ro.pregTotal += Integer.parseInt(field[4]);
			break;
		}
		String result = ro.noncnt + "," + ro.disabledcnt + "," + ro.veterancnt + "," + ro.multichildcnt + "," + ro.pregcnt + "\n";
		rf.dataWrite(ro, result);
	}
	
	public void TypeAge(String[] field, ReportOptions ro, String[][]arr, int n) {
		int adultcnt=0; int youthcnt=0; int childcnt=0; int seniorcnt=0; int enfantcnt=0;
		switch(field[2]) {
		case "����":
			adultcnt = Integer.parseInt(field[3]);
			arr[1][n] = Integer.toString(adultcnt); //�迭�� �ٷ� ����
			break;
		case "û�ҳ�":
			youthcnt += Integer.parseInt(field[3]);
			arr[2][n] = Integer.toString(youthcnt);
			break;
		case "���":
			childcnt += Integer.parseInt(field[3]);
			arr[3][n] = Integer.toString(childcnt);
			break;
		case "���":
			seniorcnt += Integer.parseInt(field[3]);
			arr[4][n] = Integer.toString(seniorcnt);
			break;
		case "36���� �̸� �����̿�":
			enfantcnt += Integer.parseInt(field[3]);
			arr[5][n] = Integer.toString(enfantcnt);
		}
	}
	public void printArr(String[][]arr) {
		for(int i = 0; i < arr.length; i ++) { //�����Ҵ�
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+",");
			}System.out.println();
		}
	}
}
