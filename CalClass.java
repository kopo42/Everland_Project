package everland;

public class CalClass {
	TypeClass t = new TypeClass();
	
	public int Subtotal1(TypeClass t) { //전원 할인
		t.subtotal = (int) ((t.price_age * (1 - t.disrate)) * t.amnt);
		return t.subtotal;
	}
	public int Subtotal2(TypeClass t) { //동반 2인 할인
		if(t.amnt > 2) {
			t.subtotal = (int) (((t.price_age * (1 - t.disrate)) * 2 + (t.price_age * (1 - t.disrate)) * (t.amnt - 2)));
		} else {
			t.subtotal = (int) ((t.price_age * (1 - t.disrate)) * t.amnt);
		}
		return t.subtotal;
	}
	public int Subtotal3(TypeClass t) { //본인만 할인
		if(t.amnt > 1) {
			t.subtotal = (int) (((t.price_age * (1 - t.disrate)) * 1 + (t.price_age * (1 - t.disrate)) * (t.amnt - 1)));
		} else {
			t.subtotal = (int) ((t.price_age * (1 - t.disrate)) * t.amnt);
		}
		return t.subtotal;
	}
}
