/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pack_gui;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import pack_gui.frmlogin;

/**
 *
 * @author USUARIO
 */
public class frmPaciente extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(frmPaciente.class.getName());
    private String nombrePaciente;
    private String idPaciente;
    private List<CitaPaciente> misCitas;

    /**
     * Creates new form frmPacient
     */
    public frmPaciente() {
        this("Juan Pérez", "P001");
        this.setLocationRelativeTo(null);
        cargarMedicinasDisponibles();
    }

    public frmPaciente(String nombrePaciente, String idPaciente) {
        this.nombrePaciente = nombrePaciente;
        this.idPaciente = idPaciente;
        this.misCitas = new java.util.ArrayList<>();
    
        initComponents();
        cargarDatosEjemplo();
        lBienvenidaP.setText("Bienvenido/a, " + nombrePaciente);
}

    private void cargarMedicinasDisponibles() {
        cbMedicamento.removeAllItems();
        cbMedicamento.addItem("Seleccionar Medicamento...");

        File archivo = new File("inventario.csv");
        if (!archivo.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea = br.readLine(); // Saltar encabezado (MEDICINA,STOCK)
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String[] datos = linea.split(",");
                if (datos.length == 2) {
                    String nombre = datos[0];
                    int stock = Integer.parseInt(datos[1].trim());

                    // REQUERIMIENTO: Solo mostrar si el stock es mayor a 0
                    if (stock > 0) {
                        cbMedicamento.addItem(nombre);
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error al cargar medicinas: " + e.getMessage());
        }
    }

    // Desconteo en el archivo de inventario
    private void procesarPedido() {
        String medicinaSeleccionada = (String) cbMedicamento.getSelectedItem();
        
        if (medicinaSeleccionada == null || medicinaSeleccionada.equals("Seleccionar Medicamento...")) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un medicamento.");
            return;
        }

        String cantStr = txtCantidad.getText().trim();
        if (cantStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese una cantidad.");
            return;
        }

        try {
            int cantidadPedida = Integer.parseInt(cantStr);
            if (cantidadPedida <= 0) throw new NumberFormatException();

            File archivo = new File("inventario.csv");
            Map<String, Integer> inventario = new LinkedHashMap<>();
            boolean exito = false;

            // 1. Leer el inventario actual
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String cabecera = br.readLine();
                String l;
                while ((l = br.readLine()) != null) {
                    String[] d = l.split(",");
                    String med = d[0];
                    int stockActual = Integer.parseInt(d[1]);

                    if (med.equalsIgnoreCase(medicinaSeleccionada)) {
                        if (stockActual >= cantidadPedida) {
                            stockActual -= cantidadPedida;
                            exito = true;
                        } else {
                            JOptionPane.showMessageDialog(this, "Stock insuficiente. Disponible: " + stockActual);
                            return;
                        }
                    }
                    inventario.put(med, stockActual);
                }
            }

            // Guardado de información tras validación
            if (exito) {
                try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
                    pw.println("MEDICINA,STOCK");
                    for (Map.Entry<String, Integer> entry : inventario.entrySet()) {
                        pw.println(entry.getKey() + "," + entry.getValue());
                    }
                }
                JOptionPane.showMessageDialog(this, "Pedido solicitado con éxito.");
                txtCantidad.setText("");
                // Eliminación dentro del combo box si su valor llega a 0
                cargarMedicinasDisponibles();
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese una cantidad numérica válida.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error de archivo: " + e.getMessage());
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pEncabezadoP = new javax.swing.JPanel();
        lTituloP = new javax.swing.JLabel();
        lBienvenidaP = new javax.swing.JLabel();
        tabpPaciente = new javax.swing.JTabbedPane();
        panelAgendarCita = new javax.swing.JPanel();
        lblFecha = new javax.swing.JLabel();
        lblDia = new javax.swing.JLabel();
        lblMes = new javax.swing.JLabel();
        txtDia = new javax.swing.JTextField();
        txtMes = new javax.swing.JTextField();
        lblAnio = new javax.swing.JLabel();
        txtAnio = new javax.swing.JTextField();
        lblHora = new javax.swing.JLabel();
        cmbHorario = new javax.swing.JComboBox<>();
        lbMedico = new javax.swing.JLabel();
        cmbMedico = new javax.swing.JComboBox<>();
        lblMotivo1 = new javax.swing.JLabel();
        scrpMotivoC = new javax.swing.JScrollPane();
        txtMotivo = new javax.swing.JTextArea();
        btnLimpiarFormulario = new javax.swing.JButton();
        btnAgendarCita = new javax.swing.JButton();
        panelMisCitas = new javax.swing.JPanel();
        scrpCitas = new javax.swing.JScrollPane();
        tablaMisCitas = new javax.swing.JTable();
        btnRefrescar = new javax.swing.JButton();
        btnReprogramar = new javax.swing.JButton();
        btnCancelarCita = new javax.swing.JButton();
        panelMedicamentos = new javax.swing.JPanel();
        lMedicinaS = new javax.swing.JLabel();
        cbMedicamento = new javax.swing.JComboBox<>();
        lCantidad = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        bSolicitarM = new javax.swing.JButton();
        bCerrarSesionP = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pEncabezadoP.setBackground(new java.awt.Color(70, 130, 180));
        pEncabezadoP.setPreferredSize(new java.awt.Dimension(950, 90));
        pEncabezadoP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lTituloP.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lTituloP.setForeground(new java.awt.Color(255, 255, 255));
        lTituloP.setText("Portal del Paciente");
        pEncabezadoP.add(lTituloP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 25, -1, -1));

        lBienvenidaP.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lBienvenidaP.setForeground(new java.awt.Color(255, 255, 255));
        lBienvenidaP.setText("Bienvenido/a, Paciente");
        lBienvenidaP.setPreferredSize(new java.awt.Dimension(250, 30));
        pEncabezadoP.add(lBienvenidaP, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, -1, -1));

        getContentPane().add(pEncabezadoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        tabpPaciente.setPreferredSize(new java.awt.Dimension(930, 500));

        panelAgendarCita.setBackground(new java.awt.Color(255, 255, 255));
        panelAgendarCita.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFecha.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblFecha.setText("Fecha de la cita: ");
        panelAgendarCita.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        lblDia.setText("Dia:");
        panelAgendarCita.add(lblDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 45, -1, -1));

        lblMes.setText("Mes: ");
        panelAgendarCita.add(lblMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 45, -1, -1));

        txtDia.setToolTipText("Día (1 - 31)");
        txtDia.setPreferredSize(new java.awt.Dimension(60, 25));
        panelAgendarCita.add(txtDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 65, -1, -1));

        txtMes.setToolTipText("Mes (1 - 12)");
        txtMes.setPreferredSize(new java.awt.Dimension(60, 25));
        panelAgendarCita.add(txtMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 65, -1, -1));

        lblAnio.setText("Año: ");
        lblAnio.setPreferredSize(new java.awt.Dimension(40, 20));
        panelAgendarCita.add(lblAnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 45, -1, -1));

        txtAnio.setText("2026");
        txtAnio.setToolTipText("Año (AAAA)");
        txtAnio.setPreferredSize(new java.awt.Dimension(100, 25));
        panelAgendarCita.add(txtAnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 65, -1, -1));

        lblHora.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblHora.setText("Horario: ");
        panelAgendarCita.add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 105, -1, -1));

        cmbHorario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar horario", "07:00 - 08:00", "08:00 - 09:00", "09:00 - 10:00", "10:00 - 11:00", "11:00 - 12:00", "12:00 - 13:00", "13:00 - 14:00", "14:00 - 15:00", "15:00 - 16:00" }));
        cmbHorario.setPreferredSize(new java.awt.Dimension(250, 25));
        panelAgendarCita.add(cmbHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 125, -1, -1));

        lbMedico.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lbMedico.setText("Médico: ");
        panelAgendarCita.add(lbMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 165, -1, -1));

        cmbMedico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar médico", "Dr. Estéfano Chavez", "Dr. Claris Delgado", " " }));
        cmbMedico.setPreferredSize(new java.awt.Dimension(250, 25));
        panelAgendarCita.add(cmbMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 185, -1, -1));

        lblMotivo1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblMotivo1.setText("Motivo de la consulta:");
        panelAgendarCita.add(lblMotivo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 225, -1, -1));

        scrpMotivoC.setPreferredSize(new java.awt.Dimension(600, 80));

        txtMotivo.setColumns(20);
        txtMotivo.setLineWrap(true);
        txtMotivo.setRows(4);
        txtMotivo.setWrapStyleWord(true);
        scrpMotivoC.setViewportView(txtMotivo);

        panelAgendarCita.add(scrpMotivoC, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 245, -1, -1));

        btnLimpiarFormulario.setBackground(new java.awt.Color(100, 149, 237));
        btnLimpiarFormulario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLimpiarFormulario.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiarFormulario.setText("Limpiar");
        btnLimpiarFormulario.setFocusPainted(false);
        btnLimpiarFormulario.setPreferredSize(new java.awt.Dimension(120, 35));
        btnLimpiarFormulario.addActionListener(this::btnLimpiarFormularioActionPerformed);
        panelAgendarCita.add(btnLimpiarFormulario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, -1, -1));

        btnAgendarCita.setBackground(new java.awt.Color(60, 179, 113));
        btnAgendarCita.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAgendarCita.setForeground(new java.awt.Color(255, 255, 255));
        btnAgendarCita.setText("Agendar Cita");
        btnAgendarCita.setFocusPainted(false);
        btnAgendarCita.setPreferredSize(new java.awt.Dimension(120, 35));
        btnAgendarCita.addActionListener(this::btnAgendarCitaActionPerformed);
        panelAgendarCita.add(btnAgendarCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 400, -1, -1));

        tabpPaciente.addTab("Agendar Cita", panelAgendarCita);

        panelMisCitas.setBackground(new java.awt.Color(255, 255, 255));
        panelMisCitas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scrpCitas.setPreferredSize(new java.awt.Dimension(900, 400));

        tablaMisCitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Fecha", "Hora", "Médico", "Especialidad", "Motivo", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaMisCitas.setRowHeight(25);
        scrpCitas.setViewportView(tablaMisCitas);

        panelMisCitas.add(scrpCitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        btnRefrescar.setBackground(new java.awt.Color(100, 149, 237));
        btnRefrescar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRefrescar.setForeground(new java.awt.Color(255, 255, 255));
        btnRefrescar.setText("Refrescar");
        btnRefrescar.setFocusPainted(false);
        btnRefrescar.setPreferredSize(new java.awt.Dimension(120, 35));
        btnRefrescar.addActionListener(this::btnRefrescarActionPerformed);
        panelMisCitas.add(btnRefrescar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 420, -1, -1));

        btnReprogramar.setBackground(new java.awt.Color(255, 140, 0));
        btnReprogramar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReprogramar.setForeground(new java.awt.Color(255, 255, 255));
        btnReprogramar.setText("Reprogramar");
        btnReprogramar.setFocusPainted(false);
        btnReprogramar.setPreferredSize(new java.awt.Dimension(130, 35));
        btnReprogramar.addActionListener(this::btnReprogramarActionPerformed);
        panelMisCitas.add(btnReprogramar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 420, -1, -1));

        btnCancelarCita.setBackground(new java.awt.Color(220, 20, 60));
        btnCancelarCita.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancelarCita.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelarCita.setText("Cancelar cita");
        btnCancelarCita.setFocusPainted(false);
        btnCancelarCita.setPreferredSize(new java.awt.Dimension(120, 35));
        btnCancelarCita.addActionListener(this::btnCancelarCitaActionPerformed);
        panelMisCitas.add(btnCancelarCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 420, -1, -1));

        tabpPaciente.addTab("Mis citas", panelMisCitas);

        lMedicinaS.setText("Medicina a solicitar");
        panelMedicamentos.add(lMedicinaS);

        cbMedicamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escoja un medicamento" }));
        panelMedicamentos.add(cbMedicamento);

        lCantidad.setText("Cantidad");
        panelMedicamentos.add(lCantidad);

        txtCantidad.addActionListener(this::txtCantidadActionPerformed);
        panelMedicamentos.add(txtCantidad);

        bSolicitarM.setText("Solicitar");
        bSolicitarM.addActionListener(this::bSolicitarMActionPerformed);
        panelMedicamentos.add(bSolicitarM);

        tabpPaciente.addTab("Solicitar Medicamento", panelMedicamentos);

        getContentPane().add(tabpPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        bCerrarSesionP.setBackground(new java.awt.Color(220, 20, 60));
        bCerrarSesionP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bCerrarSesionP.setForeground(new java.awt.Color(255, 255, 255));
        bCerrarSesionP.setText("Cerrar Sesión");
        bCerrarSesionP.setPreferredSize(new java.awt.Dimension(130, 27));
        bCerrarSesionP.addActionListener(this::bCerrarSesionPActionPerformed);
        getContentPane().add(bCerrarSesionP, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 610, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgendarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendarCitaActionPerformed
        // TODO add your handling code here:
        String dia = txtDia.getText().trim();
    String mes = txtMes.getText().trim();
    String anio = txtAnio.getText().trim();
    
    if (dia.isEmpty() || mes.isEmpty() || anio.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Debe completar la fecha (día, mes y año)");
        return;
    }
    
    // Validar que sean números
    try {
        int diaNum = Integer.parseInt(dia);
        int mesNum = Integer.parseInt(mes);
        int anioNum = Integer.parseInt(anio);
        
        if (diaNum < 1 || diaNum > 31) {
            JOptionPane.showMessageDialog(this, "El día debe estar entre 1 y 31");
            return;
        }
        if (mesNum < 1 || mesNum > 12) {
            JOptionPane.showMessageDialog(this, "El mes debe estar entre 1 y 12");
            return;
        }
        if (anioNum < 2026) {
            JOptionPane.showMessageDialog(this, "El año debe ser 2026 o posterior");
            return;
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "La fecha debe contener solo números");
        return;
    }
    
    if (cmbHorario.getSelectedIndex() == 0) {
        JOptionPane.showMessageDialog(this, "Debe seleccionar un horario");
        return;
    }
    
    
    if (cmbMedico.getSelectedIndex() == 0) {
        JOptionPane.showMessageDialog(this, "Debe seleccionar un médico");
        return;
    }
    
    if (txtMotivo.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Debe ingresar el motivo de la consulta");
        return;
    }
    
    // Crear la cita
    String idCita = "C" + String.format("%03d", misCitas.size() + 100);
    String fechaStr = String.format("%02d/%02d/%s", Integer.parseInt(dia), Integer.parseInt(mes), anio);
    String hora = cmbHorario.getSelectedItem().toString();
    String medico = cmbMedico.getSelectedItem().toString();
    String motivo = txtMotivo.getText().trim();
    
    CitaPaciente nuevaCita = new CitaPaciente(idCita, fechaStr, hora, medico, motivo, "Agendada");
    misCitas.add(nuevaCita);
    
    // Actualizar tabla
    DefaultTableModel modelo = (DefaultTableModel) tablaMisCitas.getModel();
    modelo.addRow(new Object[]{
        idCita, fechaStr, hora, medico, motivo, "Agendada"
    });
    
    JOptionPane.showMessageDialog(this, 
        "Cita agendada exitosamente\n\n" +
        "ID: " + idCita + "\n" +
        "Fecha: " + fechaStr + "\n" +
        "Hora: " + hora + "\n" +
        "Médico: " + medico,
        "Cita Agendada", JOptionPane.INFORMATION_MESSAGE);
    
    limpiarFormulario();
    tabpPaciente.setSelectedIndex(1);    
    }//GEN-LAST:event_btnAgendarCitaActionPerformed

    private void btnLimpiarFormularioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarFormularioActionPerformed
        // TODO add your handling code here:
        limpiarFormulario();
    }//GEN-LAST:event_btnLimpiarFormularioActionPerformed

    private void btnCancelarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCitaActionPerformed
        // TODO add your handling code here:
            int fila = tablaMisCitas.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione una cita para cancelar");
        return;
    }
    
    String estado = (String) tablaMisCitas.getValueAt(fila, 6);
    if (!estado.equals("Agendada")) {
        JOptionPane.showMessageDialog(this, "Solo puede cancelar citas agendadas");
        return;
    }
    
    int confirmacion = JOptionPane.showConfirmDialog(this, 
        "¿Está seguro que desea cancelar esta cita?", 
        "Confirmar Cancelación", JOptionPane.YES_NO_OPTION);
    
    if (confirmacion == JOptionPane.YES_OPTION) {
        tablaMisCitas.setValueAt("Cancelada", fila, 6);
        misCitas.get(fila).setEstado("Cancelada");
        JOptionPane.showMessageDialog(this, "Cita cancelada exitosamente");
    }   
    }//GEN-LAST:event_btnCancelarCitaActionPerformed

    private void btnReprogramarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReprogramarActionPerformed
        // TODO add your handling code here:
            int fila = tablaMisCitas.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione una cita para reprogramar");
        return;
    }
    
    String estado = (String) tablaMisCitas.getValueAt(fila, 6);
    if (!estado.equals("Agendada")) {
        JOptionPane.showMessageDialog(this, "Solo puede reprogramar citas agendadas");
        return;
    }
    
    JOptionPane.showMessageDialog(this, 
        "Para reprogramar, cancele esta cita y agende una nueva en la fecha deseada",
        "Reprogramar Cita", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnReprogramarActionPerformed

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Tabla actualizada");
    }//GEN-LAST:event_btnRefrescarActionPerformed

    private void bCerrarSesionPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCerrarSesionPActionPerformed
        // TODO add your handling code here:
        int respuesta = JOptionPane.showConfirmDialog(this, 
        "¿Está seguro que desea cerrar sesión?", 
        "Confirmar", JOptionPane.YES_NO_OPTION);
    
    if (respuesta == JOptionPane.YES_OPTION) {
        frmlogin login = new frmlogin();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
        this.dispose();
    }
    }//GEN-LAST:event_bCerrarSesionPActionPerformed

    private void bSolicitarMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSolicitarMActionPerformed
        // TODO add your handling code here:
        procesarPedido();
    }//GEN-LAST:event_bSolicitarMActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed
    
    private void limpiarFormulario() {
    txtDia.setText("");
    txtMes.setText("");
    txtAnio.setText("2026");
    cmbHorario.setSelectedIndex(0);
    cmbMedico.setSelectedIndex(0);
    txtMotivo.setText("");
}
    private void cargarDatosEjemplo() {
    DefaultTableModel modelo = (DefaultTableModel) tablaMisCitas.getModel();
    modelo.addRow(new Object[]{
        "C098", "25/01/2026", "09:00 - 10:00", "Dr. Estéfano Chávez", 
        "Medicina General", "Chequeo anual", "Agendada"
    });
    modelo.addRow(new Object[]{
        "C075", "15/01/2026", "10:00 - 11:00", "Dra. Claris Delgado", 
        "Medicina General", "Dolor de cabeza", "Atendida"
    });
}
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new frmPaciente().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCerrarSesionP;
    private javax.swing.JButton bSolicitarM;
    private javax.swing.JButton btnAgendarCita;
    private javax.swing.JButton btnCancelarCita;
    private javax.swing.JButton btnLimpiarFormulario;
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JButton btnReprogramar;
    private javax.swing.JComboBox<String> cbMedicamento;
    private javax.swing.JComboBox<String> cmbHorario;
    private javax.swing.JComboBox<String> cmbMedico;
    private javax.swing.JLabel lBienvenidaP;
    private javax.swing.JLabel lCantidad;
    private javax.swing.JLabel lMedicinaS;
    private javax.swing.JLabel lTituloP;
    private javax.swing.JLabel lbMedico;
    private javax.swing.JLabel lblAnio;
    private javax.swing.JLabel lblDia;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblMes;
    private javax.swing.JLabel lblMotivo1;
    private javax.swing.JPanel pEncabezadoP;
    private javax.swing.JPanel panelAgendarCita;
    private javax.swing.JPanel panelMedicamentos;
    private javax.swing.JPanel panelMisCitas;
    private javax.swing.JScrollPane scrpCitas;
    private javax.swing.JScrollPane scrpMotivoC;
    private javax.swing.JTable tablaMisCitas;
    private javax.swing.JTabbedPane tabpPaciente;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDia;
    private javax.swing.JTextField txtMes;
    private javax.swing.JTextArea txtMotivo;
    // End of variables declaration//GEN-END:variables

        
    class CitaPaciente {
    private String idCita;
    private String fecha;
    private String hora;
    private String medico;
    private String motivo;
    private String estado;
    
    public CitaPaciente(String idCita, String fecha, String hora, String medico, String motivo, String estado) {
        this.idCita = idCita;
        this.fecha = fecha;
        this.hora = hora;
        this.medico = medico;
        this.motivo = motivo;
        this.estado = estado;
    }
    
    public String getIdCita() { return idCita; }
    public String getFecha() { return fecha; }
    public String getHora() { return hora; }
    public String getMedico() { return medico; }
    public String getMotivo() { return motivo; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
}
