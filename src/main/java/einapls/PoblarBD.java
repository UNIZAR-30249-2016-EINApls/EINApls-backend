/*package einapls;

import einapls.infrastructure.PoolConexiones;
import org.postgis.PGgeometry;
import org.postgresql.PGConnection;

import java.sql.*;
import java.util.ArrayList;

public class PoblarBD {
    static int id = 0;
    //3857
    public static void main(String[] args){
        try {
            poblarDB("adabyron_0", "ADA_BYRON", "PISO_0");
            poblarDB("adabyron_1", "ADA_BYRON", "PISO_1");
            poblarDB("adabyron_2", "ADA_BYRON", "PISO_2");
            poblarDB("adabyron_3", "ADA_BYRON", "PISO_3");
            poblarDB("adabyron_4", "ADA_BYRON", "PISO_4");
            poblarDB("adabyron_s1", "ADA_BYRON", "SOTANO");

            id = 10000;
            poblarDB("torres_0", "TORRES_QUEVEDO", "PISO_0");
            poblarDB("torres_1", "TORRES_QUEVEDO", "PISO_1");
            poblarDB("torres_2", "TORRES_QUEVEDO", "PISO_2");
            poblarDB("torres_3", "TORRES_QUEVEDO", "PISO_3");
            poblarDB("torres_s1", "TORRES_QUEVEDO", "SOTANO");

            id = 20000;
            poblarDB("betan_0", "BETANCOURT", "PISO_0");
            poblarDB("betan_1", "BETANCOURT", "PISO_1");
            poblarDB("betan_2", "BETANCOURT", "PISO_2");
            poblarDB("betan_3", "BETANCOURT", "PISO_3");
            poblarDB("betan_s1", "BETANCOURT", "SOTANO");


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void poblarDB(String plantaEdificio, String tipoEdificio, String tipoPiso) throws ClassNotFoundException, SQLException{
        Statement stmt = null;
        Connection con = PoolConexiones.getConex();

        ((PGConnection)con).addDataType("geometry",Class.forName("org.postgis.PGgeometry"));
        ((PGConnection)con).addDataType("box3d",Class.forName("org.postgis.PGbox3d"));


        stmt = con.createStatement();
        PreparedStatement query = con.prepareStatement("SELECT * FROM " + plantaEdificio);
        ResultSet rs = query.executeQuery();


        while(rs.next()) {
            //long idd = rs.getLong("id");
            PGgeometry geom = (PGgeometry) rs.getObject("geom");
            String sGeom = geom.toString();
            //System.out.println(sGeom);
            int i = 20;
            //Añadimos a al1 y al2 la lista de coordenadas


            ArrayList<Double> al1 = new ArrayList<>();
            ArrayList<Double> al2 = new ArrayList<>();
            while(i<sGeom.length()){

                while(sGeom.charAt(i)!='-' && sGeom.charAt(i)!='1' && sGeom.charAt(i)!='2' &&
                        sGeom.charAt(i)!='3' && sGeom.charAt(i)!='4' && sGeom.charAt(i)!='5' &&
                        sGeom.charAt(i)!='6' && sGeom.charAt(i)!='7' && sGeom.charAt(i)!='8' &&
                        sGeom.charAt(i)!='9' && sGeom.charAt(i)!='0' && sGeom.charAt(i)!=')'){
                    i++;
                }
                while(sGeom.charAt(i)!=')'){
                    String aux1 = "";
                    String aux2 = "";

                    while(sGeom.charAt(i)!=' ' && sGeom.charAt(i)!=')'){
                        aux1 = aux1 + sGeom.charAt(i);
                        i++;
                    }
                    i++;
                    while(sGeom.charAt(i)!=',' && sGeom.charAt(i)!=')'){
                        aux2 = aux2 + sGeom.charAt(i);
                        i++;
                    }
                    //Ñapa de puta madre
                    if(aux1.charAt(0)==','){
                        aux1 = aux1.substring(2);
                    }
                    //System.out.println(aux1);
                    al1.add(Double.parseDouble(aux1));
                    al2.add(Double.parseDouble(aux2));
                    i++;
                }
                i++;
            }

            //Calcular medias
            double suma1 = 0;
            double suma2 = 0;
            for(int j = 0; j<al1.size(); j++){
                suma1 += al1.get(j);
                suma2 += al2.get(j);
            }
            try{
                //Datos a meter en espacios
                double average1 = suma1 / al1.size();
                double average2 = suma2 / al2.size();
                String layer = rs.getString("layer");
                String id_utc = rs.getString("id_utc");
                String id_centro = rs.getString("id_centro");
                String tipo_de_uso = rs.getString("tipo_de_us");
                if(id_centro != null) {
                    try {
                        if (id_centro.startsWith("AULA")) {
                            String sql = "INSERT INTO einapls.espacio(id, lat, lon, capacidad, tipoespacio, " +
                                    "tipopiso, tipoedificio, ocupacion) VALUES (" + id + ",'" + average1 + "','" + average2 + "'," +
                                    "50" + ",'" + "AULA" + "','" + tipoPiso + "','" + tipoEdificio + "',0);";
                            stmt.executeUpdate(sql);
                            //System.out.println(sql);

                        }
                        if (id_centro.startsWith("LABORATORIO")) {
                            String sql = "INSERT INTO einapls.espacio(id, lat, lon, capacidad, tipoespacio, " +
                                    "tipopiso, tipoedificio, ocupacion) VALUES (" + id + ",'" + average1 + "','" + average2 + "'," +
                                    "20" + ",'" + "LABORATORIO" + "','" + tipoPiso + "','" + tipoEdificio + "',0);";
                            stmt.executeUpdate(sql);
                            //System.out.println(sql);

                        }
                        if (id_centro.startsWith("CAFETER")) {
                            String sql = "INSERT INTO einapls.espacio(id, lat, lon, capacidad, tipoespacio, " +
                                    "tipopiso, tipoedificio, ocupacion) VALUES (" + id + ",'" + average1 + "','" + average2 + "'," +
                                    "200" + ",'" + "CAFETERIA" + "','" + tipoPiso + "','" + tipoEdificio + "',0);";
                            stmt.executeUpdate(sql);
                            //System.out.println(sql);
                        }
                        if (id_centro.startsWith("BIBLIO")) {
                            String sql = "INSERT INTO einapls.espacio(id, lat, lon, capacidad, tipoespacio, " +
                                    "tipopiso, tipoedificio, ocupacion) VALUES (" + id + ",'" + average1 + "','" + average2 + "'," +
                                    "200" + ",'" + "BIBLIOTECA" + "','" + tipoPiso + "','" + tipoEdificio + "',0);";
                            stmt.executeUpdate(sql);
                            //System.out.println(sql);
                        }
                        id++;
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        System.out.println("DONE!");

    }
}*/
