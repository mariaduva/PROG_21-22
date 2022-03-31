package dam.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dam.control.ComprobarPIControlador;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

/*	Crea el siguiente programa en JAVA con interfaz gráfica. Deberá tener una ventana con una etiqueta 
 *	en la que se solicite que se introduzca un número, una caja de texto donde introducir dicho número,
 *  un botón “Comprobar” y otra etiqueta en principio vacía. Al pulsar en el botón “Comprobar” aparecerá en 
 *  la segunda etiqueta un mensaje que nos dirá si el número introducido en la caja de texto es par o impar 
 *  o si el dato introducido no es el esperado.
 */

public class VComprobarParImpar extends JFrame {
	private JButton btnComprobar;
	private JLabel lblResultado;
	private JTextField txtNum;
	public VComprobarParImpar() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Comprobar Par o Impar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblIntro = new JLabel("Introduce un n\u00FAmero");
		lblIntro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIntro.setBounds(45, 50, 178, 19);
		getContentPane().add(lblIntro);
		
		txtNum = new JTextField();
		txtNum.setBounds(233, 50, 141, 19);
		getContentPane().add(txtNum);
		txtNum.setColumns(10);
		
		btnComprobar = new JButton("Comprobar Par o Impar");
		btnComprobar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnComprobar.setBounds(102, 119, 223, 25);
		getContentPane().add(btnComprobar);
		
		lblResultado = new JLabel("");
		lblResultado.setBounds(45, 194, 329, 19);
		getContentPane().add(lblResultado);
		
		setSize(450, 300);
		setLocationRelativeTo(null);
	}
	
	public void hacerVisible() {
		setVisible(true);
	}
	
	public void setControlador(ComprobarPIControlador controlador) {
		btnComprobar.addActionListener(controlador);
	}

	public Integer obtenerNumero() {
		Integer num = null;
		
		try {
			num = Integer.parseInt(txtNum.getText());
		} catch (NumberFormatException e) {
			lblResultado.setText("El valor debe ser entero");
			lblResultado.setForeground(Color.RED);
		}		
		return num;
	}

	public void mostrarResultado(String resultado) {
		lblResultado.setText(resultado);
		lblResultado.setForeground(Color.BLUE);
	}
}
