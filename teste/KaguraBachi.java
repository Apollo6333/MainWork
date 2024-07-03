package teste;

import javax.swing.*;
import java.awt.*;

public class KaguraBachi extends JFrame {
    public KaguraBachi() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);

        // Substitua "seuArquivo.gif" pelo caminho do seu arquivo GIF
        ImageIcon icon = new ImageIcon("C:\\Users\\andre\\Downloads\\melhor anime do mundo.gif");
        JLabel label = new JLabel(icon);

        add(label, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new KaguraBachi());
    }
}

