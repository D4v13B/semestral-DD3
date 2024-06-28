package app;

import config.Conexion;

import java.sql.Connection;
import java.sql.SQLException;

public class OperacionesPublicaciones {

    public boolean insertarPublicacion(){
        Connection con = null;

        try {
            con = Conexion.establecerConexion();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
