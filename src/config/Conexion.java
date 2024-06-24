package config;
import java.sql.*;
public class Conexion {
    private String usuario_bd = "root";
    private String password_bd = "monchillo24";
    private String url = "jdbc:sqlserver://localhost:1433;databaseName=investigadores;encrypt=false;trustServerCertificate=false";

    private Connection cnn;

    // Método de conexion
    public Connection establecerConexion() throws Exception {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cnn = DriverManager.getConnection(url, usuario_bd, password_bd);
            return cnn;
        }
        catch (SQLException e){
            throw new Exception ("\n" + e +
                    "\n\nPara el usuario: Error... No se pudo establecer la conexion");
        }
    }
}

