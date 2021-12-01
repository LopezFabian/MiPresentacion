package miPresentacion;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
/*
 * this is my presentation
 * @ 2043508 Fabian Lopez
 * version 1.2.1 26/11/2021
 */
public class GUI_Presentacion extends JFrame {
    //atributos
    private JButton miFoto,miHobby, misExpectativas;
    private JPanel panelBotones, panelDatos;
    private Titulos titulo;
    private JLabel labelImagen;
    private JTextArea textoExpectativas;
    private Escucha escucha;

    //metodos
    public GUI_Presentacion(){
        initGUI();

        this.setTitle("Mi Presentacion");
        this.setSize(600,540);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initGUI() {
        //layout
        escucha = new Escucha();

        titulo = new Titulos("Hola soy Fabian, oprime los botones para conocerme", Color.BLACK);
        this.add(titulo, BorderLayout.NORTH);

        panelDatos = new JPanel();
        panelDatos.setBorder(BorderFactory.createTitledBorder(null, "Un poco mas de mi...",
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,
                new Font("Calibri", Font.PLAIN, 20), Color.BLACK));

        this.add(panelDatos,BorderLayout.CENTER);

        miFoto= new JButton("Este soy yo");
        miFoto.addMouseListener(escucha);
        miHobby= new JButton("Este es mi hobby");
        miHobby.addMouseListener(escucha);
        misExpectativas= new JButton("Creo que");
        misExpectativas.addKeyListener(escucha);
        misExpectativas.setFocusable(true);

        panelBotones = new JPanel();
        panelBotones.add(miFoto);
        panelBotones.add(miHobby);
        panelBotones.add(misExpectativas);

        this.add(panelBotones,BorderLayout.SOUTH);

        labelImagen= new JLabel();
        textoExpectativas= new JTextArea(3,12);
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI_Presentacion miGUIPresentacion = new GUI_Presentacion();
            }
        });
    }


    /*
     * this class is used to listen to mouse and keyboard actions
     * @ 2043508 Fabian Lopez
     * version 1.2.1 26/11/2021
     */
    private class Escucha implements MouseListener, KeyListener {
        private ImageIcon image;

        @Override
        public void mouseClicked(MouseEvent e) {
            panelDatos.removeAll();
            if (e.getSource() == miFoto){
                image = new ImageIcon(getClass().getResource("/recursos/Yo.png"));
                labelImagen.setIcon(image);
                panelDatos.add(labelImagen);
            }else{
                if (e.getSource() == miHobby){
                    if(e.getClickCount() == 2){
                        image = new ImageIcon(getClass().getResource("/recursos/Tocar guitarra.jpg"));
                        labelImagen.setIcon(image);
                        panelDatos.add(labelImagen);
                    }
                }
            }
            revalidate();
            repaint();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void keyTyped(KeyEvent e) {
            panelDatos.removeAll();
            if(e.getSource() ==misExpectativas){
                if(e.getKeyChar()== 'm' ){
                    textoExpectativas.setText("Quiero aprender como funciona la programacion orientadada a objetos\n" +
                            "Quiero aprender mas de Java\n" +
                            "Quiero que mis conocimientos en la programacion sean mas amplios");
                    textoExpectativas.setBackground(Color.darkGray);
                    textoExpectativas.setForeground(Color.WHITE);
                    textoExpectativas.setFont(new Font(Font.DIALOG, Font.ROMAN_BASELINE, 17));
                    panelDatos.add(textoExpectativas);
                }
            }
            revalidate();
            repaint();
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}


