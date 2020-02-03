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
	public void cargaDatosBBDDAlojamientos() {
		boolean primero = true;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://192.168.101.24/alojamientos?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "");
			String sql = "SELECT * FROM talojamientos";
			PreparedStatement stmt = conexion.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			PrintWriter writer = new PrintWriter("archivos/alojamientos.json", "UTF-8");
			writer.println("[");

			while (rs.next()) {
				if (primero == false) {
					writer.print(",");
				} else {
					primero = false;
				}

				Alojamientos al = new Alojamientos();
				al.setCodAlojamiento(rs.getInt("cCodAlojamiento"));
				al.setNombre(rs.getString("cNombre"));
				al.setDescripcion(rs.getString("cDescripcion"));

				Gson gson = new Gson();
				String json = gson.toJson(al);
				writer.println(json);
				// System.out.println(json);
			}
			writer.println("]");
			writer.close();
			rs.close();
			stmt.close();
			conexion.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
