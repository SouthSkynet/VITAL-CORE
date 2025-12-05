import java.time.LocalDate;

public abstract class Medico extends PersonalMedico{
    protected String tituloAcademico, consultorio;
    protected int pacientesAtendidos;

    public Medico(String id, String nombre, String apellido, LocalDate fechaNacimiento,
                  String numeroLicencia, int[] horario, String tituloAcademico, String consultorio, int pacientesAtendidos){
        super(id, nombre, apellido, fechaNacimiento, numeroLicencia, horario);
        this.tituloAcademico = tituloAcademico;
        this.consultorio = consultorio;
        this.pacientesAtendidos = pacientesAtendidos;
    }

    public abstract void atenderConsulta(Cita cita);
    public abstract Diagnostico generarDiagnóstico();
    public abstract Receta preescribirReceta();
    public abstract double calcularCostoConsulta();

    public int getPacientesAtendidos() {return pacientesAtendidos;}
    public void setPacientesAtendidos(int pacientesAtendidos) {this.pacientesAtendidos = pacientesAtendidos;}
    public String getConsultorio() {return consultorio;}
    public void setConsultorio(String consultorio) {this.consultorio = consultorio;}
    public String getTituloAcademico() {return tituloAcademico;}
    public void setTituloAcademico(String tituloAcademico) {this.tituloAcademico = tituloAcademico;}
}
