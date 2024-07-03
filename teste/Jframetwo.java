package teste;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Jframetwo {
    
    private JFrame frame;

    public Jframetwo() {
        initialize();
    }

    public void initialize() {
        frame = new JFrame();
        frame.setLayout(new BorderLayout(10,5));
        frame.setTitle("testando esse cu");//titulo da pagina
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//fechar com o X
        frame.setSize(800, 500);//tamanho da pagina
        frame.setLocationRelativeTo(null);//localização onde a pagina vai aparecer
        //frame.setResizable(false);//mudar o tamanho da pagina com o mouse
        frame.setVisible(true);//deixar a pagina visivel ou não
    
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));

        panel.setBackground(Color.BLUE);

        Button butone = new Button(":D");
        Button b = new Button ("tamo indo");
        Button caraio = new Button ("AOBA");
        panel.add(butone);
        panel.add(b);
        panel.add(caraio);

        panel.setPreferredSize(new Dimension(250, 250));

        frame.add(panel, BorderLayout.NORTH);

        frame.setVisible(true);
    }
}
