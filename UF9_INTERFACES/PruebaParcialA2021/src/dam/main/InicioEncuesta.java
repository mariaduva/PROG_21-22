package dam.main;

import java.awt.EventQueue;

import dam.control.EncuestaControlador;
import dam.view.PConsultarEncuesta;
import dam.view.PRealizarEncuesta;
import dam.view.VMenuEncuesta;

public class InicioEncuesta {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				VMenuEncuesta v = new VMenuEncuesta();
				PRealizarEncuesta pREnc = new PRealizarEncuesta();
				PConsultarEncuesta pCEnc = new PConsultarEncuesta();
				
				EncuestaControlador c = new EncuestaControlador(v, pREnc, pCEnc);
				
				v.setControlador(c);
				pREnc.setControlador(c);
				pCEnc.setControlador(c);
				
				v.hacerVisible();
			}
		});
	}

}
