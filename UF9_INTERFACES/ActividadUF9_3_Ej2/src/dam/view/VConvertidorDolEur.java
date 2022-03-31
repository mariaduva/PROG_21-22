package dam.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import dam.control.ConvertidorDEControlador;
import java.awt.Color;
import javax.swing.JButton;
/*	Crea el siguiente programa en JAVA con interfaz gráfica. Deberá contener una etiqueta junto 
 *	a una caja de texto, en dicha caja de texto se podrá introducir una cantidad numérica que 
 *	representará una cantidad en dólares, deberá tener un botón “Convertir” y otra etiqueta junto a 
 *	otra caja de texto donde, al pulsar el botón “Convertir” se calculará el cambio a euros con el 
 *	contenido de la caja de texto de los dólares, y lo escribirá. (1 dólar = 0,91 euros)
 */

public class VConvertidorDolEur extends JFrame {
	private JButton btnConvertir;
	private JTextField txtEuros;
	private JTextField txtDolares;
	private JLabel lblWarning;
	private JLabel lblSimbD;
	private JLabel lblSimbE;
	public VConvertidorDolEur() {
		initComponents();
	}
	private void initComponents() {
		setTitle("Convertidor de dolares a euros ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("CONVERTIDOR DE DOLARES A EUROS");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitle.setBounds(81, 33, 273, 13);
		getContentPane().add(lblTitle);
		
		txtDolares = new JTextField();
		txtDolares.setBounds(184, 78, 146, 19);
		getContentPane().add(txtDolares);
		txtDolares.setColumns(10);
		
		JLabel lblIntroD = new JLabel("Dolares");
		lblIntroD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIntroD.setBounds(106, 79, 76, 13);
		getContentPane().add(lblIntroD);
		
		JLabel lblResEuros = new JLabel("Euros");
		lblResEuros.setOpaque(true);
		lblResEuros.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblResEuros.setBounds(106, 116, 76, 13);
		getContentPane().add(lblResEuros);
		
		txtEuros = new JTextField();
		txtEuros.setColumns(10);
		txtEuros.setBounds(184, 115, 146, 19);
		getContentPane().add(txtEuros);
		txtEuros.setEditable(false);
		txtEuros.setEnabled(false);
		txtEuros.setDisabledTextColor(new Color(0, 0, 0));
		txtEuros.setBackground(new Color(255, 255, 255));
		
		btnConvertir = new JButton("Convertir");
		btnConvertir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConvertir.setBounds(157, 161, 121, 21);
		getContentPane().add(btnConvertir);
		
		lblWarning = new JLabel("");
		lblWarning.setBounds(106, 207, 273, 13);
		getContentPane().add(lblWarning);
		
		lblSimbD = new JLabel("$");
		lblSimbD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSimbD.setBounds(340, 79, 14, 13);
		getContentPane().add(lblSimbD);
		
		lblSimbE = new JLabel("\u20AC");
		lblSimbE.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSimbE.setBounds(340, 118, 14, 13);
		getContentPane().add(lblSimbE);
		
		setSize(450, 300);
		setLocationRelativeTo(null);
	}
	
	public void hacerVisible() {
		setVisible(true);
	}
	
	public void setControlador(ConvertidorDEControlador controlador) {
		btnConvertir.addActionListener(controlador);
	}
	public Double obtenerNumero() {
		
		Double num = null;
		
		try {
			num = Double.parseDouble(txtDolares.getText());
			if (num < 0) {
				throw new NumberFormatException();
			}
			
		} catch (NumberFormatException e) {
			mostrarError("El valor debe ser entero y positivo");
		}		
		return num;

	}
	private void mostrarError(String mensaje) {
		lblWarning.setText(mensaje);
		lblWarning.setForeground(Color.RED);
		
	}
	public void mostrarResultado(String euros) {
	txtEuros.setText(euros);
	}
}
