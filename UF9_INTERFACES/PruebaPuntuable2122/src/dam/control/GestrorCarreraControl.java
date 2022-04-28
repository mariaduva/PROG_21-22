package dam.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import dam.model.Corredor;
import dam.model.FuenteDatos;
import dam.view.PConsC;
import dam.view.PIntroC;
import dam.view.VMenuGestorCarrera;

public class GestrorCarreraControl implements ActionListener {
	
	VMenuGestorCarrera v;
	PIntroC pIntro;
	PConsC pCon;
	FuenteDatos datos;
	
	public GestrorCarreraControl(VMenuGestorCarrera v, PIntroC pIntro, PConsC pCon) {
		this.v = v;
		this.pIntro = pIntro;
		this.pCon = pCon;
		datos = new FuenteDatos();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()instanceof JMenuItem) {
			if(e.getActionCommand().equals(VMenuGestorCarrera.MMTM_INTRO)) {
				v.cargarPanel(pIntro);
			} else if (e.getActionCommand().equals(VMenuGestorCarrera.MMTM_CONSULTAR)) {
				v.cargarPanel(pCon);
				pCon.hacerVisibleScrp(false);
			} else if (e.getActionCommand().equals(VMenuGestorCarrera.MMTM_SALIR)) {
				int respuesta = JOptionPane.showConfirmDialog(v, "Se va a cerrar la aplicación, ¿desea continuar?",
						"Confirmar salida",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.INFORMATION_MESSAGE);
				
				if (respuesta == JOptionPane.YES_OPTION) {
						System.exit(0);
				}
			}
		} else if (e.getSource() instanceof JButton) {
			if (e.getActionCommand().equals(PIntroC.BTN_GUARDAR)) {
				Corredor c = pIntro.obtenerCorredor();
				
				if (c != null) {
					datos.rellenarListado(c);
					
					JOptionPane.showMessageDialog(pIntro, "La información se ha almacenado correctamente", 
							"Resultado de operación", JOptionPane.INFORMATION_MESSAGE);
				}
				
			} else if (e.getActionCommand().equals(PIntroC.BTN_LIMPIAR)) {
				pIntro.limpiarComponentes();
			}  else if (e.getActionCommand().equals(PConsC.BTN_CONSULTAR)) {
				pCon.hacerVisibleScrp(true);
			}
		} else if (e.getSource() instanceof JRadioButton) {
			if(e.getActionCommand().equals(PConsC.RDBTN_HOMBRE)) {
				pCon.borrarTabla();
				pCon.rellenarTabla(datos.getListadoCorredoresFiltrado("Hombre"));
				
			} else if(e.getActionCommand().equals(PConsC.RDBTN_MUJER)) {
				pCon.borrarTabla();
				pCon.rellenarTabla(datos.getListadoCorredoresFiltrado("Mujer"));	
				
			} else if(e.getActionCommand().equals(PConsC.RDBTN_TODOS)) {
				pCon.borrarTabla();
				pCon.rellenarTabla(datos.getListadoCorredores());
			}
		}
	}

}
