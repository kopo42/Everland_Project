package everland;

public class CalClass {
	TypeClass t = new TypeClass();
	
	public void CalSubtotal(TypeClass t) {
		t.subtotal = (int) ((t.price_age * t.disrate) * t.amnt);
	}
}
