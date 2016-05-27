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

    //Buscará en la BD un espacio con id id y devolvera un objeto espacio con el resto de atributos
    public static Espacio findEspacio (int id) {
        Connection con = PoolConexiones.getConex();
        Espacio espacio = null;

        try {
            PreparedStatement query = con.prepareStatement("SELECT * FROM espacio WHERE id = ?");
            query.setInt(1, id);
            ResultSet rs = query.executeQuery();
            if(rs.next()) {
                espacio = getEspacioFromRS(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return espacio;
    }

    //Buscara en la BD todos aquellos epsacios que esten en el piso
    public static Espacio[] findEspacios (TipoPiso tipoPiso, TipoEdificio tipoEdificio) {
        Connection con = PoolConexiones.getConex();
        ArrayList<Espacio> listEspacios = new ArrayList<>();
        Espacio espacio = null;
        try {
            PreparedStatement query = con.prepareStatement("SELECT * FROM espacio WHERE tipopiso = ? AND tipoedificio = ?");
            query.setString(1, tipoPiso.toString());
            query.setString(2, tipoEdificio.toString());
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                espacio = getEspacioFromRS(rs);
                listEspacios.add(espacio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listEspacios.toArray(new Espacio[listEspacios.size()]);
    }

    //Devuelve todos los espacios de la BD
    public static Espacio[] findAllEspacios () {
        Connection con = PoolConexiones.getConex();
        ArrayList<Espacio> listEspacios = new ArrayList<>();
        Espacio espacio = null;
        try {
            PreparedStatement query = con.prepareStatement("SELECT * FROM espacio");
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                espacio = getEspacioFromRS(rs);
                listEspacios.add(espacio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listEspacios.toArray(new Espacio[listEspacios.size()]);
    }

    //Devuelve un espacio con los datos extraidos de un resultset
    private static Espacio getEspacioFromRS (ResultSet rs){
        Espacio espacio = null;
        try {
            //Cargamos los atributos del espacio
            int id = id = rs.getInt("id");
            int capacidad =capacidad = rs.getInt("capacidad");
            int ocupacion = ocupacion = rs.getInt("ocupacion");
            TipoEspacio tipoEspacioEnum = ConversorEnum.getTipoEspacio(rs.getString("tipoespacio"));
            //Creamos la Localizacion
            float latitud = rs.getFloat("lat");
            float longitud  = rs.getFloat("lon");
            TipoPiso tipoPisoEnum = ConversorEnum.getTipoPiso(rs.getString("tipopiso"));
            TipoEdificio tipoEdificioEnum = ConversorEnum.getTipoEdificio(rs.getString("tipoedificio"));
            Localizacion localizacion = new Localizacion(latitud, longitud, tipoPisoEnum, tipoEdificioEnum);

            //Creamos nuestro espacio
            espacio = new Espacio(id, capacidad, ocupacion, tipoEspacioEnum, localizacion);

        } catch (SQLException e) {
                e.printStackTrace();
        }
        return espacio;
    }
}
