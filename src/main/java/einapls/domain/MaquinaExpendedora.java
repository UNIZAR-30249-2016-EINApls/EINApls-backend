package einapls.domain;

import java.util.HashMap;

/**
 * Created by javmu on 24/05/2016.
 */
public class MaquinaExpendedora {

    private HashMap<String, Integer> stock;

    MaquinaExpendedora(HashMap<String, Integer> stock) {
        this.stock = stock;
    }

    public HashMap<String, Integer> getAllStock() {
        return stock;
    }

    public void incrementarStock(String producto) {

    }

    public void decrementarStock(String producto) {

    }

}
