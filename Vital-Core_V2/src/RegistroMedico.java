import java.sql.Time;
import java.time.LocalDate;

public abstract class RegistroMedico {
    protected int numRegistro;
    protected double totalFacturacion;
    protected LocalDate fecha;
    protected String nombreMedico;
    protected Time hora;

    public RegistroMedico(int numRegistro, double totalFacturacion, LocalDate fecha, String nombreMedico, Time hora) {
        this.numRegistro = numRegistro;
        this.totalFacturacion = totalFacturacion;
        this.fecha = fecha;
        this.nombreMedico = nombreMedico;
        this.hora = hora;
    }

    public abstract void mostrarRegistro();

    public int getNumRegistro() {return numRegistro;}
    public void setNumRegistro(int numRegistro) {this.numRegistro = numRegistro;}
    public double getTotalFacturacion() {return totalFacturacion;}
    public void setTotalFacturacion(double totalFacturacion) {this.totalFacturacion = totalFacturacion;}
    public LocalDate getFecha() {return fecha;}
    public void setFecha(LocalDate fecha) {this.fecha = fecha;}
    public String getNombreMedico() {return nombreMedico;}
    public void setNombreMedico(String nombreMedico) {this.nombreMedico = nombreMedico;}
    public Time getHora() {return hora;}
    public void setHora(Time hora) {this.hora = hora;}
}


