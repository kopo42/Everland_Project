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
		//1 [날짜, 2021-04-26, 2021-04-26, 2021-04-26, 2021-04-26, 2021-04-26, 2021-04-26, 2021-04-26, 2021-04-26, 2021-04-28, 2021-04-28, 2021-04-28, 2021-04-28]
		//2 [2021-04-26, 2021-04-28, 날짜]
		
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
		//if(ro.isFileExist == false) { //필요한가??
		dayArr[0][0] = "구분"; dayArr[0][1] = "주간권"; dayArr[0][2] = "야간권"; //header
		String[] ages = {".", "성인", "청소년", "어린이", "경로", "36개월 미만 무료이용", "합계", "매출"};
		int daycnt = 0;
		int nightcnt = 0;
		int i = 1;
		while (i < dayArr.length) {
			dayArr[i][0] = ages[i]; //구분 지정
			i++;
		}
		if (field[1].equals("주간")) {
			ro.dayTotal += Integer.parseInt(field[4]);
			daycnt += Integer.parseInt(field[3]);
			TypeAge(field, ro, dayArr, 1);

			ro.daysum += daycnt;
		} else if (field[1].equals("야간")) {
			ro.nightTotal += Integer.parseInt(field[4]);
			nightcnt += Integer.parseInt(field[3]);
			TypeAge(field, ro, dayArr, 2);
				
			ro.nightsum += nightcnt;
		}
	}

	
	public void TypeDiscnt(String[] field, ReportOptions ro, ReportFileWrite rf) throws IOException {
		String filename = "c:\\Users\\J\\Desktop\\source\\우대별.csv";
		rf = new ReportFileWrite(filename);
		
		String head = "구분,"+"주간권,"+"야간권"+"\n";
		rf.headerWrite(head);
		
		switch(field[5]) {
		case "우대사항 없음":
			ro.discntType = "우대사항 없음";
			ro.noncnt += Integer.parseInt(field[3]);
			ro.discntSubtotal = Integer.parseInt(field[4]);
			ro.nonTotal += Integer.parseInt(field[4]);
			break;
		case "장애인":
			ro.discntType = "장애인";
			ro.disabledcnt += Integer.parseInt(field[3]);
			ro.discntSubtotal = Integer.parseInt(field[4]);
			ro.disabledTotal += Integer.parseInt(field[4]);
			break;
		case "국가유공자":
			ro.discntType = "국가유공자";
			ro.veterancnt += Integer.parseInt(field[3]);
			ro.discntSubtotal = Integer.parseInt(field[4]);
			ro.veteranTotal += Integer.parseInt(field[4]);
			break;
		case "다자녀":
			ro.discntType = "다자녀";
			ro.multichildcnt += Integer.parseInt(field[3]);
			ro.discntSubtotal = Integer.parseInt(field[4]);
			ro.multichildTotal += Integer.parseInt(field[4]);
			break;
		case "임산부":
			ro.discntType = "임산부";
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
		case "성인":
			adultcnt = Integer.parseInt(field[3]);
			arr[1][n] = Integer.toString(adultcnt); //배열에 바로 저장
			break;
		case "청소년":
			youthcnt += Integer.parseInt(field[3]);
			arr[2][n] = Integer.toString(youthcnt);
			break;
		case "어린이":
			childcnt += Integer.parseInt(field[3]);
			arr[3][n] = Integer.toString(childcnt);
			break;
		case "경로":
			seniorcnt += Integer.parseInt(field[3]);
			arr[4][n] = Integer.toString(seniorcnt);
			break;
		case "36개월 미만 무료이용":
			enfantcnt += Integer.parseInt(field[3]);
			arr[5][n] = Integer.toString(enfantcnt);
		}
	}
	public void printArr(String[][]arr) {
		for(int i = 0; i < arr.length; i ++) { //동적할당
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+",");
			}System.out.println();
		}
	}
}
