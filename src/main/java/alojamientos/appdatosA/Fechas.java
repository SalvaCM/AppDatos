package alojamientos.appdatosA;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Fechas {

	public static Date mostrarFechaActual() {
		Date objDate = new Date(); // 
		String strDateFormat = "dd-MM-aaaa"; 
		@SuppressWarnings("unused")
		SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat); 
		return objDate;
	}
}
