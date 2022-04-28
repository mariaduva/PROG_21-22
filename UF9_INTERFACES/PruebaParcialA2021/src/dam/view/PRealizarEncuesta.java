package dam.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;

import dam.control.EncuestaControlador;
import dam.model.Encuesta;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PRealizarEncuesta extends JPanel {
	private static final int RESTA_ANCHO = VMenuEncuesta.ANCHO -15;
	private static final int RESTA_ALTO = VMenuEncuesta .ALTO - 70;
	
	public static final String BTN_GUARDAR = "Guardar Encuesta";
	public static final String BTN_LIMPIAR = "Limpiar Encuesta";
	
	private final ButtonGroup btngpRgEdad = new ButtonGroup();
	private JRadioButton rdbtnRg517;
	private JRadioButton rdbtnRg1830;
	private JRadioButton rdbtnRg3140;
	private JRadioButton rdbtnRg4165;
	private JRadioButton rdbtnRg65;
	private JComboBox <String>cmbFrec;
	private JCheckBox chckbxJT;
	private JCheckBox chckbxV;
	private JCheckBox chckbxBB;
	private JCheckBox chckbxST;
	private JCheckBox chckbxHL;
	private JButton btnGuardar;
	private JButton btnLimpiar;
	public PRealizarEncuesta() {
		init();
	}

	private void init() {
						
		setSize(RESTA_ANCHO, RESTA_ALTO);
		setLayout(null);
		
		JLabel lblRgEdad = new JLabel("Rango de edad");
		lblRgEdad.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRgEdad.setBounds(61, 78, 136, 23);
		add(lblRgEdad);
		
		rdbtnRg517 = new JRadioButton("5-17");
		btngpRgEdad.add(rdbtnRg517);
		rdbtnRg517.setSelected(true);
		rdbtnRg517.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnRg517.setBounds(217, 79, 70, 21);
		add(rdbtnRg517);
		
		rdbtnRg1830 = new JRadioButton("18-30");
		btngpRgEdad.add(rdbtnRg1830);
		rdbtnRg1830.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnRg1830.setBounds(320, 79, 70, 21);
		add(rdbtnRg1830);
		
		rdbtnRg3140 = new JRadioButton("31-40");
		btngpRgEdad.add(rdbtnRg3140);
		rdbtnRg3140.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnRg3140.setBounds(428, 79, 70, 21);
		add(rdbtnRg3140);
		
		rdbtnRg4165 = new JRadioButton("41-65");
		btngpRgEdad.add(rdbtnRg4165);
		rdbtnRg4165.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnRg4165.setBounds(540, 79, 70, 21);
		add(rdbtnRg4165);
		
		rdbtnRg65 = new JRadioButton("+65");
		btngpRgEdad.add(rdbtnRg65);
		rdbtnRg65.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnRg65.setBounds(660, 79, 70, 21);
		add(rdbtnRg65);
		
		JLabel lblFrec = new JLabel("Frecuencia");
		lblFrec.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFrec.setBounds(61, 162, 99, 23);
		add(lblFrec);
		
		cmbFrec = new JComboBox<String>();
		cmbFrec.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cmbFrec.setModel(new DefaultComboBoxModel<String>(new String[] {"Ninguna", "1 o 2 veces por semana", "3 o 4 veces por semana", "5 o 6 veces por semana", "Todos los d\u00EDas"}));
		cmbFrec.setBounds(215, 158, 220, 31);
		add(cmbFrec);
		
		JLabel lblSeries = new JLabel("Series");
		lblSeries.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSeries.setBounds(469, 162, 64, 23);
		add(lblSeries);
		
		chckbxJT = new JCheckBox("Juego de Tronos");
		chckbxJT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxJT.setBounds(564, 163, 154, 21);
		add(chckbxJT);
		
		chckbxV = new JCheckBox("Vikingos");
		chckbxV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxV.setBounds(741, 163, 93, 21);
		add(chckbxV);
		
		chckbxBB = new JCheckBox("Breaking Bad");
		chckbxBB.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxBB.setBounds(564, 202, 125, 21);
		add(chckbxBB);
		
		chckbxST = new JCheckBox("Stranger Things");
		chckbxST.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxST.setBounds(741, 202, 145, 21);
		add(chckbxST);
		
		chckbxHL = new JCheckBox("HomeLand");
		chckbxHL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxHL.setBounds(564, 243, 109, 21);
		add(chckbxHL);
		
		btnGuardar = new JButton(BTN_GUARDAR);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGuardar.setBounds(516, 320, 173, 31);
		add(btnGuardar);
		
		btnLimpiar = new JButton(BTN_LIMPIAR);
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLimpiar.setBounds(285, 320, 173, 31);
		add(btnLimpiar);
	}

	public void setControlador(EncuestaControlador c) {
		btnGuardar.addActionListener(c);
		btnLimpiar.addActionListener(c);
	}

	public Encuesta obtenerEnc() {
		Encuesta e = null;
		
		String rgEdad = "";
		
		if(rdbtnRg517.isSelected()) {
			rgEdad = rdbtnRg517.getText();
		} else if (rdbtnRg1830.isSelected()) {
			rgEdad = rdbtnRg1830.getText();
		} else if (rdbtnRg3140.isSelected()) {
			rgEdad = rdbtnRg3140.getText();
		} else if (rdbtnRg4165.isSelected()) {
			rgEdad = rdbtnRg4165.getText();
		}else {
			rgEdad = rdbtnRg65.getText();
		}
		
		String frec = cmbFrec.getSelectedItem().toString();
		
		String series = "";
		
		if (chckbxBB.isSelected()) {
			series += chckbxBB.getText();
		}
		
		if (chckbxHL.isSelected()) {
			if (series.isEmpty()) {
				series += chckbxHL.getText();
			} else {
				series += ", " + chckbxHL.getText();
			}
		}
		
		if (chckbxJT.isSelected()) {
			if (series.isEmpty()) {
				series += chckbxJT.getText();
			} else {
				series += ", " + chckbxJT.getText();
			}
		}
		
		if (chckbxST.isSelected()) {
			if (series.isEmpty()) {
				series += chckbxST.getText();
			} else {
				series += ", " + chckbxJT.getText();
			}
		}
		
		if (chckbxV.isSelected()) {
			if(!series.isEmpty()) {
				series += ", ";
			}
			series += chckbxV.getText();
		}
		
		e = new Encuesta(rgEdad, frec, series);
		
		return e;
	}

	public void limpiarComponentes() {
		rdbtnRg517.setSelected(true);
		
		cmbFrec.setSelectedIndex(0);
		
		chckbxBB.setSelected(false);
		chckbxHL.setSelected(false);
		chckbxJT.setSelected(false);
		chckbxST.setSelected(false);
		chckbxV.setSelected(false);
		
	}
}
