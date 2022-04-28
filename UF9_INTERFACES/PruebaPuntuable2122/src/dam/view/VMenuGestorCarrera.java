package dam.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;

import dam.control.GestrorCarreraControl;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Font;

public class VMenuGestorCarrera extends JFrame {
	public static final int ANCHO = 800;
	public static final int ALTO = 600;
	
	public static final String MMTM_INTRO = "Introducir Corredor";
	public static final String MMTM_CONSULTAR = "Consultar Corredores";
	public static final String MMTM_SALIR = "Salir";
	
	private JScrollPane scrpContenedor;
	private JMenuItem mntmIntroCorredor;
	private JMenuItem mntmConsCorredor;
	private JMenuItem mntmSalir;
	
	public VMenuGestorCarrera() {
		init();
		crearMenu();
	}

	private void init() {
		setTitle("Menú Gestor Carrera");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		scrpContenedor = new JScrollPane();
		getContentPane().add(scrpContenedor, BorderLayout.CENTER);
		
		centrarVentana();
		setSize(ANCHO, ALTO);
		
	}

	private void crearMenu() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mntmIntroCorredor = new JMenuItem(MMTM_INTRO);
		mntmIntroCorredor.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mntmIntroCorredor);
		
		mntmConsCorredor = new JMenuItem(MMTM_CONSULTAR);
		mntmConsCorredor.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mntmConsCorredor);
		
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
		setPreferredSize(new Dimension(ANCHO, ALTO));
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension ventana = this.getPreferredSize();
		setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);
		
	}
	
	public void setControlador (GestrorCarreraControl c) {
		mntmConsCorredor.addActionListener(c);
		mntmIntroCorredor.addActionListener(c);
		mntmSalir.addActionListener(c);
	}
	
}
