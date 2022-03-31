package dam.model;

public class Salario {
	public static final int SE = 16; // paga x hora
	public static final int HX = 20; // horas extras
	public static final int HS = 40; // máximo de horas semanales
	
	private int horasSem;

	public Salario(int horasSem) {
		this.horasSem = horasSem;
	}
	
	public int calcularSalarioSem() {
		int salarioSem;
		
		if (horasSem <= HS) salarioSem = horasSem * 16;
		else salarioSem = HS * 16 + ((horasSem - 40) * 20); 
		
		return salarioSem;
	}
}
