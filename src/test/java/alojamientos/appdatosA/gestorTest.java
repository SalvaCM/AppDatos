package alojamientos.appdatosA;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

public class gestorTest  {
	GestorArchivos gestor = new GestorArchivos();
	CargaXml xml = new CargaXml();
	DatosXml datos = new DatosXml();
	@Test
	public void borrarFicheroTest() { // Probar con before y after
		boolean borrado;
		borrado = gestor.borrarFichero(datos.getArchivo1(),"archivos/");
		assertTrue(borrado);

	}
	@Test
	public void borrarFicheroTest2() { // Probar con before y after
		boolean noBorrado;
		noBorrado = gestor.borrarFichero("Inexistente","archivos/");

		assertFalse(noBorrado);
		
	}
	@After
	public void borrarFicheroTest3() // Probar con before y after
	{
		xml.descargaXml("archivos/", datos.getArchivo1(), datos.getUrl1());
	}
/*
	@Test
	public void comparar() {
		boolean iguales1,iguales2,iguales3;
		iguales1 = gestor.comparar("archivos/apartamentos.xml","archivos/apartamentos.xml");
		iguales2 = gestor.comparar("archivos/apartamentos.xml","archivos/apartamentos-rulares.xml");
		iguales3 =  gestor.comparar("archivos/apartamentos-camping.xml","archivos/apartamentos-camping.xml");
		
		assertTrue(iguales1);
		assertFalse(iguales2);
		assertTrue(iguales3);
	}
	@Test
	public void existeFicheroTest() {
		boolean existe1,existe2;
		existe1 = gestor.exitenArchivos("apartamentos-camping.xml");
		existe2 = gestor.exitenArchivos("inexistente.xml");
		
		assertTrue(existe1);
		assertFalse(existe2);
		
	}
	@Test
	public void moverFicheroTest() {
		boolean movido1,movido2;
		movido1 = gestor.moverFichero("apartamentos-camping.xml");
		movido2 = gestor.exitenArchivos("inexistente.xml");
		
		assertTrue(movido1);
		assertFalse(movido2);
	}*/
}
