package einapls.domain;

import einapls.domain.enumerations.EstadoIncidencia;

/**
 * Representará una Incidencia
 */
public class Incidencia {

    private int id;                             //id unico
    private String titulo;                      //Titulo asignado por el usuario a la incidencia
    private EstadoIncidencia estadoIncidencia;  //Estado de la incidencia, pudiendo ser: ABIERTA, ACEPTADA y CERRADA
    //// TODO: 25/05/2016 tema de la foto como lo manjeamos? he supuesto que con un string que indicará la ruta donde tengamos el recurso de la foto?
    private String foto;                        //Enlace a la foto
    private String descripcion;                 //Descripcion asignada por el usuario a la incidencia

    Incidencia (int id, String titulo, String foto, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        //Todas las incidencias inicialmente quedaran marcadas como abiertas, a la espera de que un administrador cambie
        //  su estado.
        this.estadoIncidencia = EstadoIncidencia.ABIERTA;
        this.foto = foto;
        this.descripcion = descripcion;
    }

    //GETTERs que darán acceso a todos los atributos de interes publico de una incidencia.

    public int getId() { return id; }

    public String getTitulo() { return titulo; }

    public EstadoIncidencia getEstadoIncidencia() { return estadoIncidencia; }

    public String getFoto() { return foto; }

    public String getDescripcion() { return descripcion; }

    //SETTERs que permitiran modificar el estado de la incidencia
    public void setEstadoAceptada() {
        //Una incidencia que ya se haya cerrado no debe de volver a abrirse
        if(this.estadoIncidencia.equals(EstadoIncidencia.ABIERTA)){
            this.estadoIncidencia = EstadoIncidencia.ACEPTADA;
        }
    }

    public void setEstadoCerrada() { this.estadoIncidencia = EstadoIncidencia.CERRADA; }
}
