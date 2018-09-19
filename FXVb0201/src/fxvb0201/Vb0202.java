package fxvb0201;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

/**
 *
 * @author kuus
 */
public class Vb0202 
{
    private final Button knop;
    private final TextField tekstvak;
    private final Button knop2;
    private final TextField tekstvak2;
    
    public Vb0202(FlowPane p)
    {
     knop = new Button("klik");
     knop2 = new Button("klik2");
     tekstvak = new TextField();
     tekstvak2 = new TextField();
     
     knop.setOnAction( event -> {
     tekstvak.setText("Luc");
     });
     
     knop2.setOnAction( event -> {
     tekstvak2.setText("Verstraaten");
     });
     
     
     p.getChildren().add(knop);
     p.getChildren().add(tekstvak);
     p.getChildren().add(knop2);
     p.getChildren().add(tekstvak2);
    }
}
