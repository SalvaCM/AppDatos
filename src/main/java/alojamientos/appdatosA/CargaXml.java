package alojamientos.appdatosA;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.*;
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
        String ruta = "archivos/";
        try {
            
            downloadUsingStream(url, ruta+"apartamentos.xml");
            
            downloadUsingStream(url1, ruta+"apartamentos-rulares.xml");
            
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
}
