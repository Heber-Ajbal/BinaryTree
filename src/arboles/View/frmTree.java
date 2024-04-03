/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles.View;

import arboles.Controller.AVLTree;
import arboles.Controller.BinaryTree;
import arboles.Model.Student;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Heber
 */
public class frmTree extends javax.swing.JFrame {

    /**
     * Creates new form frmTree
     */
    List<Student> studentList = new ArrayList<>();
    public frmTree() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAVL = new javax.swing.JButton();
        btnBinary = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAVL.setText("Arbol AVL");
        btnAVL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAVLActionPerformed(evt);
            }
        });

        btnBinary.setText("Arbol Binario");
        btnBinary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBinaryActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 2, 14)); // NOI18N
        jLabel1.setText("ARBOLES");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBinary)
                            .addComponent(btnAVL, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(68, 68, 68))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(77, 77, 77))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(btnAVL)
                .addGap(27, 27, 27)
                .addComponent(btnBinary)
                .addGap(61, 61, 61))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAVLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAVLActionPerformed
         AVLTree tree = new AVLTree();

         
         try {
            File file = new File("D:\\Heber\\Documents\\DB.txt");
            Scanner scanner = new Scanner(file);

            // Saltar la primera línea que contiene los encabezados
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(";"); // Dividir la línea por tabulaciones

                // Asegurarse de que haya suficientes partes
                if (parts.length == 4) {
                    String codigo = parts[0];
                    String nombre = parts[1];
                    String apellido = parts[2];
                    String telefono = parts[3];

                    Student student = new Student(codigo, nombre, apellido, telefono);
                    tree.setRoot(tree.insert(tree.getRoot(), student));
                    studentList.add(student);
                } else {
                    System.out.println("Error: La línea no tiene el formato esperado: " + line);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: Archivo no encontrado.");
            e.printStackTrace();
        }
               
        /* Resultado del recorrido inorder */
        tree.inorder();
    }//GEN-LAST:event_btnAVLActionPerformed

    private void btnBinaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBinaryActionPerformed
         BinaryTree tree = new BinaryTree(); // Suponiendo que tienes una clase BinaryTree con métodos adecuados

        try {
            File file = new File("D:\\Heber\\Documents\\DB.txt");
            Scanner scanner = new Scanner(file);

            // Saltar la primera línea que contiene los encabezados
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(";"); // Dividir la línea por punto y coma

                // Asegurarse de que haya suficientes partes
                if (parts.length == 4) {
                    String codigo = parts[0];
                    String nombre = parts[1];
                    String apellido = parts[2];
                    String telefono = parts[3];

                    Student student = new Student(codigo, nombre, apellido, telefono);
                    tree.insert(student); // Insertar el estudiante en el árbol
                } else {
                    System.out.println("Error: La línea no tiene el formato esperado: " + line);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        tree.inOrderTraversal();
    }//GEN-LAST:event_btnBinaryActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmTree.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmTree.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmTree.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmTree.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmTree().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAVL;
    private javax.swing.JButton btnBinary;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
