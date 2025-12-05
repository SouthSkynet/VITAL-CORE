import java.time.LocalDate;
import java.util.List;

public abstract class Factura {
     protected String idFactura;
     protected LocalDate fecha;
     protected List<String> conceptos;
     protected List<Medicina> medicinas;
     protected double subtotal;
     protected double iva;
     protected double total;

    public Factura(String idFactura, LocalDate fecha, List<String> conceptos, List<Medicina> medicinas, double subtotal, double iva, double total) {
        this.idFactura = idFactura;
        this.fecha = fecha;
        this.conceptos = conceptos;
        this.medicinas = medicinas;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
    }

    public abstract void agregarConcepto(String concepto, double monto);
    public abstract void agregarMedicina(Medicina medicina);
    public abstract double calcularTotal();
    public abstract String generarComprobante();

    public String getIdFactura() {return idFactura;}
    public void setIdFactura(String idFactura) {this.idFactura = idFactura;}
    public LocalDate getFecha() {return fecha;}
    public void setFecha(LocalDate fecha) {this.fecha = fecha;}
    public List<String> getConceptos() {return conceptos;}
    public void setConceptos(List<String> conceptos) {this.conceptos = conceptos;}
    public List<Medicina> getMedicinas() {return medicinas;}
    public void setMedicinas(List<Medicina> medicinas) {this.medicinas = medicinas;}
    public double getSubtotal() {return subtotal;}
    public void setSubtotal(double subtotal) {this.subtotal = subtotal;}
    public double getIva() {return iva;}
    public void setIva(double iva) {this.iva = iva;}
    public double getTotal() {return total;}
    public void setTotal(double total) {this.total = total;}
}
