import java.time.LocalDate;
public abstract class Enfermero extends PersonalMedico{
    protected String turno, area;

    public Enfermero(String id, String nombre, String apellido, LocalDate fechaNacimiento,
                  String numeroLicencia, int[] horario, String turno, String area){
        super(id, nombre, apellido, fechaNacimiento, numeroLicencia, horario);
        this.turno = turno;
        this.area = area;
    }

    public abstract void administrarMedicamento(Medicina medicina);
    public abstract void asistirProcedimiento();
    public abstract void registrarObservaciones(Paciente paciente);

    public String getTurno() {return turno;}
    public void setTurno(String turno) {this.turno = turno;}
    public String getArea() {return area;}
    public void setArea(String area) {this.area = area;}
}
