package dam.model;

import java.util.ArrayList;

public class FuenteDatos {
	
	private ArrayList<Corredor> listadoCorredores;
	
	

	public FuenteDatos() {
		listadoCorredores = new ArrayList<>();
	}

	public ArrayList<Corredor> getListadoCorredores() {
		return listadoCorredores;
	}
	
	public ArrayList<Corredor> getListadoCorredoresFiltrado(String sexo) {
		ArrayList<Corredor> listadoCorredoresFiltrado = new ArrayList<Corredor>();
		for (Corredor c : listadoCorredores) {
			if(c.getSexo().equals(sexo)){
				listadoCorredoresFiltrado.add(c);
			}
		}
		return listadoCorredoresFiltrado;
	}
	
	public void rellenarListado(Corredor c) {
		listadoCorredores.add(c);
	}
	


}
