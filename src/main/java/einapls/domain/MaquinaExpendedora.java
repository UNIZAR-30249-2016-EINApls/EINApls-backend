package einapls.domain;

import java.util.HashMap;

/**
 * Representará una Maquina Expendedora
 */
public class MaquinaExpendedora {

    private int id;                         //id unico
    private HashMap<String, Integer> stock; //HashMap que almacena toda la informacion del stock de una maquina
    private Localizacion localizacion;      // //Localizacion asociada a esta maquina

    public MaquinaExpendedora(int id, HashMap<String, Integer> stock, Localizacion localizacion) {
        this.id = id;
        this.stock = stock;
        this.localizacion = localizacion;
    }

    //GETTERs
    public int getId() { return id; }

    public HashMap<String, Integer> getAllStock() {
        return stock;
    }

    public Localizacion getLocalizacion() { return localizacion; }

    //SETTERs
    public void incrementarStock(String producto) {
        int stockProducto = stock.get(producto);
        stockProducto++;
        stock.put(producto,stockProducto);
    }

    public void decrementarStock(String producto) {
        int stockProducto = stock.get(producto);
        stockProducto--;
        stock.put(producto,stockProducto);
    }

    public void setStock(HashMap<String, Integer> stock){
        this.stock = stock;
    }
}
