package everland;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ProcessingClass {
	
	public void	getTime (TypeClass t) {
		if (t.time == Options.day) {
			t.price_time = Options.price_day;
		} else {
			t.price_time = Options.price_night;
		}
	}
	
	public void getAge (TypeClass t) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		int now_year = Integer.parseInt(sdf.format(cal.getTime()));
		
		int birth_year = Integer.parseInt(t.minbun.substring(0, 2));
		t.age = now_year - birth_year;
		
		//price = {어른, 청소년, 소아, 경로}
		if(t.age >= Options.adultMin && t.age <= Options.adultMax) {
			t.price_age = t.price_time[0];
			t.agestr = "어른";
		} else if (t.age >= Options.youthMin && t.age <= Options.youthMax) {
			t.price_age = t.price_time[1];
			t.agestr = "청소년";
		} else if (t.age >= Options.childMin && t.age <= Options.childMax) {
			t.price_age = t.price_time[2];
			t.agestr = "소아";
		} else {
			t.price_age = t.price_time[3];
			t.agestr = "경로";
		}
	}
	
	public void getDiscnt(TypeClass t) {
		switch(t.discnt) {
		case 0:
			t.disrate = Options.non;
			break;
		case 1:
			t.disrate = Options.disabled;
			break;
		case 2:
			t.disrate = Options.veteran;
			break;
		case 3:
			t.disrate = Options.multiChild;
			break;
		case 4:
			t.disrate = Options.preg;
			break;
		}
	}
}
