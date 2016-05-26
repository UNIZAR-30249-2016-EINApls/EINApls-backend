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

    public static MaquinaExpendedora findMaquina(int id) {
        Connection con = PoolConexiones.getConex();
        try {
            PreparedStatement query = con.prepareStatement("SELECT * FROM maq_exp WHERE id = ?");
            query.setInt(1, id);

            ResultSet rs = query.executeQuery();

            float latitud = -1;
            float longitud = -1;
            int capacidad = -1;
            String tipoPiso = "";
            String tipoEdificio = "";
            if (rs.next()) {
                latitud = rs.getFloat("lat");
                longitud = rs.getFloat("lon");
                tipoPiso = rs.getString("tipopiso");
                tipoEdificio = rs.getString("tipoedificio");

                System.out.println("TIPO_PISOOOOOO " + tipoPiso );
                TipoPiso tipoPisoEnum = ConversorEnum.getTipoPiso(tipoPiso);
                TipoEdificio tipoEdificioEnum = ConversorEnum.getTipoEdificio(tipoEdificio);
                Localizacion localizacion = new Localizacion(latitud, longitud, tipoPisoEnum, tipoEdificioEnum);

                System.out.println("TIPO_PISO: " + tipoPisoEnum.toString() + " | TIPO_EDIFICIO: "
                        + tipoEdificioEnum.toString() + " | COORDX: " + latitud);

                return new MaquinaExpendedora(id, new HashMap<String, Integer>(), localizacion);
            }
            else return null;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static MaquinaExpendedora[] findMaquinas(TipoPiso tipoPis, TipoEdificio tipoEdif) {
        ArrayList<MaquinaExpendedora> listMaquinas = new ArrayList<>();
        Connection con = PoolConexiones.getConex();
        try {
            PreparedStatement query = con.prepareStatement("SELECT * FROM maq_exp WHERE tipopiso = ? AND tipoedificio = ?");
            query.setString(1, tipoPis.toString());
            query.setString(2, tipoEdif.toString());

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
            for (MaquinaExpendedora maquina : listMaquinas) {
                System.out.println("TIPO_PISO: " + maquina.getLocalizacion().getPiso() + " | TIPO_EDIFICIO: " +
                        maquina.getLocalizacion().getEdificio() + " | COORD: "  + maquina.getLocalizacion().getLat());
            }
            return listMaquinas.toArray(new MaquinaExpendedora[listMaquinas.size()]);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static MaquinaExpendedora[] findAllMaquinas(){

        MaquinaExpendedora[] me1 = findMaquinas(TipoPiso.PISO_0, TipoEdificio.ADA_BYRON);
        MaquinaExpendedora[] me2 = findMaquinas(TipoPiso.PISO_1, TipoEdificio.ADA_BYRON);
        MaquinaExpendedora[] me3 = findMaquinas(TipoPiso.PISO_2, TipoEdificio.ADA_BYRON);
        MaquinaExpendedora[] me4 = findMaquinas(TipoPiso.PISO_3, TipoEdificio.ADA_BYRON);

        int i = me1.length + me2.length +me3.length +me4.length;
        MaquinaExpendedora[] me = new MaquinaExpendedora[i];

        for(int j = 0; j<i; j++){
            for(int k=0; k<me1.length; k++){
                me[j] = me1[k];
            }
            for(int k=0; k<me2.length; k++){
                me[j] = me2[k];
            }
            for(int k=0; k<me3.length; k++){
                me[j] = me3[k];
            }
            for(int k=0; k<me4.length; k++){
                me[j] = me4[k];
            }

        }
        return me;
    }
}
