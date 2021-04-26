package everland;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ProcessingClass {
	CalClass cal = new CalClass();
	
	public void	getTime (TypeClass t) {
		if (t.time == Options.day) {
			t.price_time = Options.price_day;
			t.timestr = "주간";
		} else {
			t.price_time = Options.price_night;
			t.timestr = "야간";
		}
	}
	
	public void getAge (TypeClass t) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		int now_year = Integer.parseInt(sdf.format(calendar.getTime()));
		
		int birth_year = Integer.parseInt(t.minbun.substring(0, 4));
		t.age = now_year - birth_year;
		
		//price = {성인, 청소년, 어린이, 경로, 유아}
		if(t.age >= Options.adultMin && t.age <= Options.adultMax) {
			t.price_age = t.price_time[0];
			t.agestr = "성인";
		} else if (t.age >= Options.youthMin && t.age <= Options.youthMax) {
			t.price_age = t.price_time[1];
			t.agestr = "청소년";
		} else if (t.age >= Options.childMin && t.age <= Options.childMax) {
			t.price_age = t.price_time[2];
			t.agestr = "어린이";
		} else if(t.age >= Options.senior){
			t.price_age = t.price_time[3];
			t.agestr = "경로";
		} else if(t.age <= Options.enfant) {
			t.price_age = t.price_time[4];
			t.agestr = "36개월 미만 무료이용";
		}
	}
	
	public int getDiscnt(TypeClass t) {
		switch(t.discnt) {
		case 1:
			t.disrate = Options.non;
			t.discntstr = "우대사항 없음";
			t.subtotal = cal.Subtotal1(t);
			break;
		case 2:
			t.disrate = Options.disabled;
			t.discntstr = "장애인";
			t.subtotal =cal.Subtotal2(t);
			break;
		case 3:
			t.disrate = Options.veteran;
			t.discntstr = "국가유공자";
			t.subtotal =cal.Subtotal2(t);
			break;
		case 4:
			t.disrate = Options.multiChild;
			t.discntstr = "다자녀";
			t.subtotal =cal.Subtotal1(t);
			break;
		case 5:
			t.disrate = Options.preg;
			t.discntstr = "임산부";
			t.subtotal =cal.Subtotal3(t);
			break;
		}
		return t.subtotal;
	}
}
