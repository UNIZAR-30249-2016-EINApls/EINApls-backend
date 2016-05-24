package einapls.domain;

/**
 * Created by javmu on 24/05/2016.
 */
public class Localizacion {

    private Geom geom;
    private TipoPiso tipoPiso;
    private TipoEdificio tipoEdificio;

    Localizacion (Geom geom, TipoPiso tipoPiso, TipoEdificio tipoEdificio) {
        this.geom = geom;
        this.tipoPiso = tipoPiso;
        this.tipoEdificio = tipoEdificio;

    }

    public Geom getGeom() {
        return geom;
    }

    public TipoPiso getPiso() {
        return tipoPiso;
    }

    public TipoEdificio getEdificio() {
        return tipoEdificio;

    }

}
