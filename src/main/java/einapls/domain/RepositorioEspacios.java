package einapls.domain;

import einapls.domain.enumerations.ConversorEnum;
import einapls.domain.enumerations.TipoEdificio;
import einapls.domain.enumerations.TipoEspacio;
import einapls.domain.enumerations.TipoPiso;
import einapls.infrastructure.PoolConexiones;

import java.sql.*;
import java.util.ArrayList;

/**
 * Clase que se comunicará con e respositorio donde se encuentran los espacios
 */
public class RepositorioEspacios {

    public static Espacio findEspacio (int id) {
        Connection con = PoolConexiones.getConex();
        try {
            PreparedStatement query = con.prepareStatement("SELECT * FROM espacio WHERE id = ?");
            query.setInt(1, id);

            ResultSet rs = query.executeQuery();
            
            float latitud = -1;
            float longitud = -1;
            int ocupacion = -1;
            int capacidad = -1;
            String tipoEspacio = "";
            String tipoPiso = "";
            String tipoEdificio = "";
            if (rs.next()) {
                //Cargamos los atributos del espacio
                capacidad = rs.getInt("capacidad");
                ocupacion = rs.getInt("ocupacion");
                tipoEspacio = rs.getString("tipoespacio");
                TipoEspacio tipoEspacioEnum = ConversorEnum.getTipoEspacio(tipoEspacio);

                //Creamos la Localizacion
                latitud = rs.getFloat("lat");
                longitud = rs.getFloat("lon");
                tipoPiso = rs.getString("tipopiso");
                tipoEdificio = rs.getString("tipoedificio");
                TipoPiso tipoPisoEnum = ConversorEnum.getTipoPiso(tipoPiso);
                TipoEdificio tipoEdificioEnum = ConversorEnum.getTipoEdificio(tipoEdificio);

                Localizacion localizacion = new Localizacion(latitud, longitud, tipoPisoEnum, tipoEdificioEnum);

                return new Espacio(id, capacidad, ocupacion, tipoEspacioEnum, localizacion);
            }
            else return null;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Espacio[] findEspacios (TipoPiso tipoPis, TipoEdificio tipoEdif) {
        ArrayList<Espacio> listEspacios = new ArrayList<>();
        Connection con = PoolConexiones.getConex();
        try {
            PreparedStatement query = con.prepareStatement("SELECT * FROM espacio WHERE tipopiso = ? AND tipoedificio = ?");
            query.setString(1, tipoPis.toString());
            query.setString(2, tipoEdif.toString());

            ResultSet rs = query.executeQuery();

            int i = 0;
            int id;
            float latitud = -1;
            float longitud = -1;
            int capacidad = -1;
            int ocupacion = -1;
            String tipoEspacio = "";
            String tipoPiso = "";
            String tipoEdificio = "";
            while (rs.next()) {
                id = rs.getInt("id");
                latitud = rs.getFloat("lat");
                longitud = rs.getFloat("lon");
                capacidad = rs.getInt("capacidad");
                ocupacion = rs.getInt("ocupacion");
                tipoEspacio = rs.getString("tipoespacio");
                tipoPiso = rs.getString("tipoPiso");
                tipoEdificio = rs.getString("tipoedificio");

                TipoEspacio tipoEspacioEnum = ConversorEnum.getTipoEspacio(tipoEspacio);
                TipoPiso tipoPisoEnum = ConversorEnum.getTipoPiso(tipoPiso);
                TipoEdificio tipoEdificioEnum = ConversorEnum.getTipoEdificio(tipoEdificio);
                Localizacion localizacion = new Localizacion(latitud, longitud, tipoPisoEnum, tipoEdificioEnum);
                listEspacios.add(new Espacio(id, capacidad, ocupacion, tipoEspacioEnum, localizacion));
            }

            /*
            for (Espacio espacio : listEspacios) {
                System.out.println("TIPO_PISO: " + espacio.getLocalizacion().getPiso() + " | TIPO_EDIFICIO: " +
                        espacio.getLocalizacion().getEdificio() + " | TIPO_ESPACIO: "  + espacio.getTipo());
            }
            */

            return listEspacios.toArray(new Espacio[listEspacios.size()]);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * Copia de findEspacios pero devuelve todos los espacios
     */
    public static Espacio[] findAllEspacios () {
        ArrayList<Espacio> listEspacios = new ArrayList<>();
        Connection con = PoolConexiones.getConex();
        try {
            PreparedStatement query = con.prepareStatement("SELECT * FROM espacio");

            ResultSet rs = query.executeQuery();

            int i = 0;
            int id;
            float latitud = -1;
            float longitud = -1;
            int capacidad = -1;
            String tipoEspacio = "";
            String tipoPiso = "";
            String tipoEdificio = "";
            while (rs.next()) {
                id = rs.getInt("id");
                latitud = rs.getFloat("lat");
                longitud = rs.getFloat("lon");
                capacidad = rs.getInt("capacidad");
                tipoEspacio = rs.getString("tipoespacio");
                tipoPiso = rs.getString("tipoPiso");
                tipoEdificio = rs.getString("tipoedificio");

                TipoEspacio tipoEspacioEnum = ConversorEnum.getTipoEspacio(tipoEspacio);
                TipoPiso tipoPisoEnum = ConversorEnum.getTipoPiso(tipoPiso);
                TipoEdificio tipoEdificioEnum = ConversorEnum.getTipoEdificio(tipoEdificio);
                Localizacion localizacion = new Localizacion(latitud, longitud, tipoPisoEnum, tipoEdificioEnum);
                listEspacios.add(new Espacio(id, capacidad, 0, tipoEspacioEnum, localizacion));
            }
            /*for (Espacio espacio : listEspacios) {
                System.out.println("TIPO_PISO: " + espacio.getLocalizacion().getPiso() + " | TIPO_EDIFICIO: " +
                        espacio.getLocalizacion().getEdificio() + " | TIPO_ESPACIO: "  + espacio.getTipo());
            }*/

            return listEspacios.toArray(new Espacio[listEspacios.size()]);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
