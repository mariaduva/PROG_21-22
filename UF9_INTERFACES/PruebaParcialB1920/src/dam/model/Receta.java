package dam.model;

public class Receta {
	
	private String nombre;
	private String descripcion;
	private int tiempo;
	private String dificultad;
	
	public Receta(String nombre, String descripcion, int tiempo, String dificultad) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tiempo = tiempo;
		this.dificultad = dificultad;
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	public String getDificultad() {
		return dificultad;
	}

	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}
	
	
	

}
