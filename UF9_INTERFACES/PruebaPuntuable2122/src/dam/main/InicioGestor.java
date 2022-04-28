package dam.main;

import java.awt.EventQueue;

import dam.control.GestrorCarreraControl;
import dam.view.PConsC;
import dam.view.PIntroC;
import dam.view.VMenuGestorCarrera;

public class InicioGestor {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				VMenuGestorCarrera v = new VMenuGestorCarrera();
				PIntroC pIntro = new PIntroC();
				PConsC pCons = new PConsC(); 
				
				GestrorCarreraControl c = new GestrorCarreraControl(v, pIntro, pCons);
				
				v.setControlador(c);
				pIntro.setControlador(c);
				pCons.setControlador(c);
				
				v.hacerVisible();
			}
		});

	}

}
