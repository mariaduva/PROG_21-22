package dam.main;

import java.awt.EventQueue;

import dam.control.CalculadoraSalarioControlador;
import dam.view.VCalculadoraSalario;

public class Ejercicio5 {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				VCalculadoraSalario v = new VCalculadoraSalario();
				
				CalculadoraSalarioControlador c = new CalculadoraSalarioControlador(v);
				
				v.setControlador(c);
				
				v.hacerVisible();
			}
		});

	}

}
