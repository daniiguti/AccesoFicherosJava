package Vista;

import Controlador.CtrlAlumnos;
import Modelo.Alumno;
import RecursosCompartidos.Recursos;
import static RecursosCompartidos.Recursos.alumnos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class VentanaPrincipal extends javax.swing.JFrame {
    
    DefaultTableModel modelo;
    
    int row;
    
    File myFile;
    
    CtrlAlumnos control;
    
    public VentanaPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        modelo = (DefaultTableModel) jTable1.getModel();
        control = new CtrlAlumnos();
        
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                row = jTable1.rowAtPoint(evt.getPoint());        
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btAlta = new javax.swing.JButton();
        btBaja = new javax.swing.JButton();
        btModificar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        tfAbrir = new javax.swing.JTextField();
        cbAbrir = new javax.swing.JComboBox<>();
        btSelector1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btAbrir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfGuardar = new javax.swing.JTextField();
        btSelector2 = new javax.swing.JButton();
        cbGuardar = new javax.swing.JComboBox<>();
        btGuardar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matricula", "Nombre Alumno", "Fecha Nacimiento", "Nota Media", "Edad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btAlta.setText("ALTA");
        btAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAltaActionPerformed(evt);
            }
        });

        btBaja.setText("BAJA");
        btBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBajaActionPerformed(evt);
            }
        });

        btModificar.setText("MODIFICAR");
        btModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarActionPerformed(evt);
            }
        });

        tfAbrir.setEditable(false);

        cbAbrir.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fichero objetos serializables", "Fichero de texto", "Fichero XML", "Fichero Directo" }));

        btSelector1.setText("ABRIR SELECTOR");
        btSelector1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelector1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Destino");

        jLabel2.setText("Nombre");

        btAbrir.setText("ABRIR");
        btAbrir.setEnabled(false);
        btAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAbrirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(88, 88, 88)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btAbrir)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbAbrir, 0, 212, Short.MAX_VALUE)
                            .addComponent(tfAbrir))
                        .addGap(144, 144, 144)
                        .addComponent(btSelector1)))
                .addGap(102, 102, 102))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSelector1)
                    .addComponent(jLabel2)
                    .addComponent(tfAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAbrir)
                .addContainerGap())
        );

        jLabel3.setText("Abrir Fichero");

        jLabel5.setText("Destino");

        jLabel6.setText("Nombre");

        tfGuardar.setEditable(false);

        btSelector2.setText("ABRIR SELECTOR");
        btSelector2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelector2ActionPerformed(evt);
            }
        });

        cbGuardar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fichero objetos serializables", "Fichero de texto", "Fichero XML", "Fichero Directo" }));

        btGuardar.setText("GUARDAR");
        btGuardar.setEnabled(false);
        btGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(83, 83, 83)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btGuardar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tfGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btSelector2)
                        .addGap(102, 102, 102))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSelector2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btGuardar)
                .addContainerGap())
        );

        jLabel4.setText("Guardar Fichero");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btBaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btAlta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 80, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btAlta)
                        .addGap(42, 42, 42)
                        .addComponent(btBaja)
                        .addGap(49, 49, 49)
                        .addComponent(btModificar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAltaActionPerformed
        DialogAlta dialogAlta = new DialogAlta(this, true);
        dialogAlta.setVisible(true);
        
        int numExp = Integer.parseInt(dialogAlta.etMatricula.getText());
        //comprobamos que no exista la matricula
        if(control.comprobarNumMatricula(numExp) == false){
            Date date = null;
            String nombre = dialogAlta.etNombre.getText();
            String fechaNac = dialogAlta.etFechaNacimiento.getText();
            try {
                date = new SimpleDateFormat("dd/MM/yyyy").parse(fechaNac);
            } catch (ParseException ex) {
                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            double notaMedia = Double.parseDouble(dialogAlta.etNotaMedia.getText());
            int edad = Integer.parseInt(dialogAlta.etEdad.getText());

            Alumno aux = new Alumno(numExp, nombre, date, notaMedia, edad);
            Recursos.alumnos.add(aux);
            actualizarTabla();
        }else{
            JOptionPane.showMessageDialog(this, "Numero de matricula existente, no se ha guardado el alumno");
        }    
    }//GEN-LAST:event_btAltaActionPerformed

    private void btBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBajaActionPerformed
             
        if(Recursos.alumnos.size() > 0 && jTable1.getSelectedRowCount() > 0){
            boolean salir = false;   
            int opcion = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar?");
            if(opcion == 0){
                int pulsado = (int)jTable1.getValueAt(row, 0);
                for(int i = 0; i < Recursos.alumnos.size() && salir == false; i++){
                    if(Recursos.alumnos.get(i).getNumMatricula() == pulsado){
                        Recursos.alumnos.remove(alumnos.get(i));
                        salir = true;
                    }
                }
                actualizarTabla();  
            }
            else{
                JOptionPane.showMessageDialog(this, "No se ha eliminado nada");
            }            
        }
        else{
            JOptionPane.showMessageDialog(this, "No hay registros o no se han pulsado ninguna fila");            
        }
    }//GEN-LAST:event_btBajaActionPerformed

    private void btModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarActionPerformed
        if(jTable1.getSelectedRowCount() > 0){
            Alumno aux = null;
            boolean salir = false;   
            int pulsado = (int)jTable1.getValueAt(row, 0);
            for(int i = 0; i < alumnos.size() && salir == false; i++){
                if(alumnos.get(i).getNumMatricula() == pulsado){
                    aux = alumnos.get(i);
                    alumnos.remove(i);
                    salir = true;
                }
            }
            //Metemos los datos seleccionados
            DialogAlta dialogAlta = new DialogAlta(this, true);
            dialogAlta.etMatricula.setText(aux.getNumMatricula() + "");
            dialogAlta.etMatricula.setEditable(false);
            dialogAlta.etNombre.setText(aux.getNombreAlumno());
            Date fecha = aux.getFechaNac();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String fechaNac = sdf.format(fecha);
            dialogAlta.etFechaNacimiento.setText(fechaNac);
            dialogAlta.etNotaMedia.setText(aux.getNotaMedia() + "");
            dialogAlta.etEdad.setText(aux.getEdad() + "");
            dialogAlta.setVisible(true);
            
            //Leemos los nuevos datos
            Date date = null;
            int numExp = Integer.parseInt(dialogAlta.etMatricula.getText());
            String nombre = dialogAlta.etNombre.getText();
            String fechaNac2 = dialogAlta.etFechaNacimiento.getText();
            try {
                date = new SimpleDateFormat("dd/MM/yyyy").parse(fechaNac);
            } catch (ParseException ex) {
                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            double notaMedia = Double.parseDouble(dialogAlta.etNotaMedia.getText());
            int edad = Integer.parseInt(dialogAlta.etEdad.getText());
        
            Alumno aux2 = new Alumno(numExp, nombre, date, notaMedia, edad);
            Recursos.alumnos.add(aux2);
            actualizarTabla();            
        }
        else{
            JOptionPane.showMessageDialog(this, "No hay registros o no se han pulsado ninguna fila");            
        }
    }//GEN-LAST:event_btModificarActionPerformed

    private void btSelector1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelector1ActionPerformed
        abrirFileChooser();
        tfAbrir.setText(myFile.getAbsolutePath());
        btAbrir.setEnabled(true);
    }//GEN-LAST:event_btSelector1ActionPerformed

    private void btAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAbrirActionPerformed
        int opcionPulsada = cbAbrir.getSelectedIndex();
        
        switch(opcionPulsada){
            //Abrimos Fichero de Objetos Serializables
            case 0:
                try{    
                    control.abrirFicheroSerializable(myFile);
                    JOptionPane.showMessageDialog(this, "Fichero abierto exitosamente");
                }catch(IOException ex){
                    JOptionPane.showConfirmDialog(this, "Error de lectura/escritura");
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showConfirmDialog(this, "Error de clase no encontrada");
                }
                break;
            //Abrimos Fichero de Texto
            case 1:
                try {              
                    control.abrirFicheroTexto(myFile);
                    JOptionPane.showMessageDialog(this, "Fichero abierto exitosamente");
                } catch (IOException ex) {
                    JOptionPane.showConfirmDialog(this, "Error de lectura/escritura");
                } catch (ParseException ex) {
                   JOptionPane.showConfirmDialog(this, "Error de Parseamiento");
                }
                break;
            //Abrimos fichero XML
            case 2:
                control.abrirFicheroXML(myFile);
                JOptionPane.showMessageDialog(this, "Fichero abierto exitosamente");
                break;
            //Abrimos fichero directo    
            case 3:
                control.abrirFicheroDirecto(myFile);
                JOptionPane.showMessageDialog(this, "Fichero abierto exitosamente");
                break;
        }
        
        //Actualizamos la tabla
        actualizarTabla();
    }//GEN-LAST:event_btAbrirActionPerformed

    private void btSelector2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelector2ActionPerformed
        abrirFileChooser();
        tfGuardar.setText(myFile.getAbsolutePath());
        btGuardar.setEnabled(true);
    }//GEN-LAST:event_btSelector2ActionPerformed

    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed
        int opcionPulsada = cbGuardar.getSelectedIndex();
        switch(opcionPulsada){
            //cargamos fichero Serializable
            case 0:
                try{    
                    control.guardarFicheroSerializable(myFile); 
                    JOptionPane.showMessageDialog(this, "Fichero guardado exitosamente");
                }catch(FileNotFoundException ex){
                    JOptionPane.showConfirmDialog(this, "Error de apertura de fichero");
                }    
                catch(IOException ex){
                    JOptionPane.showConfirmDialog(this, "Error de lectura/escritura");
                }       
                break;
            //cargamos fichero de texto
            case 1:
                try {              
                    control.guardarFicheroTexto(myFile);
                    JOptionPane.showMessageDialog(this, "Fichero guardado exitosamente");
                } catch (IOException ex) {
                    JOptionPane.showConfirmDialog(this, "Error de lectura/escritura");
                }               
                break;
            //cargamos fichero XML     
            case 2:
                control.guardarArchivoXML(myFile);
                JOptionPane.showMessageDialog(this, "Fichero guardado exitosamente");
                break;
            //cargamos fichero directo    
            case 3:
                control.guardarFicheroDirecto(myFile);
                JOptionPane.showMessageDialog(this, "Fichero guardado exitosamente");
                break;
        }   
    }//GEN-LAST:event_btGuardarActionPerformed
    
    //Método para actualizar la tabla cada vez que modifiquemos el array
    public void actualizarTabla(){
        modelo.setRowCount(0);
        for(Alumno aux: Recursos.alumnos){
            int numMatricula = aux.getNumMatricula();
            String nombre = aux.getNombreAlumno();
            Date fechaNacimiento = aux.getFechaNac();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
            String fecha = sdf.format(fechaNacimiento);
            double notaMedia = aux.getNotaMedia();
            int edad = aux.getEdad();
            
            modelo.addRow(new Object[]{numMatricula, nombre, fecha, notaMedia, edad});
        }
    }
    
    //Método para abrir un FileChooser
    public void abrirFileChooser(){
        JFileChooser jfc = new JFileChooser();
        int opcion = 0;
        do{
            opcion = jfc.showOpenDialog(jPanel1);
        }while(opcion != 0);
        myFile = jfc.getSelectedFile();
    }
    
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAbrir;
    private javax.swing.JButton btAlta;
    private javax.swing.JButton btBaja;
    private javax.swing.JButton btGuardar;
    private javax.swing.JButton btModificar;
    private javax.swing.JButton btSelector1;
    private javax.swing.JButton btSelector2;
    private javax.swing.JComboBox<String> cbAbrir;
    private javax.swing.JComboBox<String> cbGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField tfAbrir;
    private javax.swing.JTextField tfGuardar;
    // End of variables declaration//GEN-END:variables
}
