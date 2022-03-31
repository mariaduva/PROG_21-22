package dam.main;

import java.awt.EventQueue;

import dam.control.ComprobarPIControlador;
import dam.view.VComprobarParImpar;

public class Ejercicio1 {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				VComprobarParImpar v = new VComprobarParImpar();
				
				ComprobarPIControlador c = new ComprobarPIControlador(v);
				
				v.setControlador(c);

				v.hacerVisible();
			}
		});
		

	}

}
