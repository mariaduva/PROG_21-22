package dam.model;

import java.util.ArrayList;

public class ListaCompra {
	
	private ArrayList<Producto> listado;

	public ListaCompra() {
		listado = new ArrayList<Producto>();
	}

	public ArrayList<Producto> getListado() {
		return listado;
	}

	public void setListado(Producto e) {
		listado.add(e);
	}
	
	
}
