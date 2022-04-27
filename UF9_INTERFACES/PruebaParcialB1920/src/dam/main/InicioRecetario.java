package dam.main;

import java.awt.EventQueue;

import dam.control.RecetarioControl;
import dam.view.PConsultarReceta;
import dam.view.PIntroReceta;
import dam.view.VMenuRecetario;

public class InicioRecetario {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				VMenuRecetario v = new VMenuRecetario();
				PIntroReceta pIntro = new PIntroReceta();
				PConsultarReceta pConsulta = new PConsultarReceta();
				
				RecetarioControl c = new RecetarioControl(v, pIntro, pConsulta);
				
				v.setControlador(c);
				pIntro.setControlador(c);
				pConsulta.setControlador(c);
				
				v.hacerVisible();
				
			}
		});

	}

}
