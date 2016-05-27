package einapls.domain;

import einapls.domain.enumerations.ConversorEnum;
import einapls.domain.enumerations.TipoEdificio;
import einapls.domain.enumerations.TipoPiso;
import einapls.infrastructure.PoolConexiones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase que se comunicará con e respositorio donde se encuentran las maquinas expendedoras
 */
public class RepositorioMaquinas {

    //Devuelve un objeto maquina con la maquina guardada en la BD con el id id
    public static MaquinaExpendedora findMaquina(int id) {
        Connection con = PoolConexiones.getConex();
        MaquinaExpendedora maquina = null;
        try {
            PreparedStatement query = con.prepareStatement("SELECT * FROM maq_exp WHERE id = ?");
            query.setInt(1, id);
            ResultSet rs = query.executeQuery();
            if(rs.next()){
                maquina = getMaquinaFromRS(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maquina;
    }
    //Devuelve un array con todas las maquinas que hay en la BD en el piso tipoPiso y edificio tipoEdificio
    public static MaquinaExpendedora[] findMaquinas(TipoPiso tipoPiso, TipoEdificio tipoEdificio) {
        Connection con = PoolConexiones.getConex();
        ArrayList<MaquinaExpendedora> listMaquinas = new ArrayList<>();
        MaquinaExpendedora maquina = null;
        try {
            PreparedStatement query = con.prepareStatement("SELECT * FROM maq_exp WHERE tipopiso = ? AND tipoedificio = ?");
            query.setString(1, tipoPiso.toString());
            query.setString(2, tipoEdificio.toString());
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                maquina = getMaquinaFromRS(rs);
                listMaquinas.add(maquina);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listMaquinas.toArray(new MaquinaExpendedora[listMaquinas.size()]);
    }

    //Devuelve todas las maquinas que hay en la BD
    public static MaquinaExpendedora[] findAllMaquinas() {
        Connection con = PoolConexiones.getConex();
        ArrayList<MaquinaExpendedora> listMaquinas = new ArrayList<>();
        MaquinaExpendedora maquina = null;
        try {
            PreparedStatement query = con.prepareStatement("SELECT * FROM maq_exp");
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                maquina = getMaquinaFromRS(rs);
                listMaquinas.add(maquina);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listMaquinas.toArray(new MaquinaExpendedora[listMaquinas.size()]);

        /*

        ArrayList<MaquinaExpendedora> listMaquinas = new ArrayList<>();
        Connection con = PoolConexiones.getConex();
        try {
            PreparedStatement query = con.prepareStatement("SELECT * FROM maq_exp");

            ResultSet rs = query.executeQuery();

            int id;
            float latitud = -1;
            float longitud = -1;
            int capacidad = -1;
            String tipoPiso = "";
            String tipoEdificio = "";
            while (rs.next()) {
                id = rs.getInt("id");
                latitud = rs.getFloat("lat");
                longitud = rs.getFloat("lon");
                tipoPiso = rs.getString("tipopiso");
                tipoEdificio = rs.getString("tipoedificio");

                TipoPiso tipoPisoEnum = ConversorEnum.getTipoPiso(tipoPiso);
                TipoEdificio tipoEdificioEnum = ConversorEnum.getTipoEdificio(tipoEdificio);
                Localizacion localizacion = new Localizacion(latitud, longitud, tipoPisoEnum, tipoEdificioEnum);
                listMaquinas.add(new MaquinaExpendedora(id, new HashMap<String, Integer>(), localizacion));
            }

            return listMaquinas.toArray(new MaquinaExpendedora[listMaquinas.size()]);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    */
    }

    //Devuelve una maquina con los datos extraidos de un resultset
    private static MaquinaExpendedora getMaquinaFromRS (ResultSet rs){
        MaquinaExpendedora maquina = null;
        try {
            //Cargamos los atributos de la mauina expendedora
            int id = rs.getInt("id");
            //// TODO: 27/05/2016  rellenar el stock bien
            HashMap<String, Integer> stock = new HashMap<String, Integer>();

            //Cargamos la localizacion
            float latitud = rs.getFloat("lat");
            float longitud = rs.getFloat("lon");
            TipoPiso tipoPisoEnum = ConversorEnum.getTipoPiso(rs.getString("tipopiso"));
            TipoEdificio tipoEdificioEnum = ConversorEnum.getTipoEdificio(rs.getString("tipoedificio"));
            Localizacion localizacion = new Localizacion(latitud, longitud, tipoPisoEnum, tipoEdificioEnum);

            //Creamos la maquina
            maquina = new MaquinaExpendedora(id, stock , localizacion);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maquina;
    }
}
