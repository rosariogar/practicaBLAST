package interfazBLAST;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Principal {

	public static void main(String[] args) {
		
		Runnable runnable = new Runnable() {
			public void run() {
				JFrame frame = new JFrame("InterfazBLAST"); // Creamos la ventana, la cual ha sido nombrada como
															// InterfazBLAST

				// Creamos los componentes de la clase vista
				Vista vista = new Vista();

				// Añadimos las funcionalidades a los componentes mediante la clase controlador

				Controlador controlador = new Controlador(vista);
				
				vista.getButtonBuscar().addActionListener(controlador);
				frame.add(vista);
				frame.pack();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);

			}
		};
		SwingUtilities.invokeLater(runnable);

	}
}
