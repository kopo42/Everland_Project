package everland;

import java.util.Scanner;

public class SelectorClass {
	ProcessingClass pc = new ProcessingClass();
	
	public void timeSelect(TypeClass t) {
		pc.getTime(t);
	}
	
	public void ageSelect(TypeClass t) {
		pc.getAge(t);
	}
	
	public void discntSelect(TypeClass t) {
		pc.getDiscnt(t);
	}
}

