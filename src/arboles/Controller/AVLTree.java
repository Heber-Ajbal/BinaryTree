/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles.Controller;

import arboles.Model.AVLNode;
import arboles.Model.Student;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Heber
 */
public class AVLTree {
     private AVLNode root;

    public AVLNode getRoot() {
        return root;
    }   

    public void setRoot(AVLNode root) {
        this.root = root;
    }
    
     
    // Método para obtener la altura de un nodo
    private int height(AVLNode node) {
        if (node == null)
            return 0;
        return node.getHeight();
    }
    
    // Método para obtener el balance de un nodo
    private int getBalance(AVLNode node) {
        if (node == null)
            return 0;
        return height(node.getLeft()) - height(node.getRight());
    }
    
    // Método para rotar a la derecha
    private AVLNode rotateRight(AVLNode y) {
        AVLNode x = y.getLeft();
        AVLNode T2 = x.getRight();

        // Realizar la rotación
        x.setRight(y);
        y.setLeft(T2);

        // Actualizar alturas
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);

        return x;
    }
    
    private AVLNode rotateLeft(AVLNode x) {
        AVLNode y = x.getRight();
        AVLNode T2 = y.getLeft();

        // Realizar la rotación
        y.setLeft(x);
        x.setRight(T2);

        // Actualizar alturas
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);

        return y;
    }
    
     // Método para insertar un nuevo nodo en el árbol AVL
    public AVLNode insert(AVLNode node, Student data) {
        // Paso 1: Realizar la inserción normal de un árbol binario de búsqueda
        if (node == null)
            return new AVLNode(data);

        if (data.getId().compareTo(node.getData().getId()) < 0)
            node.setLeft(insert(node.getLeft(), data));
        else if (data.getId().compareTo(node.getData().getId()) > 0)
            node.setRight(insert(node.getRight(), data));
        else // Duplicados no permitidos
            return node;

        // Paso 2: Actualizar la altura de este nodo ancestral
        node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));

        // Paso 3: Obtener el balance del nodo para verificar si se desequilibra
        int balance = getBalance(node);

        // Si el nodo se desequilibra, hay cuatro casos

        // Caso izquierda-izquierda
        if (balance > 1 && data.getId().compareTo(node.getLeft().getData().getId()) < 0)
            return rotateRight(node);

        // Caso derecha-derecha
        if (balance < -1 && data.getId().compareTo(node.getRight().getData().getId()) > 0)
            return rotateLeft(node);

        // Caso izquierda-derecha
        if (balance > 1 && data.getId().compareTo(node.getLeft().getData().getId()) > 0) {
            node.setLeft(rotateLeft(node.getLeft()));
            return rotateRight(node);
        }

        // Caso derecha-izquierda
        if (balance < -1 && data.getId().compareTo(node.getRight().getData().getId()) < 0) {
            node.setRight(rotateRight(node.getRight()));
            return rotateLeft(node);
        }

        // Si el nodo no está desequilibrado, simplemente devuelve el nodo sin cambios
        return node;
    }
    
    public void inorder() {
        inorder(root);
    }

    private void inorder(AVLNode node) {
        if (node != null) {
            inorder(node.getLeft());
            //System.out.println("Nombre: " + node.getData().getLastName() + ", Carnet: " + node.getData().getId());
            
            // Se define el nombre del archivo
            String nombreArchivo = "D:\\Heber\\Documents\\Proyectos Java\\Arboles\\src\\arboles\\Data\\ArbolAVL.txt";
        
        // Se abre el archivo para escritura
        try (FileWriter writer = new FileWriter(nombreArchivo, true)) {
            // Se escribe en el archivo cada dato separado por un ;
            writer.write("Nombre: " + node.getData().getLastName() + "; Carnet: " + node.getData().getId() + "\n");
            // Se cierra el writer
            writer.close();
            System.out.println("Datos guardados en el archivo correctamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
            
            inorder(node.getRight());
        }
    }
}
