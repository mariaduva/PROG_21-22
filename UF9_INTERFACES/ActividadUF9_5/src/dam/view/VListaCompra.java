package dam.view;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.SpinnerNumberModel;

import dam.control.ListaCompraControlador;
import dam.model.ListaCompra;
import dam.model.Producto;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class VListaCompra extends JFrame {
	public static String BTN_ANADIR = "Añadir";
	
	private JTextField txtProducto;
	private JSpinner spnCant;
	private JComboBox <String>cmbUds;
	private JButton btnAnadir;
	private JList <Producto>lstProductos;
	private JLabel lblWarning;
	private ListaCompra listaArticulos;
	
	public VListaCompra() {
		initComponents();
		listaArticulos = new ListaCompra();
	}

	private void initComponents() {
		setTitle("Lista de la compra");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("LISTA DE LA COMPRA");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setBounds(198, 30, 190, 13);
		getContentPane().add(lblTitulo);
		
		JLabel lblIntro = new JLabel("Introduce el nombre del art\u00EDculo, cantidad y unidades");
		lblIntro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIntro.setBounds(54, 71, 337, 13);
		getContentPane().add(lblIntro);
		
		txtProducto = new JTextField();
		txtProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtProducto.setBounds(61, 114, 159, 30);
		getContentPane().add(txtProducto);
		txtProducto.setColumns(10);
		
		spnCant = new JSpinner();
		spnCant.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spnCant.setModel(new SpinnerNumberModel(1, 1, 500, 1));
		spnCant.setBounds(259, 114, 80, 30);
		getContentPane().add(spnCant);
		
		cmbUds = new JComboBox<String>();
		cmbUds.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cmbUds.setModel(new DefaultComboBoxModel<String>(new String[] {"Kg", "G", "L", "Ud"}));
		cmbUds.setBounds(389, 113, 102, 31);
		getContentPane().add(cmbUds);
		
		btnAnadir = new JButton("A\u00F1adir");
		btnAnadir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAnadir.setBounds(250, 180, 85, 30);
		getContentPane().add(btnAnadir);
		
		JLabel lblList = new JLabel("Art\u00EDculos ya a\u00F1adidos");
		lblList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblList.setBounds(54, 275, 139, 13);
		getContentPane().add(lblList);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 319, 458, 185);
		getContentPane().add(scrollPane);
		
		lstProductos = new JList<Producto>();
		lstProductos.setToolTipText("");
		lstProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(lstProductos);
		
		
		lblWarning = new JLabel("");
		lblWarning.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWarning.setBounds(162, 234, 261, 13);
		getContentPane().add(lblWarning);
		
		setSize(600, 600);
		setLocationRelativeTo(null);
	}
	
	
	public void setControlador(ListaCompraControlador controlador) {
		btnAnadir.addActionListener(controlador);
	}

	public void anadirProducto() {
		
		String nomArt = obtenerNomArt();
		
		int cantidad = (int) spnCant.getValue();
		
		String unidades = (String) cmbUds.getSelectedItem();
		
		Producto p = new Producto (nomArt, cantidad, unidades);
		
		listaArticulos.setListado(p);
		
		
		
	}

	private String obtenerNomArt() {
		String nom = "";
		
		try {
			nom = txtProducto.getText();
			if (nom.equals("")) {
				throw new Exception();
			}
		
		} catch (Exception e) {
			mostrarWarning("No se ha introducido el nombre del artículo");
		}
           
		return nom;
	}

	private void mostrarWarning(String error) {
		lblWarning.setText(error);
		lblWarning.setForeground(Color.RED);
	}

	public void hacerVisible() {
		setVisible(true);
		
	}
}
