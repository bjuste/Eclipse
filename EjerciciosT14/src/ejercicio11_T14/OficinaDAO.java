package ejercicio11_T14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OficinaDAO {
	private OficinaDAO oficinaDAO;
	Connection conexion;
	
	public OficinaDAO() {
		conexion = conectar();
	}
	
	private Connection conectar() {
	
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Empresa","bruno","1234");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return con;
		
	}
	
	public List<Oficina> cargarTodasLasOficinas() {
        List<Oficina> listaOficinas = new ArrayList<>();
        PreparedStatement sentencia = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM Oficinas";
            sentencia = conexion.prepareStatement(sql);
            rs = sentencia.executeQuery();

            while (rs.next()) {
                int oficina = rs.getInt("oficina");
                String ciudad = rs.getString("ciudad");
                int superficie = rs.getInt("superficie");
                double ventas = rs.getDouble("ventas");

                Oficina nuevaOficina = new Oficina(oficina, ciudad, superficie, ventas);
                listaOficinas.add(nuevaOficina);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaOficinas;
    }
	
	public List<Oficina> cargarOficinas() {
        List<Oficina> listaOficinas = new ArrayList<>();
        PreparedStatement sentencia = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM Oficinas";
            sentencia = conexion.prepareStatement(sql);

            rs = sentencia.executeQuery();

            while (rs.next()) {
                int oficina = rs.getInt("oficina");
                String ciudad = rs.getString("ciudad");
                int superficie = rs.getInt("superficie");
                double ventas = rs.getDouble("ventas");

                Oficina nuevaOficina = new Oficina(oficina, ciudad, superficie, ventas);
                listaOficinas.add(nuevaOficina);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaOficinas;
	}
	
	public List<Oficina> cargarOficinasNombre(String ciudadOficina) {
        List<Oficina> listaOficinas = new ArrayList<>();
        PreparedStatement sentencia = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM Oficinas where ciudad = ?";
            sentencia = conexion.prepareStatement(sql);

            sentencia.setString(1, ciudadOficina);
            rs = sentencia.executeQuery();

            while (rs.next()) {
                int oficina = rs.getInt("oficina");
                String ciudad = rs.getString("ciudad");
                int superficie = rs.getInt("superficie");
                double ventas = rs.getDouble("ventas");

                Oficina nuevaOficina = new Oficina(oficina, ciudad, superficie, ventas);
                listaOficinas.add(nuevaOficina);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaOficinas;
	}
	
	public boolean existeOficina(int numeroOficina) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT COUNT(*) AS count FROM Oficinas WHERE oficina = ?";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, numeroOficina);

            rs = ps.executeQuery();

            if (rs.next()) {
                int count = rs.getInt("count");
                return count > 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
	
	public List<Oficina> cargarOficinasPorSuperficie(int superficieMinima) {
        List<Oficina> listaOficinas = new ArrayList<>();
        PreparedStatement sentencia = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM Oficinas WHERE superficie > ?";
            sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1, superficieMinima);
            rs = sentencia.executeQuery();

            while (rs.next()) {
                int oficina = rs.getInt("oficina");
                String ciudad = rs.getString("ciudad");
                int superficie = rs.getInt("superficie");
                double ventas = rs.getDouble("ventas");

                Oficina nuevaOficina = new Oficina(oficina, ciudad, superficie, ventas);
                listaOficinas.add(nuevaOficina);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaOficinas;
    }
	
	public void update(int numOficina, String nuevaCiudad, double incrementoVentas) {
        PreparedStatement sentencia = null;

        try {
            String sql = "UPDATE Oficinas SET ciudad = ?, ventas = ventas + ? WHERE oficina = ?";
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, nuevaCiudad);
            sentencia.setDouble(2, incrementoVentas);
            sentencia.setInt(3, numOficina);

            int filasAfectadas = sentencia.executeUpdate();
            System.out.println("Se ha actualizado la oficina correctamente. Filas afectadas: " + filasAfectadas);
        } catch (SQLException ex) {
            System.out.println("Error al actualizar la oficina.");
            ex.printStackTrace();
        } finally {
            try {
                if (sentencia != null) {
                    sentencia.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
	
	public List<Oficina> listarOficinas() {
        List<Oficina> listaOficinas = new ArrayList<>();
        PreparedStatement sentencia = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM Oficinas";
            sentencia = conexion.prepareStatement(sql);
            rs = sentencia.executeQuery();

            while (rs.next()) {
                int oficina = rs.getInt("oficina");
                String ciudad = rs.getString("ciudad");
                int superficie = rs.getInt("superficie");
                double ventas = rs.getDouble("ventas");

                Oficina nuevaOficina = new Oficina(oficina, ciudad, superficie, ventas);
                listaOficinas.add(nuevaOficina);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return listaOficinas;
    }
	
}
