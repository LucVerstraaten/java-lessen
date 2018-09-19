package praktijk1.pkg4;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainPanel extends JPanel {

    
    SteenPanel rood = new SteenPanel();
    ScoreboardPaneel score = new ScoreboardPaneel();
    ButtonsPanel button = new ButtonsPanel(rood);
    
    Game theGame = new Game();

    public MainPanel() {
        setLayout(new BorderLayout());
        rood.setPreferredSize(new Dimension(1, 200));
        button.setPreferredSize(new Dimension(1,200));
        score.setPreferredSize(new Dimension(1,400));
        add(rood, BorderLayout.NORTH);
        add(button, BorderLayout.CENTER);
        add(score, BorderLayout.SOUTH);
    }
    
    public void gameSetup(){
        String strSpeler1 = JOptionPane.showInputDialog(this, "Naam van speler1: ");
        theGame.speler1.setStrNaam(strSpeler1);
        theGame.speler1.setTheCard(score.scorecard1);
        String strSpeler2 = JOptionPane.showInputDialog(this, "Naam van speler2: ");
        theGame.speler2.setStrNaam(strSpeler2);
        theGame.speler2.setTheCard(score.scorecard2);
        button.sp1.setText(theGame.speler1.getStrNaam());
        button.sp2.setText(theGame.speler2.getStrNaam());
    }

}
