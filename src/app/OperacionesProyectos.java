package app;

import config.Conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class OperacionesProyectos {
    private Statement st;
    private ResultSet rs;

//    Listado de investigadores por proyecto
    public LinkedList<Investigador> investigadoresXProyectos(int proy_id){
        Connection con = null;
        LinkedList<Investigador> investigadors = new LinkedList<>();

        try{
            con = Conexion.establecerConexion();
            st = con.createStatement();

            rs = st.executeQuery("SELECT inv.* FROM investigadores inv INNER JOIN investigadores_proyectos ip ON inv.inve_id = ip.inve_id WHERE ip.proy_id = " + proy_id);

            Investigador inv = new Investigador();

            while(rs.next()){
                inv.setInveId(rs.getInt("inve_id"));
                inv.setInveArea(rs.getString("inve_area"));
                inv.setInveNombre(rs.getString("inve_nombre"));
                inv.setInveCodigo(rs.getString("inve_codigo"));

                //Agregamos a la lista que vamos a retornar
                investigadors.add(inv);
            }

            return investigadors;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return investigadors;
    }

    // Método para agregar un nuevo proyecto
    public void agregarProyecto(Conexion con, Proyectos proyecto) throws Exception {
        Connection cnn = null;
        String query = null;

        try {
            cnn = con.establecerConexion();
            st = cnn.createStatement();

            query = "INSERT INTO proyectos (proy_id, proy_codigo, proy_nombre, proy_horas_dedicacion, proy_fecha_inicio, proy_fecha_fin, proy_descripcion) VALUES (" +
                    proyecto.getProyId() + ", '" + proyecto.getProyCodigo() + "', '" + proyecto.getProyNombre() + "', '" + proyecto.getProyHorasDedicacion() + "', '" +
                    proyecto.getProyFechaInicio() + "', '" + proyecto.getProyFechaFin() + "', '" + proyecto.getProyDescripcion() + "')";
            st.executeUpdate(query);

            cnn.close();
        } catch (SQLException e) {
            if (cnn != null) {
                cnn.close();
            }
            throw new Exception("Error al agregar el proyecto: " + e.getMessage());
        }
    }

    // Método para actualizar el nombre de un proyecto
    public void actualizarNombreProyecto(Conexion con, int proyId, String nuevoNombre) throws Exception {
        Connection cnn = null;
        String query = null;

        try {
            cnn = con.establecerConexion();
            st = cnn.createStatement();

            query = "UPDATE proyectos SET proy_nombre = '" + nuevoNombre + "' WHERE proy_id = " + proyId;
            st.executeUpdate(query);

            cnn.close();
        } catch (SQLException e) {
            if (cnn != null) {
                cnn.close();
            }
            throw new Exception("Error al actualizar el nombre del proyecto: " + e.getMessage());
        }
    }

    // Método para eliminar un proyecto
    public int eliminarProyecto(Conexion con, int proyId) throws Exception {
        Connection cnn = null;
        int resultado = 0;
        String query = null;

        try {
            cnn = con.establecerConexion();
            st = cnn.createStatement();

            query = "DELETE FROM proyectos WHERE proy_id = " + proyId;
            resultado = st.executeUpdate(query);

            cnn.close();
            return resultado;
        } catch (SQLException e) {
            if (cnn != null) {
                cnn.close();
            }
            throw new Exception("Error al eliminar el proyecto: " + e.getMessage());
        }
    }

    // Método para obtener un proyecto
    public Proyectos obtenerProyecto(Conexion con, int proyId) throws Exception {
        Connection cnn = null;
        Proyectos proyecto = new Proyectos();
        String query = null;

        try {
            cnn = con.establecerConexion();
            st = cnn.createStatement();

            query = "SELECT * FROM proyectos WHERE proy_id = " + proyId;
            rs = st.executeQuery(query);

            if (rs.next()) {
                proyecto.setProyId(rs.getInt("proy_id"));
                proyecto.setProyCodigo(rs.getString("proy_codigo"));
                proyecto.setProyNombre(rs.getString("proy_nombre"));
                proyecto.setProyHorasDedicacion(rs.getString("proy_horas_dedicacion"));
                proyecto.setProyFechaInicio(rs.getString("proy_fecha_inicio"));
                proyecto.setProyFechaFin(rs.getString("proy_fecha_fin"));
                proyecto.setProyDescripcion(rs.getString("proy_descripcion"));
            } else {
                throw new Exception("No se encontró el proyecto con el ID: " + proyId);
            }

            cnn.close();
            return proyecto;
        } catch (SQLException e) {
            if (cnn != null) {
                cnn.close();
            }
            throw new Exception("Error al obtener el proyecto: " + e.getMessage());
        }
    }

    // Método para obtener todos los proyectos
    public LinkedList<Proyectos> obtenerProyectos(Conexion con) throws Exception {
        Connection cnn = null;
        LinkedList<Proyectos> proyectosList = new LinkedList<>();
        String query = null;

        try {
            cnn = con.establecerConexion();
            st = cnn.createStatement();

            query = "SELECT * FROM proyectos";
            rs = st.executeQuery(query);

            while (rs.next()) {
                Proyectos proyecto = new Proyectos();
                proyecto.setProyId(rs.getInt("proy_id"));
                proyecto.setProyCodigo(rs.getString("proy_codigo"));
                proyecto.setProyNombre(rs.getString("proy_nombre"));
                proyecto.setProyHorasDedicacion(rs.getString("proy_horas_dedicacion"));
                proyecto.setProyFechaInicio(rs.getString("proy_fecha_inicio"));
                proyecto.setProyFechaFin(rs.getString("proy_fecha_fin"));
                proyecto.setProyDescripcion(rs.getString("proy_descripcion"));

                proyectosList.add(proyecto);
            }

            cnn.close();
            return proyectosList;
        } catch (SQLException e) {
            if (cnn != null) {
                cnn.close();
            }
            throw new Exception("Error al obtener los proyectos: " + e.getMessage());
        }
    }
}
