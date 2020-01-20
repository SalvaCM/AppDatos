package alojamientos.appdatosA;

public class App {
	public static int codigoAlojamiento = 0;
	public static final String ANSI_GREEN  = "\u001B[32m";
	public CargaXml xml = new CargaXml();

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		App runApp = new App();

	}

	public App() {
		boolean descargar;
		System.out.println("Cargando........................");
		
		descargar = xml.gestionXML(); // Esto carga los xml comparando si estan o no!
		if (descargar) {
			IniciarSession iniciar = new IniciarSession();
			boolean correcto = iniciar.Iniciar(xml);
			if (correcto)
			{
				System.err.println("INFO : La BBDD se ha actualizado");
			}
			else
			{
				System.err.println("INFO : Error al actualizar la BD");
			}
		} else {
			System.err.println("INFO : No se encontraron campos a actualizar");
		}

	}

}
