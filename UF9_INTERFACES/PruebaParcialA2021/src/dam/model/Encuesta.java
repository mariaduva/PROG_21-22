package dam.model;

public class Encuesta {
	
	private String rangEdad;
	private String frecuencia;
	private String series;
	
	public Encuesta(String rangEdad, String frecuencia, String series) {
		this.rangEdad = rangEdad;
		this.frecuencia = frecuencia;
		this.series = series;
	}

	public String getRangEdad() {
		return rangEdad;
	}

	public String getFrecuencia() {
		return frecuencia;
	}

	public String getSeries() {
		return series;
	}
	
	
}
