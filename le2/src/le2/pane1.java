/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package le2;

import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

/**
 *
 * @author kuus
 */
public class pane1 {
    
    private int secmin = 60;
    private int minuur =60;
    private int uurdag =24;
    private int dagjaar = 365;
    private int uitkomst=0;
    private final Label labelmin;
    private final Label labeluur;
    private final Label labeldag;
    private final Label labeljaar;
    
    public pane1(FlowPane p)
    {
        
        labelmin = new Label("seconden in minuten: "+secmin);
        uitkomst = secmin *minuur;
        labeluur = new Label("seconden in uren: "+uitkomst);
        uitkomst = uitkomst *uurdag;
        labeldag = new Label("seconden in dagen: "+uitkomst);
        uitkomst = uitkomst *dagjaar;
        labeljaar = new Label("seconden in jaren: "+uitkomst);
        
        p.getChildren().add(labelmin);
        p.getChildren().add(labeluur);
        p.getChildren().add(labeldag);
        p.getChildren().add(labeljaar);

        
    }
    
}
