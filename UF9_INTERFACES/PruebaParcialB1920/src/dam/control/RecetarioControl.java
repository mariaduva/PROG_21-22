package dam.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import dam.model.FuenteDatos;
import dam.model.Receta;
import dam.view.PConsultarReceta;
import dam.view.PIntroReceta;
import dam.view.VMenuRecetario;

public class RecetarioControl implements ActionListener {
		
		VMenuRecetario v;
		PIntroReceta pIntro;
		PConsultarReceta pConsulta;
		FuenteDatos datos; 
				
		

	public RecetarioControl(VMenuRecetario v, PIntroReceta pIntro, PConsultarReceta pConsulta) {
			this.v = v;
			this.pIntro = pIntro;
			this.pConsulta = pConsulta;
			datos = new FuenteDatos();
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JMenuItem) {
			if(e.getActionCommand().equals(VMenuRecetario.MMTM_INTRO)) {
				v.cargarPanel(pIntro);
				
			}else if (e.getActionCommand().equals(VMenuRecetario.MMTM_CONSULTAR)) {
				v.cargarPanel(pConsulta);
				pConsulta.hacerVisibleScrp(false);
				
			} else if (e.getActionCommand().equals(VMenuRecetario.MMTM_SALIR)){
				int respuesta = JOptionPane.showConfirmDialog(v, "Se va a cerrar la aplicación, ¿desea continuar?",
						"Confirmar salida",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.INFORMATION_MESSAGE);
				
				if (respuesta == JOptionPane.YES_OPTION) {
						System.exit(0);
				}
			}
		} else if (e.getSource() instanceof JButton) {
			if (e.getActionCommand().equals(PIntroReceta.BTN_GUARDAR)) {
				Receta r = pIntro.obetenerReceta();
				
				if(r != null) {
				datos.rellenarRecetario(r);
					
					JOptionPane.showMessageDialog(pIntro, "La información se ha almacenado correctamente", 
							"Resultado de operación", JOptionPane.INFORMATION_MESSAGE);
					
					pIntro.limpiarComponentes();
				
				}
				
			} else if (e.getActionCommand().equals(PConsultarReceta.BTN_CONSULTAR)) {
				pConsulta.rellenarTabla(datos.getRecetario());
				pConsulta.hacerVisibleScrp(true);
				
			}
		}

	}

}
