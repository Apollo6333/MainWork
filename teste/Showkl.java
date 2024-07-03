package teste;

import javax.swing.SwingUtilities;

public class Showkl {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                //Jframeone frameone = new Jframeone();

                //Jframetest test = new Jframetest();

                KaguraBachi test = new KaguraBachi();
                
                //Jframetwo frametwo = new Jframetwo();
                //Mainwi main = new Mainwi();
                //main.show();
            }
        });
    }
}