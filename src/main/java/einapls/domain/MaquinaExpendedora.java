package einapls.domain;

import java.util.HashMap;

/**
 * Representará una Maquina Expendedora
 */
public class MaquinaExpendedora {

    private int id;                         //id unico
    private HashMap<String, Integer> stock; //HashMap que almacena toda la informacion del stock de una maquina

    MaquinaExpendedora(int id, HashMap<String, Integer> stock) {
        this.id = id;
        this.stock = stock;
    }

    //GETTERs
    public int getId() { return id; }

    public HashMap<String, Integer> getAllStock() {
        return stock;
    }

    //SETTERs
    public void incrementarStock(String producto) {
//// TODO: 25/05/2016 programar el metodo para incrementar el stock de un producto de una maquina expendedora
    }

    public void decrementarStock(String producto) {
//// TODO: 25/05/2016 programar el metodo para dencrementar el stock de un producto de una maquina expendedora
    }

}
