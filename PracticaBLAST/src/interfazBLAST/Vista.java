package interfazBLAST;
/*Aqui estarán nuestros componentes de la interfaz, como por ejemplo los botones, el área de respuesta, la caja de texto... 
 * Cada grupo de componentes estarán en un panel diferente para tener una mejor visualización
 */

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Vista extends JPanel {
	private static final long serialVersionUID = 1L;
	private JPanel panelUno, panelDos, panelTres, panelCuatro, panelCinco, PanelSeis;
	private JRadioButton nucleotidos, proteinas;
	private JTextField fieldPorcentaje;
	private JComboBox<String> comboSecuencia, tipoArchivo;
	private JButton buttonBuscar;
	private ButtonGroup buttonGroup;
	private JTextArea areaDeRespuesta;
	private JScrollPane desplazamiento;
	private ArrayList<String> listaBuscados;


	// Creamos los Getters

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JPanel getPanelUno() {
		return panelUno;
	}

	public JPanel getPanelDos() {
		return panelDos;
	}

	public JPanel getPanelTres() {
		return panelTres;
	}

	public JPanel getPanelCuatro() {
		return panelCuatro;
	}

	public JPanel getPanelCinco() {
		return panelCinco;
	}

	public JPanel getPanelSeis() {
		return PanelSeis;
	}

	public JRadioButton getNucleotidos() {
		return nucleotidos;
	}

	public JRadioButton getProteinas() {
		return proteinas;
	}

	public JTextField getFieldPorcentaje() {
		return fieldPorcentaje;
	}

	public JComboBox<String> getComboSecuencia() {
		return comboSecuencia;
	}

	public JComboBox<String> getTipoArchivo() {
		return tipoArchivo;
	}

	public JButton getButtonBuscar() {
		return buttonBuscar;
	}

	public ButtonGroup getButtonGroup() {
		return buttonGroup;
	}

	public JTextArea getAreaDeRespuesta() {
		return areaDeRespuesta;
	}

	public JScrollPane getDesplazamiento() {
		return desplazamiento;
	}

	public ArrayList<String> getListaBuscados() {
		return listaBuscados;
	}

	public Vista() {
		listaBuscados = new ArrayList<String>();


		// Una vez creados los getters, pasamos a la creación del JPanel.
		// PANEL UNO
		JLabel labelSeleccion = new JLabel("Escoja el archivo para comparar");

		// Añadimos al ComboBox los archivos
		tipoArchivo = new JComboBox<String>();
		tipoArchivo.addItem("yeast.aa");
		tipoArchivo.setEditable(false); // No podemos editar el combobox

		panelUno = new JPanel();
		panelUno.add(labelSeleccion);
		panelUno.add(tipoArchivo);
		this.add(panelUno);

		// PANEL DOS
		JLabel labelTipo = new JLabel("Selecciona el tipo");

		// Los nucleótidos estan marcados por defecto
		proteinas = new JRadioButton("Proteinas");
		nucleotidos = new JRadioButton("Nucleótidos");
		proteinas.setSelected(true);
		// Añadimos en el buttonGroup los nucleotidos y las proteinas. (Nunca se pueden
		// elegir los dos a la vez)
		buttonGroup = new ButtonGroup();
		buttonGroup.add(nucleotidos);
		buttonGroup.add(proteinas);

		// Dimensiones del PANEL DOS
		panelDos = new JPanel();
		panelDos.setLayout(new GridLayout(3, 1));
		panelDos.add(labelTipo);
		panelDos.add(nucleotidos);
		panelDos.add(proteinas);
		this.add(panelDos);

		// PANEL TRES
		JLabel labelSecuencia = new JLabel("Escriba la secuencia para compararla: ");
		comboSecuencia = new JComboBox<String>();
		comboSecuencia.setEditable(true);
		panelTres = new JPanel();
		panelTres.add(labelSecuencia);
		panelTres.add(comboSecuencia);
		this.add(panelTres);

		// PANEL CUATRO
		JLabel labelPorcentaje = new JLabel("Indica un porcentaje, entre 0 y 1: ");
		fieldPorcentaje = new JTextField();
		fieldPorcentaje.setEditable(true);
		panelCuatro = new JPanel();
		panelCuatro.setLayout(new GridLayout(1, 2));
		panelCuatro.add(labelPorcentaje);
		panelCuatro.add(fieldPorcentaje);
		this.add(panelCuatro);

		// PANEL CINCO
		panelCinco = new JPanel();
		panelCinco.setLayout(new GridLayout(2, 1));
		buttonBuscar = new JButton("Buscar");
		panelCinco.add(buttonBuscar);
		this.add(panelCinco);
		

		// PANEL SEIS

		areaDeRespuesta = new JTextArea(20, 40);
		areaDeRespuesta.setEditable(false);

		// Barras de desplazamiento

		desplazamiento = new JScrollPane(areaDeRespuesta);
		desplazamiento.setPreferredSize(new Dimension(1000, 550));
		PanelSeis = new JPanel();
		PanelSeis.add(desplazamiento);
		this.add(PanelSeis);

	}

	public void setContentPane() {
		// TODO Auto-generated method stub

	}

}
