package dam.view;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

import dam.control.CalculadoraSalarioControlador;
import dam.model.Salario;

import javax.swing.JButton;

/*	Crea el siguiente programa en JAVA con interfaz gráfica. 
 * 	Un obrero necesita calcular su salario semanal, el cual se obtiene de la siguiente manera: 
 * 		-Si trabaja 40 horas o menos se le paga 16€ por hora 
		-Si trabaja más de 40 horas se le paga 16€ por cada una de las primeras 40 horas 
		 y 20€ por cada hora extra.
 */
 
public class VCalculadoraSalario extends JFrame {
	private JTextField txtHoras;
	private JLabel lblSEur;
	private JButton btnCalcular;
	private JTextField txtSalario;
	private JLabel lblResSal;
	private JLabel lblWarning;
	public VCalculadoraSalario() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Calculadora Salario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("CALCULA TU SUELDO");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setBounds(123, 40, 189, 13);
		getContentPane().add(lblTitulo);
		
		JLabel lblIntro = new JLabel("<html>Introduce el n\u00FAmero de <br> horas que trabajas a la semana </html>");
		lblIntro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIntro.setBounds(53, 85, 177, 51);
		getContentPane().add(lblIntro);
		
		txtHoras = new JTextField();
		txtHoras.setBounds(238, 92, 96, 19);
		getContentPane().add(txtHoras);
		txtHoras.setColumns(10);
		
		lblSEur = new JLabel("\u20AC");
		lblSEur.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSEur.setBounds(344, 199, 45, 13);
		getContentPane().add(lblSEur);
		
		btnCalcular = new JButton("CALCULAR");
		btnCalcular.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCalcular.setBounds(164, 146, 108, 31);
		getContentPane().add(btnCalcular);
		
		txtSalario = new JTextField();
		txtSalario.setBounds(238, 198, 96, 19);
		getContentPane().add(txtSalario);
		
		txtSalario.setColumns(10);
		txtSalario.setEditable(false);
		txtSalario.setEnabled(false);
		txtSalario.setDisabledTextColor(new Color(0, 0, 0));
		txtSalario.setBackground(new Color(255, 255, 255));

		
		lblResSal = new JLabel("Tu salario semanal");
		lblResSal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblResSal.setBounds(53, 204, 137, 13);
		getContentPane().add(lblResSal);
		
		lblWarning = new JLabel("");
		lblWarning.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblWarning.setBounds(110, 240, 214, 13);
		getContentPane().add(lblWarning);
		
		setSize(450, 300);
		setLocationRelativeTo(null);
	}
	
	public void hacerVisible() {
		setVisible(true);
	}
	
	public void setControlador(CalculadoraSalarioControlador controlador) {
		btnCalcular.addActionListener(controlador);
	}

	public Salario obteneDato() {
		Salario horasSem = null;
		
		try {
			lblWarning.setText("");
			int horasS = Integer.parseInt(txtHoras.getText());
			
			if (horasS < 0) {
				throw new NumberFormatException();
			}
			
			horasSem = new Salario(horasS);
		} catch (NumberFormatException e) {
			mostrarError("El valor debe ser entero y positivo");
		}
		
		return horasSem;
	}

	private void mostrarError(String mensaje) {
		lblWarning.setText(mensaje);
		lblWarning.setForeground(Color.RED);
		
	}

	public void mostrarResultado(String salarioSem) {
		txtSalario.setText(salarioSem);
		
	}
}
