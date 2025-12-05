import java.time.LocalDate;

public abstract class PersonalMedico extends Persona{
    //Atributos de Personal Médico
    protected String numeroLicencia, especialidad;
    protected int[]horario;
    //Constructor de Personal Médico
    public PersonalMedico(String id, String nombre, String apellido, LocalDate fechaNacimiento, String numeroLicencia, int[] horario){
        super(id,nombre,apellido,fechaNacimiento);
        this.numeroLicencia = numeroLicencia;
        this.horario = horario;
    }
    //Métodos de Personal Médico
    public boolean verificarDisponibilidad(){
        return true;
    }
    //Getters y Setters
    public String getNumeroLicencia() {
        return numeroLicencia;
    }
    public void setNumeroLicencia(String numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    public int[] getHorario() {
        return horario;
    }
    public void setHorario(int[] horario) {
        this.horario = horario;
    }
}
