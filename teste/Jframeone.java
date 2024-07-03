package teste;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Jframeone extends JFrame {

    private JFrame frame;
    
    public Jframeone() {
        initialize();
    } 

    public void initialize() {
        setTitle("teste1");//titulo da pagina
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//fechar com o X
        setSize(500, 400);//tamanho da pagina
        setLocationRelativeTo(null);//localização onde a pagina vai aparecer
        setResizable(false);//mudar o tamanho da pagina com o mouse
        setVisible(true);//deixar a pagina visivel ou não

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));

        frame.add(panel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
