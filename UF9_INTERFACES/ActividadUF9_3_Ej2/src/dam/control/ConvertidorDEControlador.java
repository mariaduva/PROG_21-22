package dam.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dam.view.VConvertidorDolEur;

public class ConvertidorDEControlador implements ActionListener {
	VConvertidorDolEur ventana;
	
	public static final double CHANGE = 0.91; 
	public ConvertidorDEControlador(VConvertidorDolEur ventana) {
		this.ventana = ventana;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		double result;
		String res;
		Double num = ventana.obtenerNumero();
		
		if (num != null && num > 0) {
			result = Math.round(num * CHANGE);
			res = String.valueOf(result);
			ventana.mostrarResultado(res);
			
		}
	}

}
