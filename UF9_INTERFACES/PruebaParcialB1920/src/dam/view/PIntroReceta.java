package dam.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import dam.control.RecetarioControl;
import dam.model.Receta;

import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;

public class PIntroReceta extends JPanel {
	private static final int RESTA_ANCHO = VMenuRecetario.ANCHO -15;
	private static final int RESTA_ALTO = VMenuRecetario .ALTO - 70;
	
	public static final String BTN_GUARDAR = "Guardar";
	
	private JTextField txtIntroNom;
	private JTextField txtDesc;
	private JSpinner spnTiempo;
	private JComboBox <String> cmbDificultad;
	private JButton btnGuardar;
	
	public PIntroReceta() {
		setLayout(null);
				
		JLabel lblNueva = new JLabel("NUEVA RECETA ");
		lblNueva.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNueva.setBounds(316, 47, 153, 22);
		add(lblNueva);
		
		JLabel lblNom = new JLabel("Nombre");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNom.setBounds(67, 123, 71, 13);
		add(lblNom);
		
		txtIntroNom = new JTextField();
		txtIntroNom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtIntroNom.setBounds(178, 116, 429, 27);
		add(txtIntroNom);
		txtIntroNom.setColumns(10);
		
		JLabel lblDesc = new JLabel("Descripci\u00F3n");
		lblDesc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDesc.setBounds(67, 166, 90, 13);
		add(lblDesc);
		
		txtDesc = new JTextField();
		txtDesc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDesc.setBounds(178, 166, 429, 159);
		add(txtDesc);
		txtDesc.setColumns(10);
		
		spnTiempo = new JSpinner();
		spnTiempo.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(4)));
		spnTiempo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		spnTiempo.setBounds(179, 350, 115, 27);
		add(spnTiempo);
		
		JLabel lblTiempo = new JLabel("<html>Tiempo de <br> ejecución</html>\"");
		lblTiempo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTiempo.setBounds(67, 337, 90, 40);
		add(lblTiempo);
		
		cmbDificultad = new JComboBox<String>();
		cmbDificultad.setModel(new DefaultComboBoxModel<String>(new String[] {"Alta", "Media", "Baja"}));
		cmbDificultad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cmbDificultad.setBounds(460, 350, 115, 26);
		add(cmbDificultad);
		
		JLabel lblDificultad = new JLabel("Dificultad");
		lblDificultad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDificultad.setBounds(370, 357, 80, 13);
		add(lblDificultad);
		
		btnGuardar = new JButton(BTN_GUARDAR);
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnGuardar.setBounds(331, 408, 119, 27);
		add(btnGuardar);
		
		setSize(RESTA_ANCHO, RESTA_ALTO);
	}

	
	public void setControlador(RecetarioControl c) {
		btnGuardar.addActionListener(c);
		
	}

	public void limpiarComponentes() {
		txtIntroNom.setText("");
		txtDesc.setText("");
		spnTiempo.setValue(0);
		cmbDificultad.setSelectedIndex(0);
		
	}


	public Receta obetenerReceta() {
		Receta r = null;
		
		String nombre = txtIntroNom.getText().trim();
		
		if (nombre.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Debes introducir un nombre", 
					"Error de datos", JOptionPane.ERROR_MESSAGE);
			
		}else {
			String desc = txtDesc.getText().trim();
			
			int tiempo = (int) spnTiempo.getValue();
			
			String dificultad = cmbDificultad.getSelectedItem().toString();
			
			r = new Receta(nombre, desc, tiempo, dificultad);
		}
		
		return r;
	}

	
	
}
