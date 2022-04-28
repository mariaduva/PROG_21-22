package dam.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dam.control.GestrorCarreraControl;
import dam.model.Corredor;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;

public class PConsC extends JPanel {
	private static final int RESTA_ANCHO = VMenuGestorCarrera.ANCHO -15;
	private static final int RESTA_ALTO = VMenuGestorCarrera.ALTO - 70;
	
	public static final String BTN_CONSULTAR = "Consultar";
	public static final String RDBTN_HOMBRE = "Hombres";
	public static final String RDBTN_MUJER = "Mujeres";
	public static final String RDBTN_TODOS = "Todos";
	
	private JTable tblCorredores;
	private final ButtonGroup btngrpSexo = new ButtonGroup();
	private JScrollPane scrpTabla;
	private JRadioButton rdbtnHombre;
	private JRadioButton rdbtnMujer;
	private JRadioButton rdbtnTodos;
	private JButton btnConsultar;
	private DefaultTableModel tModel;
	
	public PConsC() {
		init();
	}

	private void init() {
		setLayout(null);
		
		setSize(RESTA_ANCHO, RESTA_ALTO);
		
		scrpTabla = new JScrollPane();
		scrpTabla.setVisible(false);
		scrpTabla.setBounds(48, 115, 688, 362);
		add(scrpTabla);
		
		tblCorredores = new JTable();
		configurarTabla();
		tblCorredores.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrpTabla.setViewportView(tblCorredores);
		
		JLabel lblNewLabel = new JLabel("Listado de corredores");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(48, 39, 218, 20);
		add(lblNewLabel);
		
		rdbtnHombre = new JRadioButton(RDBTN_HOMBRE);
		rdbtnHombre.setSelected(true);
		btngrpSexo.add(rdbtnHombre);
		rdbtnHombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnHombre.setBounds(48, 79, 103, 21);
		add(rdbtnHombre);
		
		rdbtnMujer = new JRadioButton(RDBTN_MUJER);
		btngrpSexo.add(rdbtnMujer);
		rdbtnMujer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnMujer.setBounds(199, 79, 103, 21);
		add(rdbtnMujer);
		
		rdbtnTodos = new JRadioButton(RDBTN_TODOS);
		btngrpSexo.add(rdbtnTodos);
		rdbtnTodos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnTodos.setBounds(355, 79, 103, 21);
		add(rdbtnTodos);
		
		btnConsultar = new JButton(BTN_CONSULTAR);
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnConsultar.setBounds(596, 76, 140, 26);
		add(btnConsultar);
	}

	private void configurarTabla() {
		tModel = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		tblCorredores.setModel(tModel);
		
		tModel.addColumn("NOMBRE");
		tModel.addColumn("DORSAL");
		tModel.addColumn("SEXO");
		tModel.addColumn("EDAD");
		tModel.addColumn("MODALIDAD");
		
		tblCorredores.getColumn("NOMBRE").setPreferredWidth(75);
		tblCorredores.getColumn("DORSAL").setPreferredWidth(75);
		tblCorredores.getColumn("SEXO").setPreferredWidth(75);
		tblCorredores.getColumn("EDAD").setPreferredWidth(75);
		tblCorredores.getColumn("MODALIDAD").setPreferredWidth(75);
				
	}
	
	public void rellenarTabla(ArrayList<Corredor> listaCorredores) {
		tModel.getDataVector().clear();
		
		Object[] fila = new Object[5];
		
		for (Corredor c : listaCorredores) {
			fila[0] = c.getNombre();
			fila[1] = c.getDorsal();
			fila[2] = c.getSexo();
			fila[3] = c.getEdad();
			fila[4] = c.getModalidad();
			
			tModel.addRow(fila);
		}
	}

	public void setControlador(GestrorCarreraControl c) {
		btnConsultar.addActionListener(c);
		rdbtnHombre.addActionListener(c);
		rdbtnMujer.addActionListener(c);
		rdbtnTodos.addActionListener(c);
	}

	public void hacerVisibleScrp(boolean b) {
		scrpTabla.setVisible(b);
	}

	public void borrarTabla() {
		tModel.setRowCount(0);
	}
}
