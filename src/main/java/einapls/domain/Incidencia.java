package einapls.domain;

import einapls.domain.enumerations.EstadoIncidencia;

/**
 * Representará una Incidencia
 */
public class Incidencia {

    private static int numIncidencia;

    private int id;                             //id unico
    private String titulo;                      //Titulo asignado por el usuario a la incidencia
    private EstadoIncidencia estadoIncidencia;  //Estado de la incidencia, pudiendo ser: ABIERTA, ACEPTADA y CERRADA
    private String foto;                        //Enlace a la foto
    private String descripcion;                 //Descripcion asignada por el usuario a la incidencia
    private Localizacion localizacion;

    public Incidencia (int id, String titulo, EstadoIncidencia estadoIncidencia, String foto, String descripcion,
                       Localizacion localizacion) {
        this.id = id;
        this.titulo = titulo;
        //Todas las incidencias inicialmente quedaran marcadas como abiertas, a la espera de que un administrador cambie
        //  su estado.
        this.estadoIncidencia = estadoIncidencia;
        this.foto = foto;
        this.descripcion = descripcion;
        this.localizacion = localizacion;
        numIncidencia++;
    }

    //GETTERs que darán acceso a todos los atributos de interes publico de una incidencia.

    public int getId() { return id; }

    public String getTitulo() { return titulo; }

    public EstadoIncidencia getEstadoIncidencia() { return estadoIncidencia; }

    public String getFoto() { return foto; }

    public String getDescripcion() { return descripcion; }

    public Localizacion getLocalizacion() { return localizacion; }


    public static int getNumIncidencia() {
        return numIncidencia;
    }

    //SETTERs que permitiran modificar el estado de la incidencia
    public void setEstadoAceptada() {
        //Una incidencia que ya se haya cerrado no debe de volver a abrirse
        if(this.estadoIncidencia.equals(EstadoIncidencia.ABIERTA)){
            this.estadoIncidencia = EstadoIncidencia.ACEPTADA;
        }
    }

    public void setEstadoCerrada() { this.estadoIncidencia = EstadoIncidencia.CERRADA; }
}
