package app;

import java.util.LinkedList;

public class Publicaciones {
    private int publiId;
    private String publiTitulo;
    private String publiFechaPublicacion;
    private LinkedList<Investigador> autores;

    public Publicaciones(String publiFechaPublicacion, String publiTitulo, int publiId) {
        this.publiFechaPublicacion = publiFechaPublicacion;
        this.publiTitulo = publiTitulo;
        this.publiId = publiId;
    }

    public Publicaciones() {

    }

    public int getPubliId() {
        return publiId;
    }

    public void setPubliId(int publiId) {
        this.publiId = publiId;
    }

    public String getPubliTitulo() {
        return publiTitulo;
    }

    public void setPubliTitulo(String publiTitulo) {
        this.publiTitulo = publiTitulo;
    }

    public String getPubliFechaPublicacion() {
        return publiFechaPublicacion;
    }

    public void setPubliFechaPublicacion(String publiFechaPublicacion) {
        this.publiFechaPublicacion = publiFechaPublicacion;
    }


}
