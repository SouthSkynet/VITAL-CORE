import java.time.LocalDate;

public abstract class Medicina {
    protected String idMedicina, nombre, presentacion;
    protected int stocK;
    protected double precio;
    protected LocalDate fechaVencimiento;

    public Medicina(String idMedicina, String nombre, String presentacion, int stocK, double precio, LocalDate fechaVencimiento) {
        this.idMedicina = idMedicina;
        this.nombre = nombre;
        this.presentacion = presentacion;
        this.stocK = stocK;
        this.precio = precio;
        this.fechaVencimiento = fechaVencimiento;
    }

    public abstract boolean verificarStock();
    public abstract void actualizarStock(int cantidad);
    public abstract boolean verificarVencimiento();

    public String getIdMedicina() {return idMedicina;}
    public void setIdMedicina(String idMedicina) {this.idMedicina = idMedicina;}
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getPresentacion() {return presentacion;}
    public void setPresentacion(String presentacion) {this.presentacion = presentacion;}
    public int getStocK() {return stocK;}
    public void setStocK(int stocK) {this.stocK = stocK;}
    public double getPrecio() {return precio;}
    public void setPrecio(double precio) {this.precio = precio;}
    public LocalDate getFechaVencimiento() {return fechaVencimiento;}
    public void setFechaVencimiento(LocalDate fechaVencimiento) {this.fechaVencimiento = fechaVencimiento;}
}
