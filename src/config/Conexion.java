package config;
import java.sql.*;
public class Conexion {
    private static String  usuario= "root";
    private static String password = "monchillo24";

    private static Connection cnn;

    // Método de conexion
    public static Connection establecerConexion() throws Exception {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cnn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=investigadores;encrypt=false;trustServerCertificate=false", usuario, password);
            return cnn;
        }
        catch (SQLException e){
            throw new Exception ("\n" + e +
                    "\n\nPara el usuario: Error... No se pudo establecer la conexion");
        }
    }
}