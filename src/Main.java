import config.Conexion;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) throws Exception {
        Conexion obj = new Conexion();

        Connection cnn = obj.establecer_conexion();
    }
}
