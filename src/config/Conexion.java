package config;
import java.sql.*;
public class Conexion {
    private String nombre_bd = "investigadores";
    private String usuario_bd = "root";
    private String password_bd = "monchillo24";
    private String url = "jdbc:sqlserver://localhost:1433;databaseName=investigadores;encrypt=false;trustServerCertificate=false";

    private Connection cnn; //objeto que permite la conexión a la BD

//    public Conexion(String nombre_bd, String usuario_bd, String password_bd){
//        this.nombre_bd=nombre_bd;
//        this.usuario_bd= usuario_bd;
//        this.password_bd=password_bd;
//    }

    // Método de conexion
    public Connection establecer_conexion() throws Exception {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cnn = DriverManager.getConnection(url, usuario_bd, password_bd);
            return cnn;
        }
        catch (SQLException e){
            throw new Exception ("\nPara el programador: "+e+
                    "\n\nPara el usuario: Error... No se pudo establecer la conexion");
        }
    }

    public String getNombre_bd() {
        return nombre_bd;
    }
}

