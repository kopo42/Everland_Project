import java.io.IOException;

public class ReportType {
	//ReportOptions ro = new ReportOptions();
	ReportFileWrite rf = new ReportFileWrite();
	public int TypeDay (String[] field, ReportOptions ro) {
		if (field[1].equals("주간")) {
			ro.daycnt += Integer.parseInt(field[3]);
			TypeAge(field, ro);
		}
		return ro.dayTotal;
		}

	public int TypeNight(String[] field, ReportOptions ro) {
		if(field[1].equals("야간")) {
			ro.nightTotal += Integer.parseInt(field[3]);
			TypeAge(field, ro);
		}
		return ro.nightTotal;
	}
	
	public void TypeDiscnt(String[] field, ReportOptions ro) {
		switch(field[5]) {
		case "우대사항 없음":
			ro.discntType = "우대사항 없음";
			ro.noncnt += Integer.parseInt(field[3]);
			break;
		case "장애인":
			ro.discntType = "장애인";
			ro.disablecnt += Integer.parseInt(field[3]);
			break;
		case "국가유공자":
			ro.discntType = "국가유공자";
			ro.veterancnt += Integer.parseInt(field[3]);
			break;
		case "다자녀":
			ro.discntType = "다자녀";
			ro.multichildcnt += Integer.parseInt(field[3]);
			break;
		case "임산부":
			ro.discntType = "임산부";
			ro.pregcnt += Integer.parseInt(field[3]);
			break;
		}
	}
	
	public void TypeAge(String[] field, ReportOptions ro) {
		ro.reportHead = "구분,"+"주간권,"+"야간권"+"\n";
		switch(field[2]) {
		case "성인":
			ro.ageType = "성인";
			ro.adultcnt += Integer.parseInt(field[3]);
			break;
		case "청소년":
			ro.ageType = "청소년";
			ro.youthcnt += Integer.parseInt(field[3]);
			break;
		case "어린이":
			ro.ageType = "어린이";
			ro.childcnt += Integer.parseInt(field[3]);
			break;
		case "경로":
			ro.ageType = "경로";
			ro.seniorcnt += Integer.parseInt(field[3]);
			break;
		case "36개월 미만 무료이용":
			ro.ageType = "36개월 미만 무료이용";
			ro.enfantcnt += Integer.parseInt(field[3]);
		}
	}
}
