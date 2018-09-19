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
public class pane2 {
    
    private int uitkomst;
    private Label label;
    public pane2(FlowPane p)
    {
        uitkomst = -2147483648 + -9;
        label = new Label("" +uitkomst);
        p.getChildren().add(label);
        
        
    }
    
}
