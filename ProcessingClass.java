package everland;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ProcessingClass {
	
	public void	getTime (TypeClass t) {
		if (t.time == Options.day) {
			t.price_time = Options.price_day;
			t.timestr = "�ְ�";
		} else {
			t.price_time = Options.price_night;
			t.timestr = "�߰�";
		}
	}
	
	public void getAge (TypeClass t) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		int now_year = Integer.parseInt(sdf.format(cal.getTime()));
		System.out.println(now_year);
		
		int birth_year = 1900 + Integer.parseInt(t.minbun.substring(0, 2));
		t.age = now_year - birth_year;
		System.out.println(birth_year);
		
		//price = {�, û�ҳ�, �Ҿ�, ���}
		if(t.age >= Options.adultMin && t.age <= Options.adultMax) {
			t.price_age = t.price_time[0];
			t.agestr = "�";
		} else if (t.age >= Options.youthMin && t.age <= Options.youthMax) {
			t.price_age = t.price_time[1];
			t.agestr = "û�ҳ�";
		} else if (t.age >= Options.childMin && t.age <= Options.childMax) {
			t.price_age = t.price_time[2];
			t.agestr = "�Ҿ�";
		} else {
			t.price_age = t.price_time[3];
			t.agestr = "���";
		}
	}
	
	public void getDiscnt(TypeClass t) {
		switch(t.discnt) {
		case 1:
			t.disrate = Options.non;
			t.discntstr = "������ ����";
			break;
		case 2:
			t.disrate = Options.disabled;
			t.discntstr = "�����";
			break;
		case 3:
			t.disrate = Options.veteran;
			t.discntstr = "����������";
			break;
		case 4:
			t.disrate = Options.multiChild;
			t.discntstr = "���ڳ�";
			break;
		case 5:
			t.disrate = Options.preg;
			t.discntstr = "�ӻ��";
			break;
		}
	}
}
