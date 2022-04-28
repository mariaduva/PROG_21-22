package dam.view;

import javax.swing.JPanel;

import dam.control.EncuestaControlador;
import dam.model.Encuesta;

import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;

public class PConsultarEncuesta extends JPanel {
	private static final int RESTA_ANCHO = VMenuEncuesta.ANCHO -15;
	private static final int RESTA_ALTO = VMenuEncuesta .ALTO - 70;
	
	public static final String BTN_VER = "Ver Resultado";
	
	private JButton btnVer;
	private DefaultListModel<Encuesta> dlm;
	private JList <Encuesta>lstEncuestas;
	private JScrollPane scrpContenedor;
	
	public PConsultarEncuesta() {
		init();
	}

	private void init() {
		setSize(RESTA_ANCHO, RESTA_ALTO);
		setLayout(null);
		
		JLabel lblListEnc = new JLabel("Listado de encuestas");
		lblListEnc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblListEnc.setBounds(56, 49, 196, 20);
		add(lblListEnc);
		
		btnVer = new JButton(BTN_VER);
		btnVer.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVer.setBounds(782, 45, 162, 28);
		add(btnVer);
		
		scrpContenedor = new JScrollPane();
		scrpContenedor.setVisible(false);
		scrpContenedor.setBounds(55, 95, 890, 301);
		add(scrpContenedor);
		
		lstEncuestas = new JList<Encuesta>();
		dlm = new DefaultListModel<Encuesta>();
		lstEncuestas.setModel(dlm);
		scrpContenedor.setViewportView(lstEncuestas);
		
	}

	public void setControlador(EncuestaControlador c) {
		btnVer.addActionListener(c);
		
	}
}
