package dam.main;

import java.awt.EventQueue;

import dam.control.ComprobarCapicuaControlador;
import dam.view.VComprobarCapicua;

public class Ejercicio4 {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				VComprobarCapicua v = new VComprobarCapicua();
				
				ComprobarCapicuaControlador c = new ComprobarCapicuaControlador(v);
				
				v.setControlador(c);
				
				v.hacerVisible();
			}
		});

	}

}
