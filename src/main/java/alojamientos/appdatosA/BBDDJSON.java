package alojamientos.appdatosA;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.google.gson.Gson;


public class BBDDJSON {

	public BBDDJSON() {
		
	}
	public void cargaDatosBBDDReservas() {
		try
		{
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   Connection conexion = DriverManager.getConnection ("jdbc:mysql://192.168.101.24/alojamientos?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root", "");
		   String sql = "SELECT * FROM treservas";
		   PreparedStatement stmt = conexion.prepareStatement(sql);
		   ResultSet rs = stmt.executeQuery();
		   PrintWriter writer = new PrintWriter("archivos/reservas.json", "UTF-8");
		   
		   
		   while (rs.next()) {
			   
			   Reservas res = new Reservas();
			   res.setCodAlojamiento(rs.getInt("cCodAlojamiento"));
			   res.setCodReserva(rs.getInt("cReserva"));
			   res.setCodUsuario(rs.getInt("cCodUsuario"));
			   res.setFechaEntrada(rs.getDate("cFechaEntrada"));
			   res.setFechaRealizada(rs.getDate("cFechaRealizada"));
			   res.setFechaSalida(rs.getDate("cFechaSalida"));
			   
			   Gson gson = new Gson();		    
			   String json = gson.toJson(res);
			   writer.println(json);
			   //System.out.println(json);
		   }
		   writer.close();
		   rs.close();
		   stmt.close();
		   conexion.close();
			
		   
		} catch (Exception e){
		   e.printStackTrace();
		}
	}
	public void cargaDatosBBDDUsuarios() {
		try
		{
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   Connection conexion = DriverManager.getConnection ("jdbc:mysql://192.168.101.24/alojamientos?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root", "");
		   String sql = "SELECT * FROM tusuarios";
		   PreparedStatement stmt = conexion.prepareStatement(sql);
		   ResultSet rs = stmt.executeQuery();
		   PrintWriter writer = new PrintWriter("archivos/usuarios.json", "UTF-8");
		   
		   
		   while (rs.next()) {
			   
			   Usuarios us = new Usuarios();
			   us.setDni(rs.getString("cDni"));
			   us.setApellidos(rs.getString("cApellidos"));
			   us.setContrasena(rs.getString("cContrasena"));
			   us.setNombre(rs.getString("cNombre"));
			   us.setTelefono(rs.getInt("cTelefono"));
			   us.setTipoUsuario(rs.getString("cTipoUsuario"));
			   
			   Gson gson = new Gson();		    
			   String json = gson.toJson(us);
			   writer.println(json);
			   //System.out.println(json);
		   }
		   writer.close();
		   rs.close();
		   stmt.close();
		   conexion.close();
			
		   
		} catch (Exception e){
		   e.printStackTrace();
		}
		
	}
	public void cargaDatosBBDDAlojamientos(){
		
		try
		{
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   Connection conexion = DriverManager.getConnection ("jdbc:mysql://192.168.101.24/alojamientos?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root", "");
		   String sql = "SELECT * FROM talojamientos";
		   PreparedStatement stmt = conexion.prepareStatement(sql);
		   ResultSet rs = stmt.executeQuery();
		   PrintWriter writer = new PrintWriter("archivos/alojamientos.json", "UTF-8");
		   
		   
		   while (rs.next()) {
			   
			   Alojamientos al = new Alojamientos();
			   al.setCodAlojamiento(rs.getInt("cCodAlojamiento"));
			   al.setNombre(rs.getString("cNombre"));
		       al.setDescripcion(rs.getString("cDescripcion"));
		       al.setTipo(rs.getString("cTipo"));
		       al.setLocalizacion(rs.getString("cLocalizacion"));
		       al.setTelefono(rs.getString("cTelefono"));
		       al.setDireccion(rs.getString("cDireccion"));
		       al.setLocalidad(rs.getString("cLocalidad"));
		       al.setEmail(rs.getString("cEmail"));
		       al.setWeb(rs.getString("cWeb"));
		       al.setCapacidad(rs.getInt("cCapacidad"));
			   
			   Gson gson = new Gson();		    
			   String json = gson.toJson(al);
			   writer.println(json);
			   //System.out.println(json);
		   }
		   writer.close();
		   rs.close();
		   stmt.close();
		   conexion.close();
			
		   
		} catch (Exception e){
		   e.printStackTrace();
		}
	}	
}
