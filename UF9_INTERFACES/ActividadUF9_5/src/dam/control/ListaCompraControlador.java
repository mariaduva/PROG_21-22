package dam.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import dam.model.ListaCompra;
import dam.view.VListaCompra;

public class ListaCompraControlador implements ActionListener {
	VListaCompra ventana;
	ListaCompra listaCompra;
	
	public ListaCompraControlador (VListaCompra ventana) {
		this.ventana = ventana;
		listaCompra = new ListaCompra();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
			if(e.getActionCommand().equals(VListaCompra.BTN_ANADIR)) {
				ventana.anadirProducto();
			}
		}

	}

}
