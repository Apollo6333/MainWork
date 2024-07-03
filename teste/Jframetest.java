package teste;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Jframetest {
    private JFrame frame;
    private JPanel panel;
    
    public Jframetest() {
        initialize();
    }

    public void initialize() {
            
        frame = new JFrame();

        frame.setTitle("Arruma o codigo mahoraga");

        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        panel.setBackground(Color.GREEN);

        for (int i = 1; i <= 5;i++) {
            JButton button = new JButton("Botão " + Integer.toString(i));
            panel.add(button);
        }

        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);

        frame.add(panel, BorderLayout.NORTH);

        frame.setVisible(true);        
    }
}

