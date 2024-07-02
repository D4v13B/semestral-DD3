package app;

import java.util.LinkedList;

public class Investigador {
    private int inveId;
    private String inveNombre;
    private String inveArea;
    private String inveCodigo;
    private LinkedList<Publicaciones> publicaciones;

    public Investigador() {}


    public int getInveId() {
        return inveId;
    }

    public void setInveId(int inveId) {
        this.inveId = inveId;
    }

    public String getInveNombre() {
        return inveNombre;
    }

    public void setInveNombre(String inveNombre) {
        this.inveNombre = inveNombre;
    }

    public String getInveArea() {
        return inveArea;
    }

    public void setInveArea(String inveArea) {
        this.inveArea = inveArea;
    }

    public String getInveCodigo() {
        return inveCodigo;
    }

    public void setInveCodigo(String inveCodigo) {
        this.inveCodigo = inveCodigo;
    }

    public LinkedList<Publicaciones> getPublicaciones() {
        return publicaciones;
    }

    public void setPublicaciones(LinkedList<Publicaciones> publicaciones) {
        this.publicaciones = publicaciones;
    }
}
