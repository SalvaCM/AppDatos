package alojamientos.appdatosA;

import java.io.BufferedInputStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import javax.net.ssl.SSLHandshakeException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class CargaXml {

	RecursoXml recursoXml = new RecursoXml();
	String ruta = "archivos/";
	String rutaTemp = "archivos/temp/";
	GestorArchivos gestor = new GestorArchivos();
	
	public CargaXml() {

	}
	
	// Gestiona la carga de archivos,los descarga a temporales, y procede a
	// compararlos y decidir cual se elimina, y si se descarga o no.
	public boolean gestionXML() {
		int contador=0;
		boolean descargar = false; // con los try and catch ponemos el false si la descarga no ha ido bien
		for (int i = 0; i < recursoXml.recursos.size(); i++) {
			if (gestor.exitenArchivos(recursoXml.recursos.get(i).archivoXml)) {
				descargaXml(rutaTemp, recursoXml.recursos.get(i).archivoXml, recursoXml.recursos.get(i).getUrl());
				
				if (gestor.comparar(rutaTemp + recursoXml.recursos.get(i).archivoXml,ruta + recursoXml.recursos.get(i).archivoXml)) {
					
					gestor.borrarFichero(recursoXml.recursos.get(i).archivoXml, rutaTemp);
					recursoXml.recursos.get(i).setDescargar(false);
				} else {
					gestor.borrarFichero(recursoXml.recursos.get(i).archivoXml, ruta);
					gestor.moverFichero(recursoXml.recursos.get(i).archivoXml);
					recursoXml.recursos.get(i).setDescargar(true);
					contador++;
				}
			} else {
				descargaXml(ruta, recursoXml.recursos.get(i).archivoXml, recursoXml.recursos.get(i).getUrl());
				recursoXml.recursos.get(i).setDescargar(true);
				contador++;
			}
		}
		if (contador>0) {
			descargar = true;
		}
		return descargar;
	}

	public void descargaXml(String ruta, String nombre, String url) {

		try {
			downloadUsingStream(url, ruta + nombre);
		} catch (FileNotFoundException e) { // por si la ruta de guardar el fichero esta mal
			System.out.println("Error : la ruta donde quieres guardar el fichero no existe");
		} catch (SSLHandshakeException e) {// por si da fallo con el certificado de la pagina
			System.out.println("Error :  autetificacion no encontrada, por favor resive si lo tiene bien");
		} catch (UnknownHostException e1) {	// por si el link de descarga esta mal escrita o no existe
			System.out.println("Error : enlace de descarga del fichero no encotrado");// por si da algun otro fallo de input/output generico
		} catch (IOException e2) {
			System.out.println("Error : " + e2);
		}
	}

	private void downloadUsingStream(String urlStr, String file) throws IOException {
		URL url = new URL(urlStr);
		BufferedInputStream bis = new BufferedInputStream(url.openStream());
		FileOutputStream fis = new FileOutputStream(file);
		byte[] buffer = new byte[1024];
		int count = 0;
		while ((count = bis.read(buffer, 0, 1024)) != -1) {
			fis.write(buffer, 0, count);
		}
		fis.close();
		bis.close();
		System.out.println("Archivo descargado");
	}

	public boolean leerXml(String ruta) {

		try {

			File fXmlFile = new File(ruta);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			NodeList nList = doc.getElementsByTagName("row");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					@SuppressWarnings("unused")
					Element eElement = (Element) nNode;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			return false;
		}
		return true;
	}

	public ArrayList<Alojamientos> guardarDatosAlojamientos(String ruta, ArrayList<Alojamientos> listaAlojamientos) {

		try {

			File fXmlFile = new File(ruta);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("row");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				// System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					Alojamientos alojamiento = new Alojamientos();
					alojamiento.setCodAlojamiento(App.codigoAlojamiento);
					try {
						alojamiento.setDescripcion(
								eElement.getElementsByTagName("turismdescription").item(0).getTextContent());

					} catch (NullPointerException e1) {
						alojamiento.setDescripcion("Descripcion no disponible");
					}
					try {
						alojamiento.setNombre(eElement.getElementsByTagName("documentname").item(0).getTextContent());

					} catch (NullPointerException e1) {

						alojamiento.setNombre("Nombre no disponible");
					}
					try {
						alojamiento.setLocalizacion(
								eElement.getElementsByTagName("municipality").item(0).getTextContent());

					} catch (NullPointerException e1) {
						alojamiento.setLocalizacion("Localizacion no disponible");
					}
					try {
						alojamiento.setTelefono(eElement.getElementsByTagName("phone").item(0).getTextContent());
					} catch (NullPointerException e1) {
						alojamiento.setTelefono("Telefono no disponible");
					}
					try {

						alojamiento.setDireccion(eElement.getElementsByTagName("address").item(0).getTextContent());
					} catch (NullPointerException e1) {

						alojamiento.setDireccion("Direccion no disponible");
					}
					try {
						alojamiento.setLocalidad(eElement.getElementsByTagName("territory").item(0).getTextContent());

					} catch (NullPointerException e1) {
						alojamiento.setLocalidad("Localidad no disponibles");
					}
					try {
						alojamiento.setEmail(eElement.getElementsByTagName("tourismemail").item(0).getTextContent());

					} catch (NullPointerException e1) {
						alojamiento.setEmail(" Correo no disponible");
					}
					try {
						alojamiento.setWeb(eElement.getElementsByTagName("web").item(0).getTextContent());

					} catch (NullPointerException e1) {
						alojamiento.setWeb(" Web no disponibles");
					}
					try {
						alojamiento.setCapacidad(
								Integer.valueOf(eElement.getElementsByTagName("capacity").item(0).getTextContent()));

					} catch (NullPointerException e1) {
						alojamiento.setCapacidad(0);
					}
					try {
						alojamiento.setLatitud(eElement.getElementsByTagName("latwgs84").item(0).getTextContent());

					} catch (NullPointerException e1) {
						alojamiento.setLatitud("Latitud no disponible");
					}
					try {
						alojamiento.setLongitud(eElement.getElementsByTagName("lonwgs84").item(0).getTextContent());

					} catch (NullPointerException e1) {
						alojamiento.setLongitud("Longitud no disponible");
					}
					System.out.println(App.codigoAlojamiento);
					App.codigoAlojamiento++;
					listaAlojamientos.add(alojamiento);
					
					
					
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}

		return listaAlojamientos;
	}

}
