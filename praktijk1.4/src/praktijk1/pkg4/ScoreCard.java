package praktijk1.pkg4;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ScoreCard extends JPanel {
    
    String [] deLabels = {"Een :","Twee :","Drie :","Vier :","Vijf :","Zes :",
                           "Totaal :","Bonus :","Totaal Boven :",
                           "Three of a kind :", "Four of a kind :","Full House :",
                           "Small Street :", "Large Street :","Yathzee :","Chance :","Totaal Onder :", "Totaal Boven :","Grand Totaal :"};
    String [] deChecks = {"ck1","ck2","ck3","ck4","ck5","ck6","","","","ck3k","ck4k","ckFH","ckSS","ckLS","ckYat","ckc",};
    JCheckBox  theCheck;
   
    public ScoreCard(){
        setLayout(new GridLayout(19,3,4,4));
        int teller = 0;
        for(String x : deLabels){
            JLabel theLabel = new JLabel(x);
            if(teller < 6 || (teller > 8 && teller <16)){
            theCheck = new JCheckBox();
            theCheck.setName(deChecks[teller]);
            }
            JTextField theField = new JTextField(10);
            theField.setEditable(false);
            add(theLabel);
            if(teller < 6 || (teller > 8 && teller < 16)){
            add(theCheck);
            }
            else{
                add(new JLabel(""));
            }
            add(theField);
            teller++;
        }
    
    }
    
}
