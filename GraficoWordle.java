import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class GraficoWordle extends JFrame {
    private JPanel panel;
    private JLabel[][] tablero;

    public GraficoWordle() {
        this.setSize(800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Wordle");
        setLocationRelativeTo(null);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        colocarPaneles();
        colocarEtiqueta();
        colocarTablero();
        colocarBotones();
        this.add(panel);
        this.setVisible(true);
    }

    private void colocarBotones() {
        String[] letras = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
                "S", "T", "U", "V", "W", "X", "Y", "Z" };
        int[] posicionesX = { 40, 110, 180, 250, 320, 390, 460, 530, 600, 670, 40, 110, 180, 250, 320, 390, 460, 530,
                600, 670, 180, 250, 320, 390, 460, 530 };
        int[] posicionesY = { 450, 450, 450, 450, 450, 450, 450, 450, 450, 450, 500, 500, 500, 500, 500, 500, 500, 500,
                500, 500, 550, 550, 550, 550, 550, 550 };

        for (int i = 0; i < letras.length; i++) {
            JButton boton = new JButton(letras[i]);
            boton.setBounds(posicionesX[i], posicionesY[i], 45, 45);
            boton.setBackground(Color.WHITE);
            boton.addActionListener(new BotonListener());
            panel.add(boton);
        }
    }

    private void colocarPaneles() {
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }

    private void colocarEtiqueta() {
        JLabel t = new JLabel();
        t.setText("WORDLE");
        t.setBounds(255, 10, 300, 80);
        t.setHorizontalAlignment(SwingConstants.CENTER);
        t.setForeground(Color.BLACK);
        t.setFont(new Font("cooper black", 0, 40));
        panel.add(t);
    }

    public void colocarTablero() {
        int filas = 6;
        int columnas = 5;
        int x = 250;
        int y = 80;
        tablero = new JLabel[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = new JLabel();
                tablero[i][j].setBounds(x, y, 40, 40);
                tablero[i][j].setPreferredSize(new Dimension(50, 50));
                tablero[i][j].setOpaque(true);
                tablero[i][j].setBackground(Color.WHITE);
                tablero[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                panel.add(tablero[i][j]);
                x += 60;
            }
            x = 250;
            y += 60;
        }
    }

    private class BotonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton botonPresionado = (JButton) e.getSource();
            String letra = botonPresionado.getText();

            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 5; j++) {
                    if (mouseOverComponent(botonPresionado, tablero[i][j])) {
                        tablero[i][j].setText(letra);
                        break;
                    }
                }
            }
        }

        public boolean mouseOverComponent(JButton button, JLabel label) {
            int buttonX = button.getLocationOnScreen().x;
            int buttonY = button.getLocationOnScreen().y;
            int labelX = label.getLocationOnScreen().x;
            int labelY = label.getLocationOnScreen().y;

            int buttonWidth = button.getWidth();
            int buttonHeight = button.getHeight();
            int labelWidth = label.getWidth();
            int labelHeight = label.getHeight();

            return buttonX < labelX + labelWidth && buttonX + buttonWidth > labelX &&
                    buttonY < labelY + labelHeight && buttonY + buttonHeight > labelY;
        }
    }
}
