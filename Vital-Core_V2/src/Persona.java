import java.time.LocalDate;
import java.time.Period;

public abstract class Persona {
    //Atributos de Persona
    protected String id, nombre, apellido;
    protected LocalDate fechaNacimiento;
    protected LocalDate fechaActual = LocalDate.now();
    //Constructor de Persona
    public Persona(String id, String nombre, String apellido, LocalDate fechaNacimiento){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }

    //Métodos de Persona
    public int calularEdad(LocalDate fechaActual,LocalDate fechaNacimiento) {
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        int anios = periodo.getYears();
        return anios;
    }
    public void actualizarDatos() {
    }

    //Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
