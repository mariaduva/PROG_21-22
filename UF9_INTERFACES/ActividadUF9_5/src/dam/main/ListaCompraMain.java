package dam.main;

import java.awt.EventQueue;

import dam.control.ListaCompraControlador;
import dam.view.VListaCompra;

public class ListaCompraMain {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				VListaCompra v = new VListaCompra();
				
				ListaCompraControlador c = new ListaCompraControlador(v);
				
				v.setControlador(c);
				
				v.hacerVisible();
			}
		});
	}

}
