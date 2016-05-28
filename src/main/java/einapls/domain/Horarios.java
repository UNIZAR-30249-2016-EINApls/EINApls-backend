package einapls.domain;

import einapls.puertosYAdaptadores.SimuladorConectorHorario;

/**
 * Servicio
 *
 * Devuelve el horario obtenido por un servicio externo simulado (SimuladorConectorHorario)
 */
public class Horarios {

    public static String getHorario() {
        return SimuladorConectorHorario.getHorario();
    }
}
