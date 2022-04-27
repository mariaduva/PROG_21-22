package dam.model;

import java.util.ArrayList;

public class FuenteDatos {
	
	private ArrayList<Receta> recetario;
	
	public FuenteDatos() {
		recetario = new ArrayList<Receta>();
		
	}

	public void rellenarRecetario(Receta e) {
		recetario.add(e);
	}

	public ArrayList<Receta> getRecetario() {
		return recetario;
	}
	
	
}
