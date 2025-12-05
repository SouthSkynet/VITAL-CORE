import java.time.LocalDate;
import java.util.Date;
public class Paciente extends Persona{
    //Atributos de Paciente
    private String numeroHistoriaClinica, tipoSangre, alergia;
    private final Date fechaRegistro;
    //Constructor de Paciente
    public Paciente(String id,String nombre, String apellido, LocalDate fechaNacimiento, String numeroHistoriaClinica, String tipoSangre, String alergia, Date fechaRegistro){
        super(id,nombre,apellido,fechaNacimiento);
        this.numeroHistoriaClinica = numeroHistoriaClinica;
        this.tipoSangre = tipoSangre;
        this.alergia = alergia;
        this.fechaRegistro = fechaRegistro;
    }
    //Métodos de Paciente
    public void obtenerHistoriaClinica(){};
    //Getters y Setters

    public String getNumeroHistoriaClinica() {
        return numeroHistoriaClinica;
    }
    public void setNumeroHistoriaClinica(String numeroHistoriaClinica) {
        this.numeroHistoriaClinica = numeroHistoriaClinica;
    }
    public String getTipoSangre() {
        return tipoSangre;
    }
    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }
    public String getAlergia() {
        return alergia;
    }
    public void setAlergia(String alergia) {
        this.alergia = alergia;
    }
    public Date getFechaRegistro() {
        return fechaRegistro;
    }
}
