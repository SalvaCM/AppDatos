package alojamientos.appdatosA;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class cargaXmlTest {
	CargaXml carga = new CargaXml();
	DatosXml datos = new DatosXml();
	 ArrayList<Alojamientos> listaAlojamientosTest = new ArrayList<Alojamientos>();
	@Before
	public void prepararTest() {
		GestorArchivos gestor = new GestorArchivos();
		gestor.borrarFichero(datos.getArchivo1(), "archivos/");
		 carga.guardarDatosAlojamientos("archivos/"+datos.getArchivo2(), listaAlojamientosTest);
		File file = new File("archivos/"+datos.getArchivo2());

			FileWriter fw = null;
			try {
				fw = new FileWriter(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			BufferedWriter bf = new BufferedWriter(fw);
			try {
				bf.write("<aguita de coco>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	
	@Test
	public void gestionXmlTest() {
		boolean actualizar,noActualizar;
		actualizar = carga.gestionXML();
		noActualizar= carga.gestionXML();
		
		assertTrue(actualizar);
		assertFalse(noActualizar);
		
	}
	@Test
	public void leerXmlTest() {
		
		boolean leerOk,leerNotOk;
		
		leerOk =carga.leerXml("archivos/"+datos.getArchivo3());
		assertTrue(leerOk);
		
		leerNotOk= carga.leerXml("archivos/");
		assertFalse(leerNotOk);
		
	}
	@Test
	public void guardarAlojamientosTest() {
		 ArrayList<Alojamientos> listaAlojamientos = new ArrayList<Alojamientos>();
		 carga.guardarDatosAlojamientos("archivos/"+datos.getArchivo3(), listaAlojamientos);
		 assertSame(listaAlojamientos, listaAlojamientosTest);
		 
	}
}
