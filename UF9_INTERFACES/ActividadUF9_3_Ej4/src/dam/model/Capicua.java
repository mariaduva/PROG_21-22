package dam.model;

public class Capicua {
	private int num;
	
	
	public Capicua(int num) {
		this.num = num;
	}
	
	public boolean ComprobarCapicua() {
		boolean isCapicua = true;
		char [] digits = new char [3];
		String s = "";
		
		s = Integer.toString(num);
		
		for (int i = 0; i < digits.length; i++) {
			digits[i] = s.charAt(i);
		}
		
		if(digits[0] != digits[2]) isCapicua = false;
		
		return isCapicua;
	}
}
