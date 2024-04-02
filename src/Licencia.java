

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.*;

public class Licencia extends JFrame implements ActionListener, ChangeListener {

    private JLabel label1, label2;
    private JCheckBox check1;
    private JButton boton1, boton2;
    private JScrollPane scrollpane1;
    private JTextArea textarea1;
    String nombre = "";

    public Licencia() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Licencia de uso");
        setIconImage(new ImageIcon(getClass().getResource("/images/icon.png")).getImage());
        Bienvenida ventanaBienvenida = new Bienvenida();
        nombre = ventanaBienvenida.texto;

        label1 = new JLabel("TÉRMINOS Y CONDICIONES");
        label1.setBounds(215, 5, 200, 30);
        label1.setFont(new Font("Andale Mono", 1, 14));
        label1.setForeground(new Color(0, 0, 0));
        add(label1);

        textarea1 = new JTextArea();
        textarea1.setEditable(false);
        textarea1.setFont(new Font("Andale Mono", 0, 9));
        textarea1.setText(
                """


                                TÉRMINOS Y CONDICIONES
                                A. Uso Aceptable: Al utilizar esta aplicación, aceptas hacer un uso adecuado y responsable de todas las funciones y características
                                    proporcionadas.
                                B. Responsabilidad del Usuario: Eres responsable de cualquier acción que realices dentro de la aplicación y del contenido que compartas
                                    a través de ella.
                                C. Privacidad: Respetamos tu privacidad y nos comprometemos a proteger tus datos personales de acuerdo con nuestra política de privacidad.
                                D. Modificaciones: Nos reservamos el derecho de modificar o actualizar estos términos y condiciones en cualquier momento sin previo aviso.
                                E. Derechos de Autor: Todo el contenido proporcionado dentro de la aplicación está sujeto a derechos de autor y no puede ser utilizado de
                                    manera inapropiada o sin permiso.
                        """);
        scrollpane1 = new JScrollPane(textarea1);
        scrollpane1.setBounds(10,40,575,200);
        add(scrollpane1);

        check1 = new JCheckBox("Yo " + nombre + " Acepto");
        check1.setBounds(10,250,300,30);
        check1.addChangeListener(this);
        add(check1);

        boton1 = new JButton("Continuar");
        boton1.setBounds(10,290,100,30);
        boton1.addActionListener(this);
        boton1.setEnabled(false);
        add(boton1);

        boton2 = new JButton("No Acepto");
        boton2.setBounds(120,290,100,30);
        boton2.addActionListener(this);
        boton2.setEnabled(true);
        add(boton2);

        ImageIcon imagen = new ImageIcon("/images/coca-cola.png");
        label2 = new JLabel(imagen);
        label2.setBounds(315, 135, 300, 300);
        add(label2);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (check1.isSelected() == true) {
            boton1.setEnabled(true);
            boton2.setEnabled(false);
        } else {
            boton1.setEnabled(false);
            boton2.setEnabled(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1) {
            Principal ventanaPrincipal = new Principal();
            ventanaPrincipal.setBounds(0, 0, 640, 535);
            ventanaPrincipal.setVisible(true);
            ventanaPrincipal.setResizable(false);
            ventanaPrincipal.setLocationRelativeTo(null);
            this.setVisible(false);
        } else if (e.getSource() == boton2) {
            Bienvenida ventanabienvenida = new Bienvenida();
            ventanabienvenida.setBounds(0, 0, 350, 450);
            ventanabienvenida.setVisible(true);
            ventanabienvenida.setResizable(false);
            ventanabienvenida.setLocationRelativeTo(null);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        Licencia ventanaLicencia = new Licencia();
        ventanaLicencia.setBounds(0, 0, 600, 360);
        ventanaLicencia.setVisible(true);
        ventanaLicencia.setResizable(false);
        ventanaLicencia.setLocationRelativeTo(null);
    }
}
