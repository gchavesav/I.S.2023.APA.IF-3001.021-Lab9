package controller;

import domain.BTree;
import domain.BTreeNode;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class bTreeOperations
{
    private BTree bTree; // Tu árbol binario

    private Group nodeGroup;
    @FXML
    private Pane tela;

    @FXML
    public void initialize() {
        // Crear una instancia de tu árbol binario
        bTree = new BTree();

        // Agregar elementos al árbol binario
        bTree.add(util.Utility.random(50));
        bTree.add(util.Utility.random(50));
        bTree.add(util.Utility.random(50));
        bTree.add(util.Utility.random(50));
        bTree.add(util.Utility.random(50));
        bTree.add(util.Utility.random(50));
        // ...

        // Crear el grupo de nodos para el árbol
        nodeGroup = new Group();

        // Dibujar el árbol
        drawTree(bTree.getRoot(), 400, 50, 200);

    }


    private void drawTree(BTreeNode node, double x, double y, double levelWidth) {
        if (node != null) {
            // Dibujar las conexiones con los nodos hijos primero
            if (node.left != null) {
                double childX = x - levelWidth / 2;
                double childY = y + 50;
                drawTree(node.left, childX, childY, levelWidth / 2);

                // Dibujar una línea desde el nodo actual al nodo hijo izquierdo
                Line line = new Line(x, y, childX, childY - 20);
                tela.getChildren().add(line);
            }

            if (node.right != null) {
                double childX = x + levelWidth / 2;
                double childY = y + 50;
                drawTree(node.right, childX, childY, levelWidth / 2);

                // Dibujar una línea desde el nodo actual al nodo hijo derecho
                Line line = new Line(x, y, childX, childY - 20);
                tela.getChildren().add(line);
            }

            // Dibujar el nodo actual como un círculo después de las líneas
            Circle circle = new Circle(x, y, 20);
            circle.setFill(Color.LIGHTGREEN); // Cambiar el color a verde claro
            tela.getChildren().add(circle);

            // Mostrar el valor del nodo
            Text text = new Text(String.valueOf(node.data));
            text.setX(x - 5);
            text.setY(y + 5);
            tela.getChildren().add(text);
        }
    }


}