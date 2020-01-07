package alojamientos.appdatosA;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class CargaXml {

	public CargaXml(){
		
	}
	
	public void descargaXml() {
		
		String url = "https://opendata.euskadi.eus/contenidos/ds_recursos_turisticos/alojamiento_de_euskadi/opendata/alojamientos.xml";
		String url1 = "https://opendata.euskadi.eus/contenidos/ds_recursos_turisticos/alojamientos_rurales_euskadi/opendata/alojamientos.xml";
        String url2 = "https://opendata.euskadi.eus/contenidos/ds_recursos_turisticos/campings_de_euskadi/opendata/alojamientos.xml";
		String ruta = "archivos/";
        try {
            
            downloadUsingStream(url, ruta+"apartamentos.xml");          
            downloadUsingStream(url1, ruta+"apartamentos-rulares.xml");
            downloadUsingStream(url2,ruta+"apartamentos-camping.xml");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	private void downloadUsingStream(String urlStr, String file) throws IOException{
        URL url = new URL(urlStr);
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        FileOutputStream fis = new FileOutputStream(file);
        byte[] buffer = new byte[1024];
        int count=0;
        while((count = bis.read(buffer,0,1024)) != -1)
        {
            fis.write(buffer, 0, count);
        }
        fis.close();
        bis.close();
        System.out.println("Archivo descargado");
    }
	public void leerXml(String ruta) {
		
		try {

			File fXmlFile = new File(ruta);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
					
			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
					
			NodeList nList = doc.getElementsByTagName("row");
					
			System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {
				
				Node nNode = nList.item(temp);
						
				System.out.println("\nCurrent Element :" + nNode.getNodeName());
						
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					
					Element eElement = (Element) nNode;
					
					System.out.println(" Linea : " + eElement.getAttribute("num"));
					System.out.println(" Pagina web : " + eElement.getElementsByTagName("municipality").item(0).getTextContent());
					

				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		    }
	}
	
	public ArrayList<Alojamientos> guardarDatosAlojamientos(String ruta, ArrayList<Alojamientos>listaAlojamientos) {
		int contador = 0;
		try {
			
			File fXmlFile = new File(ruta);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
					
			doc.getDocumentElement().normalize();

					
			NodeList nList = doc.getElementsByTagName("row");
			

			for (int temp = 0; temp < nList.getLength(); temp++) {
				
				Node nNode = nList.item(temp);
						
				//System.out.println("\nCurrent Element :" + nNode.getNodeName());
						
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					
					
					Element eElement = (Element) nNode;
					Alojamientos alojamiento = new Alojamientos();
					alojamiento.setCodAlojamiento(temp);
					try {
						alojamiento.setDescripcion(eElement.getElementsByTagName("turismdescription").item(0).getTextContent());
						
					}
					catch(NullPointerException e1) {	
						alojamiento.setDescripcion("Descripcion no disponible");
					}
					try {
						alojamiento.setNombre(eElement.getElementsByTagName("documentname").item(0).getTextContent());
						
					}
					catch(NullPointerException e1) {	
						
						alojamiento.setNombre("Nombre no disponible");
					}
					try {
						alojamiento.setLocalizacion(eElement.getElementsByTagName("municipality").item(0).getTextContent());
						
					}
					catch(NullPointerException e1) {	
						alojamiento.setLocalizacion("Localizacion no disponible");
					}
					try {
						alojamiento.setTelefono(eElement.getElementsByTagName("phone").item(0).getTextContent());
					}
					catch(NullPointerException e1) {	
						alojamiento.setTelefono("Telefono no disponible");
					}
					try {
						
						alojamiento.setDireccion(eElement.getElementsByTagName("address").item(0).getTextContent());
					}
					catch(NullPointerException e1) {	
						
						alojamiento.setDireccion("Direccion no disponible");
					}
					try {
						alojamiento.setLocalidad(eElement.getElementsByTagName("territory").item(0).getTextContent());
						
					}
					catch(NullPointerException e1) {	
						alojamiento.setLocalidad("Localidad no disponibles");
					}
					try {
						alojamiento.setEmail(eElement.getElementsByTagName("tourismemail").item(0).getTextContent());
						
					}
					catch(NullPointerException e1) {	
						alojamiento.setEmail(" Correo no disponible");
					}
					try {
						alojamiento.setWeb(eElement.getElementsByTagName("web").item(0).getTextContent());
						
					}
					catch(NullPointerException e1) {	
						alojamiento.setWeb(" Web no disponibles");
					}
					try {
						alojamiento.setCapacidad(Integer.valueOf(eElement.getElementsByTagName("capacity").item(0).getTextContent()));
						
					}
					catch(NullPointerException e1) {	
						alojamiento.setCapacidad(0);
					}
					try {
						alojamiento.setLatitud(eElement.getElementsByTagName("latwgs84").item(0).getTextContent());
						
					}
					catch(NullPointerException e1) {	
						alojamiento.setLatitud("Latitud no disponible");
					}
					try {
						alojamiento.setLongitud(eElement.getElementsByTagName("lonwgs84").item(0).getTextContent());
						
					}
					catch(NullPointerException e1) {	
						alojamiento.setLongitud("Longitud no disponible");
					}
			
					listaAlojamientos.add(alojamiento);

				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		    }
		
		return listaAlojamientos;
	}
	
}
