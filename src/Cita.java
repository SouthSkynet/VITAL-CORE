import java.sql.Time;
import java.time.LocalDate;

public abstract class Cita {
    protected String idCita, motivo, estado;
    protected LocalDate fecha;
    protected Time hora;

    public Cita(String idCita, LocalDate fecha, Time hora, String motivo, String estado) {
        this.idCita = idCita;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.estado = estado;
    }

    public abstract void confirmar();
    public abstract void cancelar(String motivo);
    public abstract void reprogramar(LocalDate nuevaFecha);

    public String getIdCita() {return idCita;}
    public void setIdCita(String idCita) {this.idCita = idCita;}
    public String getMotivo() {return motivo;}
    public void setMotivo(String motivo) {this.motivo = motivo;}
    public String getEstado() {return estado;}
    public void setEstado(String estado) {this.estado = estado;}
    public LocalDate getFecha() {return fecha;}
    public void setFecha(LocalDate fecha) {this.fecha = fecha;}
    public Time getHora() {return hora;}
    public void setHora(Time hora) {this.hora = hora;}
}
