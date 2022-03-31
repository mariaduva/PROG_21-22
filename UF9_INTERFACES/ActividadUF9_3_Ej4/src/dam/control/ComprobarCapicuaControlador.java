package dam.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dam.model.Capicua;
import dam.view.VComprobarCapicua;

public class ComprobarCapicuaControlador implements ActionListener {
	VComprobarCapicua ventana;
	
	public ComprobarCapicuaControlador (VComprobarCapicua ventana) {
		this.ventana = ventana;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Capicua capi = ventana.obtenerDatos();
		
		if (capi != null) {
			boolean isCapicua = capi.ComprobarCapicua();
			
			if(isCapicua)
				ventana.mostrarResultado("El n�mero es capic�a");
			else 
				ventana.mostrarResultado("El n�mero NO es capic�a");
		}
		
	}

}
