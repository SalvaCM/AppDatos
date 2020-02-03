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
	int codigoAlojamiento = 0;
	String ruta = "archivos/";
	String rutaTemp = "archivos/temp/";
	GestorArchivos gestor = new GestorArchivos();
	
	public CargaXml() {
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
					alojamiento.setCodAlojamiento(codigoAlojamiento);
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

					System.out.println(codigoAlojamiento);
					codigoAlojamiento++;
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
