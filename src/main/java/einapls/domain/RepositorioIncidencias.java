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

    public static Incidencia findIncidencia(int id) {
        Connection con = PoolConexiones.getConex();
        try {
            PreparedStatement query = con.prepareStatement("SELECT * FROM incidencia WHERE id = ?");
            query.setInt(1, id);

            ResultSet rs = query.executeQuery();

            String tipoEdificio = "";
            String tipoPiso = "";
            String foto = "";
            String estadoIncidencia = "";
            String titulo = "";
            String descripcion = "";
            float latitud = -1;
            float longitud = -1;

            if (rs.next()) {
                tipoEdificio = rs.getString("edificio");
                tipoPiso = rs.getString("piso");
                foto = rs.getString("foto");
                estadoIncidencia = rs.getString("estado");
                titulo = rs.getString("titulo");
                descripcion = rs.getString("descripcion");
                latitud = rs.getFloat("lat");
                longitud = rs.getFloat("lon");

                TipoPiso tipoPisoEnum = ConversorEnum.getTipoPiso(tipoPiso);
                TipoEdificio tipoEdificioEnum = ConversorEnum.getTipoEdificio(tipoEdificio);
                EstadoIncidencia estadoIncidenciaEnum = ConversorEnum.getEstadoIncidencia(estadoIncidencia);
                Localizacion localizacion = new Localizacion(latitud, longitud, tipoPisoEnum, tipoEdificioEnum);

                System.out.println("TIPO_PISO: " + tipoPisoEnum.toString() + " | TIPO_EDIFICIO: "
                        + tipoEdificioEnum.toString() + " | TIPO_INCIDENCIA: "  + estadoIncidenciaEnum.toString() +
                " | TITULO: " + titulo);

                return new Incidencia(id, titulo, foto,  descripcion, localizacion);
            }
            else return null;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Incidencia[] findIncidencias(TipoEdificio tipoEdif, TipoPiso tipoPis) {
        ArrayList<Incidencia> listIncidencias = new ArrayList<>();
        Connection con = PoolConexiones.getConex();
        try {
            PreparedStatement query = con.prepareStatement("SELECT * FROM incidencia WHERE piso = ? AND edificio = ?");
            query.setString(1, tipoPis.toString());
            query.setString(2, tipoEdif.toString());

            ResultSet rs = query.executeQuery();

            int id;
            String tipoEdificio = "";
            String tipoPiso = "";
            String foto = "";
            String estadoIncidencia = "";
            String titulo = "";
            String descripcion = "";
            float latitud = -1;
            float longitud = -1;

            while (rs.next()) {
                id = rs.getInt("id");
                tipoEdificio = rs.getString("edificio");
                tipoPiso = rs.getString("piso");
                foto = rs.getString("foto");
                estadoIncidencia = rs.getString("estado");
                titulo = rs.getString("titulo");
                descripcion = rs.getString("descripcion");
                latitud = rs.getFloat("lat");
                longitud = rs.getFloat("lon");

                System.out.println("TIPO_PISOOOOOO " + tipoPiso );
                TipoPiso tipoPisoEnum = ConversorEnum.getTipoPiso(tipoPiso);
                TipoEdificio tipoEdificioEnum = ConversorEnum.getTipoEdificio(tipoEdificio);
                EstadoIncidencia estadoIncidenciaEnum = ConversorEnum.getEstadoIncidencia(estadoIncidencia);
                Localizacion localizacion = new Localizacion(latitud, longitud, tipoPisoEnum, tipoEdificioEnum);
                listIncidencias.add(new Incidencia(id, titulo, foto,  descripcion, localizacion));

            }
            for (Incidencia incidencia : listIncidencias) {
                System.out.println("TIPO_PISO: " + incidencia.getLocalizacion().getPiso() + " | TIPO_EDIFICIO: " +
                        incidencia.getLocalizacion().getEdificio() + " | TITULO: "  + incidencia.getTitulo());
            }
            return listIncidencias.toArray(new Incidencia[listIncidencias.size()]);


        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

