package alojamientos.appdatosA;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class GestorArchivos {
	String ruta = "archivos/";
	String rutaTemp = "archivos/temp/";

	public boolean comparar(String ruta1, String ruta2) {
		try {
			if (compararBytes(ruta1, ruta2) == true) {
				System.out.println(" > No hay Diferencia");
				return true;
			} else {
				System.out.println(" > Son diferentes");
				return false;
			}
		} catch (IOException e) {
			System.out.println("Error");
			return false;
		}
	}

	public static boolean compararBytes(String ruta1, String ruta2) throws IOException {
		File archivo1 = new File(ruta1);
		File archivo2 = new File(ruta2);
		FileInputStream fis1, fis2;
		if (archivo1.length() == archivo2.length()) {
			fis1 = new FileInputStream(archivo1);
			fis2 = new FileInputStream(archivo2);
			int n = 0;
			byte[] b1;
			byte[] b2;
			while ((n = fis1.available()) > 0) {
				if (n > 80)
					n = 80;
				b1 = new byte[n];
				b2 = new byte[n];
				fis1.read(b1);
				fis2.read(b2);
				if (Arrays.equals(b1, b2) == false) {
					System.out.println(ruta1 + " :\n\n " + new String(b1));
					System.out.println();
					System.out.println(ruta2 + " : \n\n" + new String(b2));
					fis1.close();
					fis2.close();
					return false;
				}
			}
			fis1.close();
			fis2.close();

		} else {
			return false; // Diferente tamaño
		}

		return true;
	}

	public boolean exitenArchivos(String nombreArchivo) {
		File archivo = new File(ruta + nombreArchivo);
		/*File archivo2 = new File(ruta + "apartamentos-rulares.xml");
		File archivo3 = new File(ruta + "apartamentos-camping.xml");*/
		boolean resultado = true;

		if (!archivo.exists()) {
			System.out.println("¡¡No existe el archivo ," + archivo.getName());
			resultado = false;
		}
		else
		{
			System.out.println("¡¡ Existe !!," + archivo.getName());
		}

		return resultado;
	}
	public void moverFichero(String nombreArchivo) {

		File origen = new File(rutaTemp+nombreArchivo);
		File destino = new File(ruta+nombreArchivo);
	
		         try {
		                 InputStream in = new FileInputStream(origen);
		                 OutputStream out = new FileOutputStream(destino);
		                 System.out.println("El archivo" + origen + " se cambió de ubicación correctamente a " + destino);
		                 byte[] buf = new byte[1024];
		                 int len;

		                 while ((len = in.read(buf)) > 0) {
		                         out.write(buf, 0, len);
		                 }

		                 in.close();
		                 out.close();
		         } catch (IOException ioe){
		                 ioe.printStackTrace();
		         }

		       
		         
		}

	public boolean borrarFichero(String nombreArchivo,String ruta1) {
		try {
			System.out.println(ruta1+nombreArchivo);
			File f = new File(ruta1+nombreArchivo); // file to be delete
			
			if (f.delete()) // returns Boolean value
			{
				System.out.println(f.getName() + " borrado!"); // getting and printing the file name
				return true;
			} else {
				System.out.println(f.getName() + " borrado ha fallado");
				return false;

			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
}