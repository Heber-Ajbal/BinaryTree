/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles.Controller;

import arboles.Model.Student;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Heber
 */
public class BinaryTree {
    
private Node root;

    public BinaryTree() {
        root = null;
    }

    public void insert(Student student) {
        root = insertRecursive(root, student);
    }

    private Node insertRecursive(Node root, Student student) {
        if (root == null) {
            root = new Node(student);
            return root;
        }

        // Insertar según el código del estudiante
        if (student.getId().compareTo(root.student.getId()) < 0) {
            root.left = insertRecursive(root.left, student);
        } else if (student.getId().compareTo(root.student.getId()) > 0) {
            root.right = insertRecursive(root.right, student);
        }

        return root;
    }

    public void inOrderTraversal() {
        inOrderTraversalRecursive(root);
    }

    private void inOrderTraversalRecursive(Node root) {
        if (root != null) {
            inOrderTraversalRecursive(root.left);
            //System.out.println(root.student.getId() + ": " + root.student.getName()+ " " + root.student.getLastName());
            // Se define el nombre del archivo
            String nombreArchivo = "D:\\Heber\\Documents\\Proyectos Java\\Arboles\\src\\arboles\\Data\\BinaryTree.txt";
        
        // Se abre el archivo para escritura
        try (FileWriter writer = new FileWriter(nombreArchivo, true)) {
            // Se escribe en el archivo cada dato separado por un ;
            writer.write("Nombre: " + root.student.getName()+ "; Carnet: " + root.student.getId() + "\n");
            // Se cierra el writer
            writer.close();
            System.out.println("Datos guardados en el archivo correctamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
            inOrderTraversalRecursive(root.right);
        }
    }

    // Clase interna Node para representar los nodos del árbol
    private class Node {
        private Student student;
        private Node left;
        private Node right;

        public Node(Student student) {
            this.student = student;
            left = null;
            right = null;
        }
    }
    
}
