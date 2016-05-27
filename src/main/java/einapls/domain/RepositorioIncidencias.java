package einapls.domain;

import einapls.domain.enumerations.*;
import einapls.infrastructure.PoolConexiones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Clase que se comunicará con e respositorio donde se encuentran las incidencias
 */
public class RepositorioIncidencias {

    //// TODO: 25/05/2016 TODO la implementacion, actualmente todo falseado
    public static boolean createIncidencia(Incidencia incidencia) {
        return false;
    }

    //// TODO: 25/05/2016 TODO la implementacion, actualmente todo falseado
    //FINDS
    //Devuelve un objeto incidencia con la incidencia guardada en la BD con el id id
    public static Incidencia findIncidencia(int id) {
        Connection con = PoolConexiones.getConex();
        Incidencia incidencia = null;
        try {
            PreparedStatement query = con.prepareStatement("SELECT * FROM incidencia WHERE id = ?");
            query.setInt(1, id);

            ResultSet rs = query.executeQuery();
            if (rs.next()) {
                incidencia = getIncidenciaFromRS(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return incidencia;
    }

    //Devuelve un array con todas las incidencias que hay en la BD en el piso tipoPiso y edificio tipoEdificio
    public static Incidencia[] findIncidencias( TipoPiso tipoPis, TipoEdificio tipoEdif) {
        Connection con = PoolConexiones.getConex();
        ArrayList<Incidencia> listIncidencias = new ArrayList<>();
        Incidencia incidencia = null;
        try {
            PreparedStatement query = con.prepareStatement("SELECT * FROM incidencia WHERE piso = ? AND edificio = ?");
            query.setString(1, tipoPis.toString());
            query.setString(2, tipoEdif.toString());
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                incidencia = getIncidenciaFromRS(rs);
                listIncidencias.add(incidencia);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return listIncidencias.toArray(new Incidencia[listIncidencias.size()]);
    }

    //Devuelve una incidencia con los datos extraidos de un resultset
    private static Incidencia getIncidenciaFromRS (ResultSet rs){
        Incidencia incidencia = null;

        try{
            //Cargamos los atributos de la incidencia
            int id = rs.getInt("id");
            String titulo = rs.getString("titulo");
            EstadoIncidencia estadoIncidenciaEnum = ConversorEnum.getEstadoIncidencia(rs.getString("estado"));
            String foto = rs.getString("foto");
            String descripcion= rs.getString("descripcion");

            //Cargamos la localizacion
            float latitud = rs.getFloat("lat");
            float longitud = rs.getFloat("lon");
            TipoPiso tipoPisoEnum = ConversorEnum.getTipoPiso(rs.getString("tipopiso"));
            TipoEdificio tipoEdificioEnum = ConversorEnum.getTipoEdificio(rs.getString("tipoedificio"));
            Localizacion localizacion = new Localizacion(latitud, longitud, tipoPisoEnum, tipoEdificioEnum);

            //Creamos la incidencia
            incidencia= new Incidencia(id, titulo, EstadoIncidencia.ABIERTA, foto,  descripcion, localizacion);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  incidencia;
    }
}

