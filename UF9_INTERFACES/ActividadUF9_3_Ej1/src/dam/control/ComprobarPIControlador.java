package dam.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dam.view.VComprobarParImpar;

public class ComprobarPIControlador implements ActionListener {
	VComprobarParImpar ventana;
	
	public ComprobarPIControlador(VComprobarParImpar ventana) {
		this.ventana = ventana;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Integer num = ventana.obtenerNumero();
		
		if (num != null) {
			if (num % 2 == 0) {
				ventana.mostrarResultado("El número es PAR");
			} else {
				ventana.mostrarResultado("El número es IMPAR");
			}
		}

	}

}
