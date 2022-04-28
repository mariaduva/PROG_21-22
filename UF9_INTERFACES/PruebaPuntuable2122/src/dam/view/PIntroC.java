package dam.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import dam.control.GestrorCarreraControl;
import dam.model.Corredor;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class PIntroC extends JPanel {
	private static final int RESTA_ANCHO = VMenuGestorCarrera.ANCHO -15;
	private static final int RESTA_ALTO = VMenuGestorCarrera.ALTO - 70;
	
	public static final String BTN_GUARDAR = "Guardar";
	public static final String BTN_LIMPIAR = "Limpiar";
	
	private JTextField txtIntroNom;
	private JTextField txtIntroDorsal;
	private final ButtonGroup btngrpSexo = new ButtonGroup();
	private JRadioButton rdbtnHombre;
	private JRadioButton rdbtnMujer;
	private JComboBox <String> cmbxModalidad;
	private JButton btnGuardar;
	private JButton btnLimpiar;
	private JSpinner spnEdad;
	
	public PIntroC() {
		init();
	}

	private void init() {
		setLayout(null);
		
		setSize(RESTA_ANCHO, RESTA_ALTO);
		
		JLabel lblDatosP = new JLabel("Datos del participante");
		lblDatosP.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblDatosP.setBounds(50, 78, 213, 26);
		add(lblDatosP);
		
		JLabel lblNom = new JLabel("Nombre");
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNom.setBounds(50, 174, 81, 18);
		add(lblNom);
		
		txtIntroNom = new JTextField();
		txtIntroNom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtIntroNom.setBounds(172, 171, 264, 26);
		add(txtIntroNom);
		txtIntroNom.setColumns(10);
		
		JLabel lblDorsal = new JLabel("Dorsal");
		lblDorsal.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDorsal.setBounds(456, 174, 62, 18);
		add(lblDorsal);
		
		txtIntroDorsal = new JTextField();
		txtIntroDorsal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtIntroDorsal.setBounds(528, 171, 142, 26);
		add(txtIntroDorsal);
		txtIntroDorsal.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSexo.setBounds(50, 249, 62, 18);
		add(lblSexo);
		
		rdbtnHombre = new JRadioButton("Hombre");
		rdbtnHombre.setSelected(true);
		btngrpSexo.add(rdbtnHombre);
		rdbtnHombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnHombre.setBounds(172, 249, 103, 21);
		add(rdbtnHombre);
		
		rdbtnMujer = new JRadioButton("Mujer");
		btngrpSexo.add(rdbtnMujer);
		rdbtnMujer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnMujer.setBounds(302, 249, 103, 21);
		add(rdbtnMujer);
		
		JLabel lblModalidad = new JLabel("Modalidad");
		lblModalidad.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblModalidad.setBounds(50, 321, 91, 18);
		add(lblModalidad);
		
		cmbxModalidad = new JComboBox<String>();
		cmbxModalidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cmbxModalidad.setModel(new DefaultComboBoxModel<String>(new String[] {"10000", "Medio Marat\u00F3n", "Marat\u00F3n"}));
		cmbxModalidad.setBounds(172, 316, 159, 31);
		add(cmbxModalidad);
		
		btnGuardar = new JButton(BTN_GUARDAR);
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnGuardar.setBounds(214, 395, 137, 31);
		add(btnGuardar);
		
		btnLimpiar = new JButton(BTN_LIMPIAR);
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLimpiar.setBounds(409, 395, 137, 31);
		add(btnLimpiar);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEdad.setBounds(456, 249, 62, 18);
		add(lblEdad);
		
		spnEdad = new JSpinner();
		spnEdad.setModel(new SpinnerNumberModel(0, 0, 120, 1));
		spnEdad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		spnEdad.setBounds(528, 246, 142, 26);
		add(spnEdad);
	}

	public void setControlador(GestrorCarreraControl c) {
		btnGuardar.addActionListener(c);
		btnLimpiar.addActionListener(c);
		
	}

	public Corredor obtenerCorredor() {
		Corredor c = null;
		
		String nombre = txtIntroNom.getText().trim();
		
		if(nombre.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Debes introducir un nombre", 
					"Error de datos", JOptionPane.ERROR_MESSAGE);
		} else {
			try {
				int dorsal = Integer.parseInt(txtIntroDorsal.getText().trim());
				String d = Integer.toString(dorsal);
				
				if (d.length() > 5) {
					JOptionPane.showMessageDialog(this, "El número del dorsal no puede contener más de 5 dígitos", 
							"Error de datos", JOptionPane.ERROR_MESSAGE);
				} else {
					String sexo;
					
					if(rdbtnHombre.isSelected()) {
						sexo = rdbtnHombre.getText();
					} else {
						sexo = rdbtnMujer.getText();
					}
					
					int edad = (int) spnEdad.getValue();
					
					String modalidad = cmbxModalidad.getSelectedItem().toString();
					
					c = new Corredor(nombre, dorsal, sexo, edad, modalidad);
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "El número de dorsal invalido", 
						"Error de datos", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		return c;
	}

	public void limpiarComponentes() {
		txtIntroNom.setText("");
		txtIntroDorsal.setText("");
		rdbtnHombre.setSelected(true);
		spnEdad.setValue(0);
		cmbxModalidad.setSelectedIndex(0);
		
	}
}
