package app;

import config.Conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class OperacionesPublicaciones {
    private Statement st;
    private ResultSet rs;

    // Método para agregar una nueva publicación
    public void agregarPublicacion(Conexion con, Publicaciones publicacion) throws Exception {
        Connection cnn = null;
        String query = null;

        try {
            cnn = con.establecerConexion();
            st = cnn.createStatement();

            query = "INSERT INTO publicaciones (publi_id, publi_titulo, publi_fecha_publicacion) VALUES (" +
                    publicacion.getPubliId() + ", '" + publicacion.getPubliTitulo() + "', '" + publicacion.getPubliFechaPublicacion() + "')";
            st.executeUpdate(query);

            cnn.close();
        } catch (SQLException e) {
            if (cnn != null) {
                cnn.close();
            }
            throw new Exception("Error al agregar la publicación: " + e.getMessage());
        }
    }

    // Método para eliminar una publicación
    public int eliminarPublicacion(Conexion con, int publiId) throws Exception {
        Connection cnn = null;
        int resultado = 0;
        String query = null;

        try {
            cnn = con.establecerConexion();
            st = cnn.createStatement();

            query = "DELETE FROM publicaciones WHERE publi_id = " + publiId;
            resultado = st.executeUpdate(query);

            cnn.close();
            return resultado;
        } catch (SQLException e) {
            if (cnn != null) {
                cnn.close();
            }
            throw new Exception("Error al eliminar la publicación: " + e.getMessage());
        }
    }

    // Método para obtener una publicación
    public Publicaciones obtenerPublicacion(Conexion con, int publiId) throws Exception {
        Connection cnn = null;
        Publicaciones publicacion = new Publicaciones();
        String query = null;

        try {
            cnn = con.establecerConexion();
            st = cnn.createStatement();

            query = "SELECT * FROM publicaciones WHERE publi_id = " + publiId;
            rs = st.executeQuery(query);

            if (rs.next()) {
                publicacion.setPubliId(rs.getInt("publi_id"));
                publicacion.setPubliTitulo(rs.getString("publi_titulo"));
                publicacion.setPubliFechaPublicacion(rs.getString("publi_fecha_publicacion"));
            } else {
                throw new Exception("No se encontró la publicación con el ID: " + publiId);
            }

            cnn.close();
            return publicacion;
        } catch (SQLException e) {
            if (cnn != null) {
                cnn.close();
            }
            throw new Exception("Error al obtener la publicación: " + e.getMessage());
        }
    }

    // Método para obtener todas las publicaciones
    public LinkedList<Publicaciones> obtenerPublicaciones(Conexion con) throws Exception {
        Connection cnn = null;
        LinkedList<Publicaciones> publicacionesList = new LinkedList<>();
        String query = null;

        try {
            cnn = con.establecerConexion();
            st = cnn.createStatement();

            query = "SELECT * FROM publicaciones";
            rs = st.executeQuery(query);

            while (rs.next()) {
                Publicaciones publicacion = new Publicaciones();
                publicacion.setPubliId(rs.getInt("publi_id"));
                publicacion.setPubliTitulo(rs.getString("publi_titulo"));
                publicacion.setPubliFechaPublicacion(rs.getString("publi_fecha_publicacion"));

                publicacionesList.add(publicacion);
            }

            cnn.close();
            return publicacionesList;
        } catch (SQLException e) {
            if (cnn != null) {
                cnn.close();
            }
            throw new Exception("Error al obtener las publicaciones: " + e.getMessage());
        }
    }
}
