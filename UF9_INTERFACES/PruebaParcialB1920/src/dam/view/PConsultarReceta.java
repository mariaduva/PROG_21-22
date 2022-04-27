package dam.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dam.control.RecetarioControl;
import dam.model.Receta;

import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PConsultarReceta extends JPanel {
	private static final int RESTA_ANCHO = VMenuRecetario.ANCHO -15;
	private static final int RESTA_ALTO = VMenuRecetario .ALTO - 70;
	
	public static final String BTN_CONSULTAR = "Consultar listado";
	
	private JTable tblRecetas;
	private JButton btnConsultar;
	private JScrollPane scrpContenedor;
	private DefaultTableModel tModel;
	
	public PConsultarReceta() {
		init();
	}


	private void init() {
		setSize(RESTA_ANCHO, RESTA_ALTO);
		setLayout(null);
		
		scrpContenedor = new JScrollPane();
		scrpContenedor.setVisible(false);
		scrpContenedor.setBounds(49, 105, 687, 349);
		add(scrpContenedor);
		
		tblRecetas = new JTable();
		configurarTabla();
		tblRecetas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrpContenedor.setViewportView(tblRecetas);
		
		JLabel lblConsulta = new JLabel("Listado de videojuegos");
		lblConsulta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConsulta.setBounds(49, 52, 303, 22);
		add(lblConsulta);
		
		btnConsultar = new JButton(BTN_CONSULTAR);
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConsultar.setBounds(587, 52, 149, 25);
		add(btnConsultar);
	}


	private void configurarTabla() {
		tModel = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
	
		tblRecetas.setModel(tModel);
		
		
		tModel.addColumn("NOMBRE");
		tModel.addColumn("DESCRIPCIÓN");
		tModel.addColumn("TIEMPO");
		tModel.addColumn("DIFICULTAD");
				
		tblRecetas.getColumn("NOMBRE").setPreferredWidth(75);
		tblRecetas.getColumn("DESCRIPCIÓN").setPreferredWidth(80);
		tblRecetas.getColumn("TIEMPO").setPreferredWidth(25);
		tblRecetas.getColumn("DIFICULTAD").setPreferredWidth(40);
		
	}
	
	public void rellenarTabla(ArrayList<Receta> listaRecetas) {
		tModel.getDataVector().clear();
		
		Object[] fila = new Object[4];
		
		for (Receta r : listaRecetas) {
			fila[0] = r.getNombre();
			fila[1] = r.getDescripcion();
			fila[2] = r.getTiempo();
			fila[3] = r.getDificultad();
			
			tModel.addRow(fila);
		}
	}


	public void setControlador(RecetarioControl c) {
		btnConsultar.addActionListener(c);
		
	}


	public void hacerVisibleScrp(boolean b) {
		scrpContenedor.setVisible(b);
		
	}
	
	
}
