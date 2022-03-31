package dam.main;

import java.awt.EventQueue;

import dam.control.ConvertidorDEControlador;
import dam.view.VConvertidorDolEur;

public class Ejercicio2 {

	public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				VConvertidorDolEur v = new VConvertidorDolEur();
				
				ConvertidorDEControlador c = new ConvertidorDEControlador(v);
				
				v.setControlador(c);
				
				v.hacerVisible();
			}
		});
	}

}
