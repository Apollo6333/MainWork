package teste;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Mainwi {

    private JFrame frame;

    public Mainwi() {
        frame = new JFrame();
        frame.setTitle("COME ON");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 500);

        BorderLayout border = new BorderLayout();
        border.setHgap(5);
        border.setVgap(5);
        frame.setLayout(border);
        //frame.setLayout(new BorderLayout(5, 5));

        frame.add(new JButton("North"), BorderLayout.NORTH);
        frame.add(new JButton("South"), BorderLayout.SOUTH);
        frame.add(new JButton("West"), BorderLayout.WEST);
        frame.add(new JButton("East"), BorderLayout.EAST);
        frame.add(new JButton("Center"), BorderLayout.CENTER);

        frame.setLocationRelativeTo(null);
    }

    public void show() {
        frame.setVisible(true);
    }
}
