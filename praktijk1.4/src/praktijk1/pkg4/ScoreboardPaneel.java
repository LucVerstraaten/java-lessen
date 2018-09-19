
package praktijk1.pkg4;

import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class ScoreboardPaneel extends JPanel {
    
    ScoreCard scorecard1, scorecard2;
    
    public ScoreboardPaneel(){
        setLayout(new GridLayout(1,2,20,1));
        Border myBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        this.setBorder(myBorder);
        scorecard1 = new ScoreCard();
        scorecard2 = new ScoreCard();
        add(scorecard1);
        add(scorecard2);
        
    }
    
}
