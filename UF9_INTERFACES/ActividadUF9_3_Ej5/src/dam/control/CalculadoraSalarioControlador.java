package dam.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dam.model.Salario;
import dam.view.VCalculadoraSalario;

public class CalculadoraSalarioControlador implements ActionListener {
	VCalculadoraSalario ventana;
	
	public CalculadoraSalarioControlador (VCalculadoraSalario ventana) {
		this.ventana = ventana;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Salario salSemanal = ventana.obteneDato();
		
		if (salSemanal != null) {
			int sal = salSemanal.calcularSalarioSem();
			String res = String.valueOf(sal);
			ventana.mostrarResultado(res);
		}
		
	}

}
