package dam.view;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JScrollPane;

import dam.control.EncuestaControlador;

public class VMenuEncuesta extends JFrame {
	public static final int ANCHO = 1015 ;
	public static final int ALTO = 520;
	
	public static final String MMTM_REALIZAR = "Realizar Encuestas";
	public static final String MMTM_CONSULTAR = "Consultar Encuestas";
	private JScrollPane scrpContenedor;
	private JMenuItem mntmRealizarEnc;
	private JMenuItem mntmConsultarEnc;
	
	public VMenuEncuesta() {
		init();
		crearMenu();
	}

	private void init() {
		setTitle("Menú Encuesta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		scrpContenedor = new JScrollPane();
		getContentPane().add(scrpContenedor, BorderLayout.CENTER);
				
		centrarVentana();
		setSize(ANCHO,ALTO);
		
	}

	private void crearMenu() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mntmRealizarEnc = new JMenuItem(MMTM_REALIZAR);
		mntmRealizarEnc.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mntmRealizarEnc);
		
		mntmConsultarEnc = new JMenuItem(MMTM_CONSULTAR);
		mntmConsultarEnc.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mntmConsultarEnc);
	}

	private void centrarVentana() {
		setPreferredSize(new Dimension(ANCHO, ALTO));
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension ventana = this.getPreferredSize();
		setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);
		
	}
	
	public void hacerVisible() {
		setVisible(true);
	}
	
	public void cargarPanel(JPanel panel) {
		scrpContenedor.setViewportView(panel);
	}
	
	public void setControlador (EncuestaControlador c) {
		mntmConsultarEnc.addActionListener(c);
		mntmRealizarEnc.addActionListener(c);
	}
	

}
