package domain;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BinaryTreeVisualizer extends Application {

    private BTree bTree; // Tu árbol binario

    private Group nodeGroup;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Crear una instancia de tu árbol binario
        bTree = new BTree();

        // Agregar elementos al árbol binario
        bTree.add(util.Utility.random(50));
        bTree.add(util.Utility.random(50));
        bTree.add(util.Utility.random(50));
        // ...

        // Crear el grupo de nodos para el árbol
        nodeGroup = new Group();

        // Dibujar el árbol
        drawTree(bTree.getRoot(), 400, 50, 200);

        // Crear la escena
        Scene scene = new Scene(nodeGroup, 800, 600);

        // Configurar la ventana principal
        primaryStage.setTitle("Binary Tree Visualization");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void drawTree(BTreeNode node, double x, double y, double levelWidth) {
        if (node != null) {
            // Dibujar el nodo actual como un círculo
            Circle circle = new Circle(x, y, 20);
            nodeGroup.getChildren().add(circle);

            // Mostrar el valor del nodo
            Text text = new Text(String.valueOf(node.data));
            text.setX(x - 5);
            text.setY(y + 5);
            nodeGroup.getChildren().add(text);

            // Dibujar las conexiones con los nodos hijos
            if (node.left != null) {
                double childX = x - levelWidth / 2;
                double childY = y + 50;
                drawTree(node.left, childX, childY, levelWidth / 2);

                // Dibujar una línea desde el nodo actual al nodo hijo izquierdo
                Line line = new Line(x, y, childX, childY - 20);
                nodeGroup.getChildren().add(line);
            }

            if (node.right != null) {
                double childX = x + levelWidth / 2;
                double childY = y + 50;
                drawTree(node.right, childX, childY, levelWidth / 2);

                // Dibujar una línea desde el nodo actual al nodo hijo derecho
                Line line = new Line(x, y, childX, childY - 20);
                nodeGroup.getChildren().add(line);
            }
        }
    }
}

