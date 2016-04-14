package einapls.domain;

/**
 * Created by Jorge on 14/04/2016.
 */
public class SensorStock {

    private int id;
    private String producto;
    private int stock;

    SensorStock(int myId, String myProducto, int myStock){
        id=myId;
        producto=myProducto;
        stock=myStock;
    }

    // GETTERS

    public int getId() {
        return id;
    }

    public String getProducto() {
        return producto;
    }

    public int getStock() {
        return stock;
    }
}
