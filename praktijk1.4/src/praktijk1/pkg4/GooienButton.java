package praktijk1.pkg4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

public class GooienButton extends JButton {

    Dobbelsteen steen1, steen2, steen3, steen4, steen5;

    public GooienButton(Dobbelsteen steen1,
            Dobbelsteen steen2,
            Dobbelsteen steen3,
            Dobbelsteen steen4,
            Dobbelsteen steen5
    ) {
        this.steen1 = steen1;
        this.steen2 = steen2;
        this.steen3 = steen3;
        this.steen4 = steen4;
        this.steen5 = steen5;

        addActionListener(new KH());
        setText("gooien");
    }

    class KH implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            steen1.dobbelen();
            steen2.dobbelen();
            steen3.dobbelen();
            steen4.dobbelen();
            steen5.dobbelen();
            int ogen1 = steen1.aantalOgen();
            int ogen2 = steen2.aantalOgen();
            int ogen3 = steen3.aantalOgen();
            int ogen4 = steen4.aantalOgen();
            int ogen5 = steen5.aantalOgen();
            int totaal = ogen1 + ogen2 + ogen3 + ogen4 + ogen5;

        }
    }
}
