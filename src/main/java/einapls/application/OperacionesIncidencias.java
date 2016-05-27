package einapls.application;

import einapls.domain.Incidencia;
import einapls.domain.RepositorioIncidencias;
import einapls.domain.enumerations.TipoEdificio;
import einapls.domain.enumerations.TipoPiso;
import einapls.infrastructure.PoolConexiones;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Jorge on 25/05/2016.
 */
public class OperacionesIncidencias {


    public static void postIncidencias(Incidencia incidencia) throws SQLException {
        Connection c = PoolConexiones.getConex();
        Statement stmt = c.createStatement();
        String sql = "INSERT INTO einapls.incidencia(\n" +
                "            edificio, piso, foto, estado, titulo, descripcion, lat, lon)\n" +
                "    VALUES ('" + incidencia.getLocalizacion().getEdificio() + "', '"+
                incidencia.getLocalizacion().getPiso() + "', '"+
                incidencia.getFoto() + "', '"+ incidencia.getEstadoIncidencia() + "', '"+
                incidencia.getTitulo() + "', '"+incidencia.getDescripcion() + "', '"+
                incidencia.getLocalizacion().getLat() + "', '"+
                incidencia.getLocalizacion().getLon() + "', '"+
                ");";
        stmt.executeUpdate(sql);
    }

    //TODO comprobar las dos ops de find
    public static Incidencia getIncidencia(int id){
        //Llamamos a repositorio incidencias para que nos devuelva la incidencia con id id
        Incidencia incidencia = RepositorioIncidencias.findIncidencia(id);
        return incidencia;
    }

    public static Incidencia[] getIncidencias(TipoPiso tipoPiso, TipoEdificio tipoEdificio){
        //Llamamos a repositorio incidencias para que nos devuelva una lista con las incidencias en tipoEdificio y tipoPiso
        Incidencia[] incidencias = RepositorioIncidencias.findIncidencias(tipoPiso, tipoEdificio);
        return incidencias;
    }
}
