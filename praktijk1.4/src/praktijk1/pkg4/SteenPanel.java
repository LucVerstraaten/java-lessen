package praktijk1.pkg4;

import java.awt.GridLayout;
import javax.swing.JPanel;

public class SteenPanel extends JPanel {

    Dobbelsteen steen1 = new Dobbelsteen(),
            steen2 = new Dobbelsteen(),
            steen3 = new Dobbelsteen(),
            steen4 = new Dobbelsteen(),
            steen5 = new Dobbelsteen();

    public SteenPanel() {
        setLayout(new GridLayout(1, 5));
        add(steen1);
        add(steen2);
        add(steen3);
        add(steen4);
        add(steen5);
    }

}
