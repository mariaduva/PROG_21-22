package dam.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import dam.model.Encuesta;
import dam.model.FuenteDatos;
import dam.view.PConsultarEncuesta;
import dam.view.PRealizarEncuesta;
import dam.view.VMenuEncuesta;

public class EncuestaControlador implements ActionListener {
	
	VMenuEncuesta v;
	PRealizarEncuesta pREnc;
	PConsultarEncuesta pCEnc;
	FuenteDatos datos;
	
	
	public EncuestaControlador(VMenuEncuesta v, PRealizarEncuesta pREnc, PConsultarEncuesta pCEnc) {
		this.v = v;
		this.pREnc = pREnc;
		this.pCEnc = pCEnc;
		datos = new FuenteDatos();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()instanceof JMenuItem) {
			if (e.getActionCommand().equals(VMenuEncuesta.MMTM_REALIZAR)) {
				v.cargarPanel(pREnc);
			} else if (e.getActionCommand().equals(VMenuEncuesta.MMTM_CONSULTAR)) {
				v.cargarPanel(pCEnc);
			}
		} else if (e.getSource() instanceof JButton) {
			if (e.getActionCommand().equals(PConsultarEncuesta.BTN_VER)) {
				
			} else if (e.getActionCommand().equals(PRealizarEncuesta.BTN_GUARDAR)) {
				Encuesta enc = pREnc.obtenerEnc();
				
				datos.rellenarListadoEncuestas(enc);
				
				JOptionPane.showMessageDialog(pREnc, "La información se ha almacenado correctamente", 
						"Resultado de operación", JOptionPane.INFORMATION_MESSAGE);
				
			} else if (e.getActionCommand().equals(PRealizarEncuesta.BTN_LIMPIAR)) {
				pREnc.limpiarComponentes();
			}
		}

	}

}
