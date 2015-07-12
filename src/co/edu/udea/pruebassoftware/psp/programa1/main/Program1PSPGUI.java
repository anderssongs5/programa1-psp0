package co.edu.udea.pruebassoftware.psp.programa1.main;

import co.edu.udea.pruebassoftware.psp.programa1.controller.OperationController;
import static co.edu.udea.pruebassoftware.psp.programa1.util.constants.Constants.FILE_EXTENSION;
import co.edu.udea.pruebassoftware.psp.programa1.controller.Program1PSPController;
import co.edu.udea.pruebassoftware.psp.programa1.linkedlist.LinkedList;
import co.edu.udea.pruebassoftware.psp.programa1.util.enums.MessageEnums;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

public class Program1PSPGUI extends JFrame {

    private static final JFileChooser FILE_CHOOSER;
    private File selectedFile;
    private final Program1PSPController guiController;
    private OperationController operationController;
    private static final ImageIcon ERROR_IMAGE
            = new ImageIcon(Program1PSPGUI.class
                    .getResource("/co/edu/udea/pruebassoftware/psp/programa1/gui/"
                            + "images/ic_dialog_error.png"));
    private static final ImageIcon WARNING_IMAGE
            = new ImageIcon(Program1PSPGUI.class
                    .getResource("/co/edu/udea/pruebassoftware/psp/programa1/gui/"
                            + "images/ic_dialog_warning.png"));

    static {
        FILE_CHOOSER = new JFileChooser();

        FILE_CHOOSER.setFileFilter(new FileFilter() {
            @Override()
            public boolean accept(File pathname) {
                return (pathname.getAbsolutePath().endsWith(FILE_EXTENSION));
            }

            @Override()
            public String getDescription() {
                return ("Archivo de texto plano (*" + FILE_EXTENSION + ")");
            }
        });
        FILE_CHOOSER.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FILE_CHOOSER.setDialogTitle("Seleccionar archivo a procesar...");
    }

    public Program1PSPGUI() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.guiController = new Program1PSPController();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        selectFile = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        meanLabel = new javax.swing.JLabel();
        stdLabel = new javax.swing.JLabel();
        meanTextField = new javax.swing.JTextField();
        stdTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        selectFile.setText("Seleccionar");
        selectFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectFileActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Seleccione el archivo a procesar");

        meanLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        meanLabel.setText("Media");

        stdLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        stdLabel.setText("Desviación Estándar");

        meanTextField.setEditable(false);
        meanTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        stdTextField.setEditable(false);
        stdTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(stdLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(stdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(meanLabel)
                                .addGap(118, 118, 118)
                                .addComponent(meanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(selectFile))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jLabel1)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(selectFile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(meanLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(meanTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(stdLabel)
                    .addComponent(stdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectFileActionPerformed
        this.clean();
        
        FILE_CHOOSER.showOpenDialog(this);

        this.selectedFile = FILE_CHOOSER.getSelectedFile();
        boolean correct = this.guiController.checkFile(selectedFile);

        if (!correct) {
            if (this.selectedFile == null) {
                this.showMessage(MessageEnums.FILE_NOT_SELECTED, false);
            } else {
                this.showMessage(MessageEnums.EXTENSION_NOT_VALID, true);
            }
        } else {
            LinkedList linkedList;
            try {
                linkedList = this.guiController.readFile(selectedFile);
                if (linkedList != null) {
                    this.operationController = new OperationController(linkedList);
                    this.meanTextField.setText(String.valueOf(
                            this.operationController.mean()));
                    this.stdTextField.setText(String.valueOf(
                            this.operationController.std()));
                } else {
                    this.showMessage(MessageEnums.ERROR_READING_NUMBERS, true);
                }
            } catch (IOException ex) {
                showMessage(MessageEnums.INTERNAL_ERROR, true);
            }
        }
    }//GEN-LAST:event_selectFileActionPerformed

    private void clean(){
        FILE_CHOOSER.setSelectedFile(null);
        this.meanTextField.setText("");
        this.stdTextField.setText("");
    }
    
    private void showMessage(MessageEnums message, boolean isError) {
        if (isError) {
            JOptionPane.showMessageDialog(this, message.getMessage(),
                    message.getTitle(),
                    JOptionPane.ERROR_MESSAGE, ERROR_IMAGE);
        } else {
            JOptionPane.showMessageDialog(this, message.getMessage(),
                    message.getTitle(),
                    JOptionPane.ERROR_MESSAGE, WARNING_IMAGE);
        }
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
            java.util.logging.Logger.getLogger(Program1PSPGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Program1PSPGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Program1PSPGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Program1PSPGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Program1PSPGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel meanLabel;
    private javax.swing.JTextField meanTextField;
    private javax.swing.JButton selectFile;
    private javax.swing.JLabel stdLabel;
    private javax.swing.JTextField stdTextField;
    // End of variables declaration//GEN-END:variables
}
