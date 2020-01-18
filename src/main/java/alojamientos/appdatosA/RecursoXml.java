package alojamientos.appdatosA;

import java.util.ArrayList;

public class RecursoXml {
	String url;
	String archivoXml;
	Boolean descargar;
	ArrayList<RecursoXml> recursos = new ArrayList<RecursoXml>();
	DatosXml datos = new DatosXml();
	String tipo;

	public RecursoXml() {
		Recursos();
	}
	public RecursoXml(String url, String archivoXml, Boolean descargar,String tipo) {
		super();
		this.url = url;
		this.archivoXml = archivoXml;
		this.descargar = descargar;
		this.tipo = tipo;
		
	}
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getArchivoXml() {
		return archivoXml;
	}
	public void setArchivoXml(String archivoXml) {
		this.archivoXml = archivoXml;
	}
	public Boolean getDescargar() {
		return descargar;
	}
	public void setDescargar(Boolean descargar) {
		this.descargar = descargar;
	}
	public void Recursos() {
		RecursoXml recurso1= new RecursoXml(datos.getUrl1(),datos.getArchivo1(), descargar,datos.getTipo1());
		RecursoXml recurso2= new RecursoXml(datos.getUrl2(), datos.getArchivo2(), descargar,datos.getTipo2());
		RecursoXml recurso3= new RecursoXml(datos.getUrl3(), datos.getArchivo3(), descargar,datos.getTipo3());
		recursos.add(recurso1);
		recursos.add(recurso2);
		recursos.add(recurso3);
	}

}
