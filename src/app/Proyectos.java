package app;

public class Proyectos {
    private int proyId;
    private String proyCodigo;
    private String proyNombre;
    private String proyHorasDedicacion;
    private String proyFechaInicio;
    private String proyFechaFin;
    private String proyDescripcion;

    public Proyectos(int proyId, String proyCodigo, String proyNombre, String proyHorasDedicacion, String proyFechaInicio, String proyFechaFin, String proyDescripcion) {
        this.proyId = proyId;
        this.proyCodigo = proyCodigo;
        this.proyNombre = proyNombre;
        this.proyHorasDedicacion = proyHorasDedicacion;
        this.proyFechaInicio = proyFechaInicio;
        this.proyFechaFin = proyFechaFin;
        this.proyDescripcion = proyDescripcion;
    }
}
