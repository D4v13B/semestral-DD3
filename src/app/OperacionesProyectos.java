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
}
