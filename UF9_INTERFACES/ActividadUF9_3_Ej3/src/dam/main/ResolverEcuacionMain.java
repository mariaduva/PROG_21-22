package dam.main;

import java.awt.EventQueue;

import dam.control.ResolverEcuacionControlador;
import dam.view.VResolverEcuacion;

public class ResolverEcuacionMain {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				VResolverEcuacion v = new VResolverEcuacion();
				
				ResolverEcuacionControlador c = new ResolverEcuacionControlador(v);
				
				v.setControlador(c);
				
				v.hacerVisible();
			}
		});

	}

}
