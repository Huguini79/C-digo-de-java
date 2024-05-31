import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javax.swing.JOptionPane;
import java.io.*;
import java.net.*;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Javafxproyecto extends Application {
    public static String momento;
    public static String[] array_de_datos;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button botón = new Button("Hola");
        Button botón2 = new Button("Calculadora");
        Button botón3 = new Button("Adivinanza");
        Button botón4 = new Button("Conexión a la nasa");
        Button botón5 = new Button("Ventana swing para calculadora");
        Button botón7 = new Button("Buscador de ip");
        Button botón8 = new Button("Bloc de notas(otra swing)");
        Button botón10 = new Button("La información que has puesto");
        TextField texto = new TextField();
        VBox root = new VBox(10);
        root.getChildren().add(botón);
        botón.setMinSize(123, 80);
        texto.setMaxSize(123, 80);
        botón2.setMinSize(123, 80);
        botón4.setMinSize(123, 80);
        botón5.setMinSize(123, 80);
        botón7.setMinSize(123, 80);
        botón8.setMinSize(123, 80);
        botón10.setMinSize(123, 80);
        botón10.setOnAction(e ->  {
            JFrame frame3 = new JFrame("Información de la que has puesto tú");
            JLabel label = new JLabel(Arrays.toString(array_de_datos));
            frame3.requestFocusInWindow();
            frame3.setVisible(true);
            frame3.setSize(660, 550);
            frame3.setLayout(new FlowLayout());
            frame3.add(label);
        });
        botón10.setStyle("-fx-background-color: lightblue");
        botón8.setOnAction(e -> {
            JFrame frame2 = new JFrame("Bloc de notas(otra swing)");
            JTextField texto8 = new JTextField();
            JButton botón9 = new JButton("Enviar");
            frame2.requestFocusInWindow();
            frame2.setVisible(true);
            frame2.setSize(660, 550);
            frame2.setLayout(new FlowLayout());
            texto8.setPreferredSize(new Dimension(550, 660));
            frame2.add(texto8);
            frame2.add(botón9);
            botón9.setBackground(Color.GREEN);
            frame2.getContentPane().setBackground(Color.YELLOW);
            botón9.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String texto9 = texto8.getText(); 
                    array_de_datos = new String[] {texto9};
                    JOptionPane.showMessageDialog(null, "La información que has puesto está guardada en una página, si quieres verla, dale al botón de la otra ventana y verás la información que has puesto.");
            }
            });
        });
        botón8.setStyle("-fx-background-color: red");
        botón7.setStyle("-fx-background-color: blue");
        botón7.setOnAction(e -> {
            String entradadeurl = JOptionPane.showInputDialog(null, "Dime la url de la que quieres obtener la ip.");
            try {
            InetAddress ip = InetAddress.getByName(entradadeurl);
            JOptionPane.showMessageDialog(null, "La ip del host/servidor es: "+ ip.getHostAddress());

            } catch(IOException e2) {
                JOptionPane.showMessageDialog(null, "No se ha podido obtener la ip del host/servidor.");
            }
        });
        botón5.setOnAction(e -> {
            JFrame frame = new JFrame("Ventana swing");
            JTextField texto3 = new JTextField();
            JTextField texto4 = new JTextField();
            JTextField texto5 = new JTextField();
            JButton botón6 = new JButton("Enviar");
            frame.requestFocusInWindow();
            frame.setVisible(true);
            frame.setSize(660, 550);
            frame.getContentPane().setBackground(Color.YELLOW);
            frame.add(texto3);
            frame.add(texto4);
            frame.add(texto5);
            frame.add(botón6);
            frame.setLayout(new FlowLayout());
            texto3.setPreferredSize(new Dimension(123, 80));
            texto4.setPreferredSize(new Dimension(123, 80));
            texto5.setPreferredSize(new Dimension(123, 80));
            botón6.setBackground(Color.RED);
            botón6.setPreferredSize(new Dimension(123, 80));
            botón6.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    double texto6 = Double.parseDouble(texto3.getText());
                    String operador2 = texto4.getText();
                    double texto7 = Double.parseDouble(texto5.getText());
                    if(operador2.equals("+")) {
                        double suma = texto6 + texto7;
                        JOptionPane.showMessageDialog(null, "El resultado de la suma es: "+ suma);

                    } else if(operador2.equals("-")) {
                        double resta = texto6 - texto7;
                        JOptionPane.showMessageDialog(null, "El resultado de la resta es: "+ resta);

                    } else if(operador2.equals("*")) {
                        double multiplicación = texto6 * texto7;
                        JOptionPane.showMessageDialog(null, "El resultado de la multiplicación es: "+ multiplicación);

                    } else if(operador2.equals("/")) {
                        double división = texto6 / texto7;
                        JOptionPane.showMessageDialog(null, "El resultado de la división es: "+ división);
                    }
                }
            });
        });
        botón5.setStyle("-fx-background-color: lightgreen");
        botón4.setOnAction(e -> {
            try(Socket conexión = new Socket("192.0.66.108", 443)) {
                JOptionPane.showMessageDialog(null, "Conexión exitosa a la nasa, que tiene la ip 192.0.66.108 y el puerto 443.");
            } catch(IOException e1) {
                JOptionPane.showMessageDialog(null, "Conexión a la nasa fallida.");
            }
        });
        botón4.setStyle("-fx-background-color: orange");
        botón2.setStyle("-fx-background-color: green");
        root.setStyle("-fx-background-color: yellow");
        root.getChildren().add(botón2);
        root.getChildren().add(texto);
        root.getChildren().add(botón3);
        root.getChildren().add(botón4);
        root.getChildren().add(botón5);
        root.getChildren().add(botón7);
        root.getChildren().add(botón8);
        root.getChildren().add(botón10);
        botón3.setStyle("-fx-background-color: lightblue");
        botón3.setMinSize(123, 80);
        botón3.setOnAction(e -> {
            String texto2 = texto.getText();
            JOptionPane.showMessageDialog(null, "Has dicho: "+ texto2);
        });
        botón.setStyle("-fx-background-color: red");
        botón.setOnAction(e -> {
            JOptionPane.showMessageDialog(null, "Hola");
        });
        botón2.setOnAction(e -> {
            double número1 = Double.parseDouble(JOptionPane.showInputDialog("Dime un número."));
            String operador = JOptionPane.showInputDialog("Dime el operador.");
            double número2 = Double.parseDouble(JOptionPane.showInputDialog("Dime el último número."));
            if(operador.equals("+")) {
                double suma = número1 + número2;
                JOptionPane.showMessageDialog(null, "El resultado de la suma es: "+ suma);

            } else if(operador.equals("-")) {
                double resta = número1 - número2;
                JOptionPane.showMessageDialog(null, "El resultado de la resta es: "+ resta);

            } else if(operador.equals("*")) {
                double multiplicación = número1 * número2;
                JOptionPane.showMessageDialog(null, "El resultado de la multiplicación es: "+ multiplicación);

            } else if(operador.equals("/")) {
                double división = número1 / número2;
                JOptionPane.showMessageDialog(null, "El resultado de la división es: "+ división);

            } else {
                JOptionPane.showMessageDialog(null, "No te he entendido.");
            }
        });
        Scene scena = new Scene(root, 660, 550);
        primaryStage.setTitle("Mi primer programa en javafx");
        primaryStage.setScene(scena);
        primaryStage.show();
    }
    public static void main(String[] args) throws IOException {
        launch(args);
    }
}