package einapls.application;

/**
 * Created by javmu on 28/05/2016.
 */
public class SimuladorHorario {

    public static String getHorario() {
        String horariosJSON = "{ \"8:00\": \"Fisica\"," +
                "\"9:00\": \"Programacion\"," +
                "\"10:00\": \"Laboratorio de Software\"," +
                "\"11:00\": \"Ingenieria de Requisitos\"," +
                "\"12:00\": \"Arquitectura Software\"," +
                "\"13:00\": \"Videojuegos\"," +
                "\"14:00\": \"Sistemas de la Informacion\"," +
                "\"15:00\": \"Redes de Computadores\"," +
                "\"16:00\": \"Proyecto Software\"," +
                "\"17:00\": \"Ingenieria Web\"," +
                "\"18:00\": \"Sistemas y Tecnologias Web\"," +
                "\"19:00\": \"LIBRE\"," +
                "\"20:00\": \"Sistemas Distribuidos\"," +
                "\"21:00\": \"LIBRE\"}";
        return horariosJSON;
    }
}
