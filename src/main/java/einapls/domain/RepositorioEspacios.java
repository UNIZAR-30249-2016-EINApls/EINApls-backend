package einapls.domain;

import einapls.domain.enumerations.TipoEdificio;
import einapls.domain.enumerations.TipoEspacio;
import einapls.domain.enumerations.TipoPiso;
import einapls.infrastructure.PoolConexiones;

import java.sql.*;

/**
 * Clase que se comunicará con e respositorio donde se encuentran los espacios
 */
public class RepositorioEspacios {

    //// TODO: 25/05/2016 TODO la implementacion, actualmente todo falseado
    public static Espacio findEspacio (int id) {
        Statement stmt = null;
        Connection con = PoolConexiones.getConex();
        try {
            stmt = con.createStatement();
            PreparedStatement query = con.prepareStatement("SELECT * FROM espacio WHERE id = ?");
            query.setInt(1, id);

            ResultSet rs = query.executeQuery();
            String edificio = "";
            String piso = "";
            float latitud = -1;
            float longitud = -1;
            int capacidad = -1;
            String tipoEspacio = "";
            if (rs.next()) {
                edificio = rs.getString("edificio");
                piso = rs.getString("piso");
                latitud = rs.getFloat("lat");
                longitud = rs.getFloat("lon");
                capacidad = rs.getInt("capacidad");
                tipoEspacio = rs.getString("tipo");
            }
            //CONVERSIÓN TIPO DE ESPACIO
            TipoEspacio miEspacio = TipoEspacio.AULA;
            if (tipoEspacio.equals("BIBLIOTECA")) {
                miEspacio = TipoEspacio.BIBLIOTECA;
            }
            else if (tipoEspacio.equals("CAFETERIA")) {
                miEspacio = TipoEspacio.CAFETERIA;
            }
            else if (tipoEspacio.equals("LABORATORIO")) {
                miEspacio = TipoEspacio.LABORATORIO;
            }
            else if (tipoEspacio.equals("SALA_DE_ESTUDIO")) {
                miEspacio = TipoEspacio.SALA_DE_ESTUDIO;
            }

            //CONVERSIÓN TIPO DE EDIFICIO
            TipoEdificio miEdificio =  TipoEdificio.ADA_BYRON;
            if (edificio.equals("TORRES_QUEVEDO")) {
                miEdificio = TipoEdificio.TORRES_QUEVEDO;
            }
            else if (edificio.equals("BETANCOURT")) {
                miEdificio = TipoEdificio.BETANCOURT;
            }

            //CONVERSIÓN TIPO DE PISO
            TipoPiso miPiso =  TipoPiso.SOTANO;
            if (piso.equals("PISO_0")) {
                miPiso = TipoPiso.PISO_0;
            }
            else if (piso.equals("PISO_1")) {
                miPiso = TipoPiso.PISO_1;
            }
            else if (piso.equals("PISO_2")) {
                miPiso = TipoPiso.PISO_2;
            }
            else if (piso.equals("PISO_3")) {
                miPiso = TipoPiso.PISO_3;
            }
            else if (piso.equals("PISO_4")) {
                miPiso = TipoPiso.PISO_4;
            }
            Espacio miEspacio2 = new Espacio(id, capacidad, 0,  miEspacio, new Localizacion(latitud, longitud, miPiso, miEdificio));

            System.out.println("EL TIPOOO: " + miEspacio2.getTipo());

            return new Espacio(id, capacidad, 0,  miEspacio, new Localizacion(latitud, longitud, miPiso, miEdificio));
            //TODO: La ocupación la ofrece el servicio Disponibilidad


        } catch (SQLException e) {
            e.printStackTrace();
        }
    return null;

    }

    public static Espacio[] findEspacios (TipoEdificio tipoEdificio, int id) {
        return null;
    }
}
