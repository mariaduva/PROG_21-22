package dam.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import dam.control.RecetarioControl;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.Font;

public class VMenuRecetario extends JFrame {
	public static final int ANCHO = 800;
	public static final int ALTO = 600;
	
	public static final String MMTM_INTRO = "Introducir receta";
	public static final String MMTM_CONSULTAR = "Consultar receta";
	public static final String MMTM_SALIR = "Salir del recetario";
	
	private JScrollPane scrpContenedor;
	private JMenuItem mntmIntroReceta;
	private JMenuItem mntmConsultarReceta;
	private JMenuItem mntmSalir;
	
	public VMenuRecetario() {
		init();
		crearMenu();
	}

	private void init() {
		setTitle("Men\u00FA Recetario");
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
		
		mntmIntroReceta = new JMenuItem(MMTM_INTRO);
		mntmIntroReceta.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mntmIntroReceta);
		
		mntmConsultarReceta = new JMenuItem(MMTM_CONSULTAR);
		mntmConsultarReceta.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mntmConsultarReceta);
		
		mntmSalir = new JMenuItem(MMTM_SALIR);
		mntmSalir.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mntmSalir);
	}
	
	public void hacerVisible() {
		setVisible(true);
	}
	
	public void cargarPanel(JPanel panel) {
		scrpContenedor.setViewportView(panel);
	}

	private void centrarVentana() {
		// asignamos tamaño a la ventana
		setPreferredSize(new Dimension(ANCHO, ALTO));
		// Se obtienen las dimensiones en pixels de la pantalla.
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		// Se obtienen las dimensiones en pixels de la ventana.
		Dimension ventana = this.getPreferredSize();
		// Una cuenta para situar la ventana en el centro de la pantalla.
		setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);
		
		
	}
	
	public void setControlador (RecetarioControl controlador) {
		mntmIntroReceta.addActionListener(controlador);
		mntmConsultarReceta.addActionListener(controlador);
		mntmSalir.addActionListener(controlador);
		
	}
}
