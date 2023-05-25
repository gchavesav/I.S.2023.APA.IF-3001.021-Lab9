package controller;

import domain.BTree;
import domain.BTreeNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class BTreeOperationsController
{


    @FXML
    private Pane drawPane;
    private BTree bTree;

    @FXML
    public void initialize() {
        randomize(20);
        drawTree(bTree.getRoot(), 400, 50, 350);
    }
    @FXML
    void onActionRandomize(ActionEvent event) {
        drawPane.getChildren().clear();
        randomize(20);
        drawTree(bTree.getRoot(), 400, 50, 350);
    }

    @FXML
    void onActionAdd(ActionEvent event) {

    }

    @FXML
    void onActionContains(ActionEvent event) {

    }

    @FXML
    void onActionNodeHeight(ActionEvent event) {

    }


    @FXML
    void onActionRemove(ActionEvent event) {

    }

    @FXML
    void onActionTreeHeight(ActionEvent event) {

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
                drawPane.getChildren().add(line);
            }

            if (node.right != null) {
                double childX = x + levelWidth / 2;
                double childY = y + 50;
                drawTree(node.right, childX, childY, levelWidth / 2);

                // Dibujar una línea desde el nodo actual al nodo hijo derecho
                Line line = new Line(x, y, childX, childY - 20);
                drawPane.getChildren().add(line);
            }

            // Dibujar el nodo actual como un círculo después de las líneas
            Circle circle = new Circle(x, y, 20);
            circle.setFill(Color.LIGHTGREEN); // Cambiar el color a verde claro
            drawPane.getChildren().add(circle);

            // Mostrar el valor del nodo
            Text text = new Text(String.valueOf(node.data));
            text.setX(x - 5);
            text.setY(y + 5);
            drawPane.getChildren().add(text);
        }
    }

    private void randomize(int n){
        bTree = new BTree();
        for (int i = 0; i < n; i++) {
            bTree.add(util.Utility.random(50));
        }
    }
}