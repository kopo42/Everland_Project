import java.io.IOException;

public class ReportType {
	//ReportOptions ro = new ReportOptions();
	ReportFileWrite rf = new ReportFileWrite();
	public int TypeDay (String[] field, ReportOptions ro) {
		if (field[1].equals("�ְ�")) {
			ro.daycnt += Integer.parseInt(field[3]);
			TypeAge(field, ro);
		}
		return ro.dayTotal;
		}

	public int TypeNight(String[] field, ReportOptions ro) {
		if(field[1].equals("�߰�")) {
			ro.nightTotal += Integer.parseInt(field[3]);
			TypeAge(field, ro);
		}
		return ro.nightTotal;
	}
	
	public void TypeDiscnt(String[] field, ReportOptions ro) {
		switch(field[5]) {
		case "������ ����":
			ro.discntType = "������ ����";
			ro.noncnt += Integer.parseInt(field[3]);
			break;
		case "�����":
			ro.discntType = "�����";
			ro.disablecnt += Integer.parseInt(field[3]);
			break;
		case "����������":
			ro.discntType = "����������";
			ro.veterancnt += Integer.parseInt(field[3]);
			break;
		case "���ڳ�":
			ro.discntType = "���ڳ�";
			ro.multichildcnt += Integer.parseInt(field[3]);
			break;
		case "�ӻ��":
			ro.discntType = "�ӻ��";
			ro.pregcnt += Integer.parseInt(field[3]);
			break;
		}
	}
	
	public void TypeAge(String[] field, ReportOptions ro) {
		ro.reportHead = "����,"+"�ְ���,"+"�߰���"+"\n";
		switch(field[2]) {
		case "����":
			ro.ageType = "����";
			ro.adultcnt += Integer.parseInt(field[3]);
			break;
		case "û�ҳ�":
			ro.ageType = "û�ҳ�";
			ro.youthcnt += Integer.parseInt(field[3]);
			break;
		case "���":
			ro.ageType = "���";
			ro.childcnt += Integer.parseInt(field[3]);
			break;
		case "���":
			ro.ageType = "���";
			ro.seniorcnt += Integer.parseInt(field[3]);
			break;
		case "36���� �̸� �����̿�":
			ro.ageType = "36���� �̸� �����̿�";
			ro.enfantcnt += Integer.parseInt(field[3]);
		}
	}
}
