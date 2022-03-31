package dam.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import dam.control.ComprobarCapicuaControlador;
import dam.model.Capicua;

import javax.swing.JButton;
import java.awt.Color;

/*	Crea el siguiente programa en JAVA con interfaz gráfica. Realiza un programa que para 
 * 	un número de tres cifras (se debe validar esto) que se introduzca por interfaz, nos 
 * 	diga si el número es o no capicúa.
 */

public class VComprobarCapicua extends JFrame {
	private JTextField txtCapicua;
	private JButton btnComprobar;
	private JLabel lblResultado;
	public VComprobarCapicua() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Comprobar N\u00FAmero Capic\u00FAa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblEsCapicua = new JLabel("\u00BFES CAPIC\u00DAA?");
		lblEsCapicua.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEsCapicua.setBounds(154, 31, 128, 13);
		getContentPane().add(lblEsCapicua);
		
		JLabel lblIntro = new JLabel("Introduce un n\u00FAmero");
		lblIntro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIntro.setBounds(59, 76, 146, 13);
		getContentPane().add(lblIntro);
		
		txtCapicua = new JTextField();
		txtCapicua.setBounds(235, 75, 96, 19);
		getContentPane().add(txtCapicua);
		txtCapicua.setColumns(10);
		
		btnComprobar = new JButton("Comprobar");
		btnComprobar.setForeground(Color.BLUE);
		btnComprobar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnComprobar.setBounds(149, 123, 137, 25);
		getContentPane().add(btnComprobar);
		
		lblResultado = new JLabel("");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblResultado.setBounds(85, 176, 300, 33);
		getContentPane().add(lblResultado);
		
		setSize(450, 300);
		setLocationRelativeTo(null);
	}
	
	public void hacerVisible() {
		setVisible(true);
	}
	
	public void setControlador(ComprobarCapicuaControlador controlador) {
		btnComprobar.addActionListener(controlador);
	}

	public Capicua obtenerDatos() {
		Capicua capi = null;
		
		try {
			int num = Integer.parseInt(txtCapicua.getText());
			
			//if(num > 999 && num < 100)throw new NumberFormatException();
			// TODO solucinar error excepción
			try {
				if(num > 999 && num < 100)throw new NumberFormatException();
			} catch (NumberFormatException e) {
				mostrarError("El número debe ser positivo y tener tres dígitos");
			}
			capi = new Capicua(num);
			
		} catch (NumberFormatException e) {
			mostrarError("El número debe ser un valor entero");
		}
		return capi;
	}

	private void mostrarError(String error) {
		lblResultado.setText(error);
		lblResultado.setForeground(Color.RED);
	}

	public void mostrarResultado(String resultado) {
		lblResultado.setText(resultado);
	}
	
}
