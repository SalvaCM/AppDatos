package alojamientos.appdatosA;

public class App {
	public static final String ANSI_GREEN  = "\u001B[32m";


	@SuppressWarnings("unused")
	public static void main(String[] args) {
		App runApp = new App();

	}

	public App() {
		System.out.println("# Iniciando App #");
			IniciarSession iniciarSesion = new IniciarSession();
			boolean correcto = iniciarSesion.Iniciar();
			if (correcto)
			{
				System.err.println("INFO : La BBDD se ha actualizado");
			}
			else
			{
				System.err.println("INFO : Error al actualizar la BD");
			}
	}
}
