package ejercicio11_T14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.mysql.cj.xdevapi.Statement;

public class Main {

	public static void main(String[] args) {
		/*List<Oficina> listaOficinas = new ArrayList<>();*/
		OficinaDAO of = new OficinaDAO();
		EmpleadoDAO empleadoDAO = new EmpleadoDAO();
		Scanner sc = new Scanner(System.in);
        /*List<Empleado> listaEmpleados = new ArrayList<>();*/

		
		/*11*/
		/*try {
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Empresa", "bruno", "1234");
            String sql = "SELECT * FROM Empleados";
            PreparedStatement sentencia = con.prepareStatement(sql);

            ResultSet rs = sentencia.executeQuery();

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
		for (Empleado emp : listaEmpleados) {
            System.out.println(emp);
        }*/
		
		/*12*/
		/*listaOficinas = of.cargarOficinas();
		for (Oficina oficina : listaOficinas) {
            System.out.println(oficina);
        }*/
        
		/*13*/
		/*String ciudad = new Scanner(System.in).nextLine();
		List<Oficina>listaOficinasCiudad = of.cargarOficinasNombre(ciudad);
		for (Oficina oficina : listaOficinasCiudad) {
            System.out.println(oficina);
        }*/

		/*14*/
        /*System.out.println("Introduce la edad mínima: ");
		int edadMinima = sc.nextInt();
        System.out.println("Introduce la edad máxima: ");
        int edadMaxima = sc.nextInt();

        List<Empleado> listaEmpleados = empleadoDAO.cargarEmpleadosPorEdad(edadMinima, edadMaxima);

        if (listaEmpleados.isEmpty()) {
            System.out.println("No se encontraron empleados en el rango de edad especificado.");
        } else {
            System.out.println("Empleados en el rango de edad [" + edadMinima + " - " + edadMaxima + "]:");
            for (Empleado empleado : listaEmpleados) {
                System.out.println("Nombre: " + empleado.getNombre() + ", Edad: " + empleado.getEdad());
            }
        }*/
		
		/*15*//*16*/
		/*System.out.print("Número de empleado: ");
        int numemp = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Edad: ");
        int edad = sc.nextInt();
        System.out.print("Oficina: ");
        int oficina = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Puesto: ");
        String puesto = sc.nextLine();
        Date contrato = new Date(); 
        Empleado nuevoEmpleado = new Empleado(numemp, nombre, edad, oficina, puesto, contrato);
        empleadoDAO.insertarEmpleado(nuevoEmpleado);*/
		
		/*17*/
		/*System.out.print("Número de empleado: ");
        int numemp = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Edad: ");
        int edad = sc.nextInt();
        System.out.print("Oficina: ");
        int oficina = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Puesto: ");
        String puesto = sc.nextLine();
        Date contrato = new Date(); 
        Empleado nuevoEmpleado = new Empleado(numemp, nombre, edad, oficina, puesto, contrato);
        empleadoDAO.insertarEmpleado(nuevoEmpleado);*/
		
		/*18*/
		/*System.out.print("Número de empleado: ");
        int numemp = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Edad: ");
        int edad = sc.nextInt();
        System.out.print("Oficina: ");
        int oficina = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Puesto: ");
        String puesto = sc.nextLine();
        Date contrato = new Date(); 
        Empleado nuevoEmpleado = new Empleado(numemp, nombre, edad, oficina, puesto, contrato);
        empleadoDAO.insertarEmpleadoOficina(nuevoEmpleado);*/
		
		/*19*/
		/*System.out.print("Introduce el número de la oficina actual: ");
        int oficinaActual = sc.nextInt();
        System.out.print("Introduce el número de la nueva oficina: ");
        int nuevaOficina = sc.nextInt();
        System.out.println("Empleados en la oficina " + oficinaActual + " antes del cambio:");
        List<Empleado> empleadosCambio = empleadoDAO.cargarEmpleadosPorOficina(oficinaActual);
        for (Empleado empleado : empleadosCambio) {
            System.out.println(empleado);
        }
        empleadoDAO.cambiarEmpleadosDeOficina(oficinaActual, nuevaOficina);
        System.out.println("Empleados en la nueva oficina " + nuevaOficina + " después del cambio:");
        List<Empleado> empleadosDespuesCambio = empleadoDAO.cargarEmpleadosPorOficina(nuevaOficina);
        for (Empleado empleado : empleadosDespuesCambio) {
            System.out.println(empleado);
        }*/
		/*System.out.print("Introduce el número de la oficina actual: ");
        int oficinaActual = sc.nextInt();
        System.out.print("Introduce el número de la nueva oficina: ");
        int nuevaOficina = sc.nextInt();
        if (!of.existeOficina(oficinaActual)) {
            System.out.println("Error: La oficina actual no existe.");
            return;
        }
        if (!of.existeOficina(nuevaOficina)) {
            System.out.println("Error: La nueva oficina no existe.");
            return;
        }
        System.out.println("Empleados en la oficina " + oficinaActual + " antes del cambio:");
        List<Empleado> empleadosAntes = empleadoDAO.cargarEmpleadosPorOficina(oficinaActual);
        for (Empleado empleado : empleadosAntes) {
            System.out.println(empleado);
        }
        empleadoDAO.cambiarEmpleadosDeOficina(oficinaActual, nuevaOficina);
        System.out.println("Empleados en la nueva oficina " + nuevaOficina + " después del cambio:");
        List<Empleado> empleadosDespues = empleadoDAO.cargarEmpleadosPorOficina(nuevaOficina);
        for (Empleado empleado : empleadosDespues) {
            System.out.println(empleado);
        }*/
		
        /*20*/
		/*System.out.print("Introduce el numero de empleado que quiera eliminar: ");
        int empleadoEliminar = sc.nextInt();
        if (!empleadoDAO.existeEmpleadoPorNumemp(empleadoEliminar)) {
            System.out.println("Error: El empleado no existe.");
            return;
        } else {
            empleadoDAO.delete(empleadoEliminar);
            System.out.println("Empleado eliminado correctamente");
        }*/
		
		/*21*/
		/*System.out.println("Listado de todas las oficinas:");
        List<Oficina> listaOficinas = of.cargarTodasLasOficinas();
        for (Oficina oficina : listaOficinas) {
            System.out.println(oficina);
        }*/
	
		/*22*/
		/*System.out.print("Introduce la superficie mínima: ");
        int superficieMinima = sc.nextInt();
        System.out.println("Oficinas con superficie mayor a " + superficieMinima + ":");
        List<Oficina> oficinasPorSuperficie = of.cargarOficinasPorSuperficie(superficieMinima);
        for (Oficina oficina : oficinasPorSuperficie) {
            System.out.println(oficina);
        }*/
		
		/*23*/
        /*List<Oficina> listaOficinas = of.listarOficinas();
        System.out.println("Lista de Oficinas:");
        for (Oficina oficina : listaOficinas) {
            System.out.println(oficina);
        }
        System.out.print("\nIngrese el número de la oficina que desea modificar: ");
        int numOficina = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Ingrese la nueva ciudad para la oficina: ");
        String nuevaCiudad = sc.nextLine();
        System.out.print("Ingrese el incremento de ventas para la oficina: ");
        double incrementoVentas = sc.nextDouble();
        of.update(numOficina, nuevaCiudad, incrementoVentas);*/
        
     }
}


