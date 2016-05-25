package einapls.domain.enumerations;

/*
 * Clase enumerada con los distintos estados posibles de una incidencia
 *  - ABIERTA: La incidencia acaba de crearse, pendiente de revision por un administrador antes de ser visible
 *  - ACEPTADA: La incidencia ha sido dada como valida por un administrador y es visible por los usuarios
 *  - CERRADA: La incidencia ha sido resuelta y por tanto marcada por un administrador como cerrada, ya no será visible
 */
public enum EstadoIncidencia { ABIERTA, ACEPTADA, CERRADA}
