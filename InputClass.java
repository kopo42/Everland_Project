package everland;

import java.util.Scanner;

public class InputClass {
	TypeClass t = new TypeClass();
	Scanner scan = null;
	InputClass() {
		scan = new Scanner(System.in);
	}
	
	protected void finalize() {
		scan.close();
	}
	
	public void inputTime() {
		t.time = scan.nextInt();
	}
	public void inputMinbun() {
		t.minbun = scan.nextInt();
	}
	public void inputAge() {
		t.age = scan.nextInt();
	}
	public void inputAmnt () {
		t.amnt = scan.nextInt();
	}
	public void inputDiscnt() {
		t.discnt = scan.nextInt();
	}

}
