package alojamientos.appdatosA;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Fechas {

	public static Date mostrarFechaActual() {
		 Date objDate = new Date(); // Sistema actual La fecha y la hora se asignan a objDate 
		
	        System.out.println(objDate); 
	        String strDateFormat = "dd-MM-aaaa"; // El formato de fecha está especificado  
	        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat); // La cadena de formato de fecha se pasa como un argumento al objeto  de formato de fecha  System.out.println(objSDF.format(objDate)); 
	    
	        System.out.println(objSDF); 
	        return objDate;
	}
}
