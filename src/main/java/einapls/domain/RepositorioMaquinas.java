package einapls.domain;

import einapls.domain.enumerations.ConversorEnum;
import einapls.domain.enumerations.TipoEdificio;
import einapls.domain.enumerations.TipoPiso;
import einapls.infrastructure.PoolConexiones;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase que se comunicará con e respositorio donde se encuentran las maquinas expendedoras
 */
public class RepositorioMaquinas {

    public MaquinaExpendedora findMaquina(int id) {
        Statement stmt = null;
        Connection con = PoolConexiones.getConex();
        try {
            stmt = con.createStatement();
            //TODO tiene que haber una tabla maquinas
            PreparedStatement query = con.prepareStatement("SELECT * FROM maquinas WHERE id = ?");
            query.setInt(1, id);

            ResultSet rs = query.executeQuery();

            //Atributos Maquina Expendedora
            HashMap<String, Integer> stock =  null;
            //Localizacion
            float lat = -1;
            float lon = -1;
            String tipoPisoString = "";
            String tipoEdificioString = "";

            if (rs.next()) {
                //stock =
                lat = rs.getFloat("lat");
                lon = rs.getFloat("lon");
                tipoPisoString = rs.getString("tipoPiso");
                tipoEdificioString = rs.getString("tipoedificio");
            }

            TipoPiso tipoPiso = ConversorEnum.getTipoPiso(tipoPisoString);
            TipoEdificio tipoEdificio = ConversorEnum.getTipoEdificio(tipoEdificioString);
            Localizacion localizacion = new Localizacion(lat, lon, tipoPiso, tipoEdificio);
            //TODO SOLUCIONAR EL TEMA DEL STOCK EN LA BD
            return new MaquinaExpendedora(id, null, localizacion );
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public MaquinaExpendedora[] findMaquinas(TipoEdificio tipoEdificio, TipoPiso tipoPiso) {
        Statement stmt = null;
        Connection con = PoolConexiones.getConex();
        ArrayList<MaquinaExpendedora> maquinaExpendedoras;

        try {
            stmt = con.createStatement();
            //TODO tiene que haber una tabla maquinas
            PreparedStatement query = con.prepareStatement("SELECT * FROM maquinas WHERE tipoPiso ="+tipoPiso+
                    " AND tipoEdificio = "+tipoEdificio+" ");

            ResultSet rs = query.executeQuery();

            //Atributos Maquina Expendedora
            HashMap<String, Integer> stock =  null;
            //Localizacion
            float lat = -1;
            float lon = -1;

            while (rs.next()) {
                //stock =
                lat = rs.getFloat("lat");
                lon = rs.getFloat("lon");

            }

            //TipoPiso tipoPiso = ConversorEnum.getTipoPiso(tipoPisoString);
            //TipoEdificio tipoEdificio = ConversorEnum.getTipoEdificio(tipoEdificioString);
           // Localizacion localizacion = new Localizacion(lat, lon, tipoPiso, tipoEdificio);
            //TODO SOLUCIONAR EL TEMA DEL STOCK EN LA BD
           // return new MaquinaExpendedora(id, null, localizacion );
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
