package interfazBLAST;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import blast.BlastController;

public class Controlador implements ActionListener {

	private Vista vista;

	public Controlador(Vista v) {
		this.vista = v;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean peticionCorrecta = true;
		float porcentaje = -1;

		if (e.getSource().equals(vista.getButtonBuscar())) {

			if (vista.getComboSecuencia().getSelectedItem() == null || vista.getFieldPorcentaje().getText().isEmpty()) {
				vista.getAreaDeRespuesta().setText("Error: Los campos no son los correctos");
				peticionCorrecta = false;
			} else {
				porcentaje = Float.parseFloat(vista.getFieldPorcentaje().getText());
				if (porcentaje < 0 || porcentaje > 1) {
					vista.getAreaDeRespuesta().setText("Error: El porcentaje no es valido");
					peticionCorrecta = false;
				}

			}
		}

		if (peticionCorrecta) {
			SearchButton(porcentaje);
			
		}
	}

	public void SearchButton(float porcentaje) {
		BlastController bCnt = new BlastController();
		Boolean buscandoProteinas = vista.getProteinas().isSelected();
		char queryType;

		if (buscandoProteinas) {
			queryType = 'p';

		} else {
			queryType = 'n';
		}

		// Añadimos la busqueda realizada anteriormente al comboBox
		String buscado = vista.getComboSecuencia().getSelectedItem().toString();

		// Como primer paso miramos que no haya sido buscado anteriormente (para que no
		// se repita siempre) y añadimos los no buscados
		if (vista.getListaBuscados().indexOf(buscado) == -1) {
			vista.getComboSecuencia().addItem(buscado);
			vista.getListaBuscados().add(buscado);

		}
		
		String elArchivo = vista.getTipoArchivo().getSelectedItem().toString();
		String indiceArchivo = elArchivo +".indexs" ;
		String resultados = null;
		try {
			resultados = bCnt.blastQuery(queryType, elArchivo, indiceArchivo, porcentaje, buscado);	
		}
		catch (Exception exc) {
			System.out.println("Error en la llamada: " + exc.toString());	
			resultados = "No se ha podido buscar en la base de datos";
		}
	
		vista.getAreaDeRespuesta().setText(resultados);
		
	}

}
