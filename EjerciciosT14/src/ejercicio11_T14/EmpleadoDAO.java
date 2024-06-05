package ejercicio11_T14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmpleadoDAO {
	private Connection conexion;
	private OficinaDAO oficinaDAO = new OficinaDAO();

    public EmpleadoDAO() {
        conexion = conectar();
    }

    private Connection conectar() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Empresa", "bruno", "1234");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    
    public void create(Empleado empleado) {
        if (empleado != null) {
            String sql = "INSERT INTO Empleados (numemp, nombre, edad, oficina, puesto, contrato) VALUES (?, ?, ?, ?, ?, ?)";

            try {
                PreparedStatement sentencia = conexion.prepareStatement(sql);
                sentencia.setInt(1, empleado.getNumemp());
                sentencia.setString(2, empleado.getNombre());
                sentencia.setInt(3, empleado.getEdad());
                sentencia.setDate(6, new java.sql.Date(empleado.getContrato().getTime()));
                sentencia.setString(5, empleado.getPuesto());
                sentencia.setInt(4, empleado.getOficina());

                sentencia.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Error al insertar.");
            }
        }
    }
    
    public void delete(int numemp) {
        String sql = "DELETE FROM empleados "
                + "WHERE numemp = ?";
        try {
            PreparedStatement sentencia = conexion.prepareStatement(sql);

            sentencia.setInt(1, numemp); 

            sentencia.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar un empleado.");
        }
    }
    
    /*19*/
    public  void update(Empleado empleado) {
        if (empleado != null) {
            String sql = "UPDATE empleados set nombre=?, edad=?, oficina=?, puesto=?, contrato=? WHERE numemp = ?";
            try {
            	PreparedStatement sentencia = conexion.prepareStatement(sql);
            	
                sentencia.setString(1, empleado.getNombre());
                sentencia.setInt(2, empleado.getEdad());
                sentencia.setInt(3, empleado.getOficina());
                sentencia.setString(4, empleado.getPuesto());
                sentencia.setDate(5, new java.sql.Date(empleado.getContrato().getTime()));
                sentencia.setInt(6, empleado.getNumemp());

                sentencia.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Error al actualizar el empleado.");
            }
        }
    }

    public List<Empleado> cargarEmpleados() {
        List<Empleado> listaEmpleados = new ArrayList<>();
        PreparedStatement sentencia = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM Empleados";
            sentencia = conexion.prepareStatement(sql);

            rs = sentencia.executeQuery();

            while (rs.next()) {
                int numemp = rs.getInt("numemp");
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                int oficina = rs.getInt("oficina");
                String puesto = rs.getString("puesto");
                Date contrato = rs.getDate("contrato");

                Empleado nuevoEmpleado = new Empleado(numemp, nombre, edad, oficina, puesto, contrato);
                listaEmpleados.add(nuevoEmpleado);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } 

        return listaEmpleados;
    }
    
    public List<Empleado> cargarEmpleadosPorEdad(int edadMinima, int edadMaxima) {
        List<Empleado> listaEmpleados = new ArrayList<>();
        PreparedStatement sentencia = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT nombre, edad FROM Empleados WHERE edad >= ? AND edad <= ?";
            sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1, edadMinima);
            sentencia.setInt(2, edadMaxima);

            rs = sentencia.executeQuery();

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");

                Empleado empleado = new Empleado(0, nombre, edad, 0, null, null);
                listaEmpleados.add(empleado);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaEmpleados;
    }
    
    public void insertarEmpleado(Empleado empleado) {
    	
    	if (existeEmpleadoPorNumemp(empleado.getNumemp())) {
            System.out.println("Error: El empleado con número " + empleado.getNumemp() + " ya existe en la base de datos.");
            return;
        }
    	
    	if (!oficinaDAO.existeOficina(empleado.getOficina())) {
            System.out.println("Error: La oficina con número " + empleado.getOficina() + " no existe en la base de datos.");
            return;
        }
    	
        PreparedStatement sentencia = null;

        try {
            String sql = "INSERT INTO Empleados (numemp, nombre, edad, oficina, puesto, contrato) VALUES (?, ?, ?, ?, ?, ?)";
            sentencia = conexion.prepareStatement(sql);

            sentencia.setInt(1, empleado.getNumemp());
            sentencia.setString(2, empleado.getNombre());
            sentencia.setInt(3, empleado.getEdad());
            sentencia.setInt(4, empleado.getOficina());
            sentencia.setString(5, empleado.getPuesto());
            sentencia.setDate(6, new java.sql.Date(empleado.getContrato().getTime()));

            int filasAfectadas = sentencia.executeUpdate();
            System.out.println("Se ha insertado el empleado correctamente. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void insertarEmpleadoOficina(Empleado empleado) {
    	
    	if (!oficinaDAO.existeOficina(empleado.getOficina())) {
            System.out.println("Error: La oficina con número " + empleado.getOficina() + " no existe en la base de datos.");
            return;
        }
    	
        PreparedStatement sentencia = null;

        try {
            String sql = "INSERT INTO Empleados (numemp, nombre, edad, oficina, puesto, contrato) VALUES (?, ?, ?, ?, ?, ?)";
            sentencia = conexion.prepareStatement(sql);

            sentencia.setInt(1, empleado.getNumemp());
            sentencia.setString(2, empleado.getNombre());
            sentencia.setInt(3, empleado.getEdad());
            sentencia.setInt(4, empleado.getOficina());
            sentencia.setString(5, empleado.getPuesto());
            sentencia.setDate(6, new java.sql.Date(empleado.getContrato().getTime()));

            int filasAfectadas = sentencia.executeUpdate();
            System.out.println("Se ha insertado el empleado correctamente. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public boolean existeEmpleadoPorNumemp(int numemp) {
        PreparedStatement sentencia = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT COUNT(*) AS count FROM Empleados WHERE numemp = ?";
            sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1, numemp);

            rs = sentencia.executeQuery();

            if (rs.next()) {
                int count = rs.getInt("count");
                return count > 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    /*19*/
    /*public void cambiarEmpleadosDeOficina(int oficinaActual, int nuevaOficina) {
        PreparedStatement sentencia = null;

        try {
            String sql = "UPDATE Empleados SET oficina = ? WHERE oficina = ?";
            sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1, nuevaOficina);
            sentencia.setInt(2, oficinaActual);

            int filasAfectadas = sentencia.executeUpdate();
            System.out.println("Número de empleados afectados: " + filasAfectadas);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

    
    public List<Empleado> cargarEmpleadosPorOficina(int oficina) {
        List<Empleado> listaEmpleadosOficina = new ArrayList<>();
        PreparedStatement sentencia = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM Empleados WHERE oficina = ?";
            sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1, oficina);

            rs = sentencia.executeQuery();

            while (rs.next()) {
                int numemp = rs.getInt("numemp");
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                int oficinaEmpleado = rs.getInt("oficina");
                String puesto = rs.getString("puesto");
                Date contrato = rs.getDate("contrato");

                Empleado empleado = new Empleado(numemp, nombre, edad, oficinaEmpleado, puesto, contrato);
                listaEmpleadosOficina.add(empleado);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } 

        return listaEmpleadosOficina;
    }
    
    public void cambiarEmpleadosDeOficina(int oficinaActual, int nuevaOficina) {
        List<Empleado> empleados = cargarEmpleadosPorOficina(oficinaActual);

        for (Empleado empleado : empleados) {
            empleado.setOficina(nuevaOficina);
            update(empleado);
        }

        System.out.println("Número de empleados afectados: " + empleados.size());
    }
}
