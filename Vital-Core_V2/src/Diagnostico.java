import java.time.LocalDate;

public abstract class Diagnostico {
    protected String idDiagnostico, descripcion, gravedad, indicacionesTratamiento;
    protected LocalDate fecha;
    protected int duracionTratamiento;

    public Diagnostico (String idDiagnostico, LocalDate fecha, String descripcion, String gravedad, String indicacionesTratamiento, int duracionTratamiento){
        this.idDiagnostico = idDiagnostico;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.gravedad = gravedad;
        this.indicacionesTratamiento = indicacionesTratamiento;
        this.duracionTratamiento = duracionTratamiento;
    }

    public abstract String generarInforme();
    public abstract void actualizarEstado();

    public String getIdDiagnostico() {return idDiagnostico;}
    public void setIdDiagnostico(String idDiagnostico) {this.idDiagnostico = idDiagnostico;}
    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
    public String getGravedad() {return gravedad;}
    public void setGravedad(String gravedad) {this.gravedad = gravedad;}
    public String getIndicacionesTratamiento() {return indicacionesTratamiento;}
    public void setIndicacionesTratamiento(String indicacionesTratamiento) {this.indicacionesTratamiento = indicacionesTratamiento;}
    public LocalDate getFecha() {return fecha;}
    public void setFecha(LocalDate fecha) {this.fecha = fecha;}
    public int getDuracionTratamiento() {return duracionTratamiento;}
    public void setDuracionTratamiento(int duracionTratamiento) {this.duracionTratamiento = duracionTratamiento;}
}
