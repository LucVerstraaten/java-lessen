package praktijk1.pkg4;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ButtonsPanel extends JPanel {
    
    JButton  btnWissel, btnReset;
    GooienButton btnGooien;
    SteenPanel deStenen;
    JLabel lblBeurt, lblSpeler, sp1, sp2;
    
    public ButtonsPanel(SteenPanel deStenen){
        this.deStenen = deStenen;
        setLayout(new GridLayout(3,3,10,10));
        btnGooien = new GooienButton(deStenen.steen1,deStenen.steen2,deStenen.steen3,deStenen.steen4,deStenen.steen5);
        btnWissel = new JButton("Wissel");
        btnReset = new JButton("Nieuw spel");
        lblBeurt = new JLabel();
        lblBeurt.setHorizontalAlignment(SwingConstants.RIGHT);
        lblBeurt.setText("Beurt: 1");
        lblSpeler = new JLabel();
        lblSpeler.setText("Speler 1 is aan de beurt");
        sp1 = new JLabel("speler1");
        sp1.setHorizontalAlignment(SwingConstants.RIGHT);
        sp2 = new JLabel("speler2");
        add(btnGooien);
        add(btnWissel);
        add(btnReset);
        add(lblBeurt);
        add(new JLabel());
        add(lblSpeler);
        add(sp1);
        add(new JLabel());
        add(sp2);
        
    }
    
}
