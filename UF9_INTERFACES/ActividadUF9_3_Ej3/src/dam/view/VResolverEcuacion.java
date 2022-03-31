package dam.view;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

import dam.control.ResolverEcuacionControlador;
import dam.model.Ecuacion2G;

import javax.swing.JButton;

/*	Crea el siguiente programa en JAVA con interfaz gráfica. Escriba un programa 
 * 	que lea los coeficientes a, b y c de una ecuación de segundo grado, y estudie si
 *  tiene o no solución. Si tiene solución las soluciones se mostrarán en la interfaz,
 *  si no la tiene se mostrará en la interfaz un mensaje indicándolo.
 */

public class VResolverEcuacion extends JFrame{
	private JTextField txtA;
	private JTextField txtB;
	private JTextField txtC;
	private JButton btnResolver;
	private JLabel lblResultado;
	public VResolverEcuacion() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Resolver Ecuaci\u00F3n 2do Grado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblIntro = new JLabel("Introduce los t\u00E9rminos de la ecuaci\u00F3n de 2do grado");
		lblIntro.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIntro.setBounds(10, 10, 416, 13);
		getContentPane().add(lblIntro);
		
		txtA = new JTextField();
		txtA.setBounds(28, 54, 50, 27);
		getContentPane().add(txtA);
		txtA.setColumns(10);
		
		JLabel lblA = new JLabel("x^2 +");
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblA.setBounds(88, 59, 50, 13);
		getContentPane().add(lblA);
		
		txtB = new JTextField();
		txtB.setColumns(10);
		txtB.setBounds(148, 52, 50, 29);
		getContentPane().add(txtB);
		
		JLabel lblB = new JLabel("x +");
		lblB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblB.setBounds(205, 59, 38, 13);
		getContentPane().add(lblB);
		
		JLabel lblC = new JLabel("= 0");
		lblC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblC.setBounds(325, 59, 50, 13);
		getContentPane().add(lblC);
		
		txtC = new JTextField();
		txtC.setColumns(10);
		txtC.setBounds(253, 52, 50, 29);
		getContentPane().add(txtC);
		
		btnResolver = new JButton("Resolver");
		btnResolver.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnResolver.setBounds(150, 115, 136, 27);
		getContentPane().add(btnResolver);
		
		lblResultado = new JLabel("");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblResultado.setBounds(69, 162, 285, 13);
		getContentPane().add(lblResultado);
		
		setSize(450, 300);
		setLocationRelativeTo(null);
	}
	
	public void hacerVisible() {
		setVisible(true);
	}
	
	public void setControlador(ResolverEcuacionControlador controlador) {
		btnResolver.addActionListener(controlador);
	}

	public Ecuacion2G obtenerDatos() {
		Ecuacion2G eq = null;
		
		try {
			int a = Integer.parseInt(txtA.getText());
			
			if (a == 0 ) {
				throw  new NumberFormatException();
			}
			
			try {
				int b = Integer.parseInt(txtB.getText());
				
				try {
					int c = Integer.parseInt(txtC.getText());
					
					eq = new Ecuacion2G(a, b, c);
					
				} catch (NumberFormatException e) {
					mostrarError("El término independiente debe ser entero");
				}
				
			} catch (NumberFormatException e) {
				mostrarError("El término de la x debe ser entero");
			}
			
		} catch (NumberFormatException e) {
			mostrarError("El término de la x^2 debe ser entero y distinto de 0");
		}
		
		return eq;
	}

	private void mostrarError(String error) {
		lblResultado.setText(error);
		lblResultado.setForeground(Color.RED);
	}

	public void mostrarResultado(String resultado) {
		lblResultado.setText(resultado);
		lblResultado.setForeground(Color.BLUE);
		
	}
}
