package dam.model;

import java.util.ArrayList;

public class FuenteDatos {
	private ArrayList<Encuesta> listadoEncuestas;
	
	

	public FuenteDatos() {
		listadoEncuestas = new ArrayList<Encuesta>();
	}

	public ArrayList<Encuesta> getListadoEncuestas() {
		return listadoEncuestas;
	}

	public void rellenarListadoEncuestas(Encuesta e) {
		listadoEncuestas.add(e);
	}
	
	
}
