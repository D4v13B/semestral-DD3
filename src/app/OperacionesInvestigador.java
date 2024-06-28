package app;

import config.Conexion;

import java.sql.*;
import java.util.LinkedList;
import java.util.concurrent.Callable;

public class OperacionesInvestigador {
    Statement st;
    ResultSet rs;
    CallableStatement callableStatement

    public LinkedList<Proyectos> investigadoresXProyectos(int inve_id){
        Connection con = null;
        LinkedList<Proyectos> proyectos = new LinkedList<>();

        try{
            con = Conexion.establecerConexion();
            callableStatement = con.prepareCall("{call listProyectosXInvestigador(?)}");

            //Establecer los parametros de entrada
            callableStatement.setInt(1, inve_id);

            //Ejecutar
            callableStatement.execute();

            //Vamos a recibir la respuesta
            rs = callableStatement.getResultSet();

            Proyectos proyectoTmp = new Proyectos();

            //Recorrer la respuesta del procedimiento
            while(rs.next()){
                proyectoTmp.setProyId(rs.getInt("proy_id"));
                proyectoTmp.setProyNombre(rs.getString("proy_nombre"));
                proyectoTmp.setProyDescripcion(rs.getString("proy_decripcion"));
                proyectoTmp.setProyFechaInicio(rs.getString("proy_fecha_inicio"));
                proyectoTmp.setProyFechaFin(rs.getString("proy_fecha_final"));
                proyectoTmp.setProyCodigo(rs.getString("proy_codigo"));

                proyectos.add(proyectoTmp);
            }

            return proyectos;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return proyectos;
    }
}
