package fxvb0201;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

/**
 *
 * @author kuus
 */
public class Vb02021 
{
    private final Button knop;
    private final TextField tekstvak;
    private final Button knop2;
    private final Button knop3;
    public Vb02021(FlowPane p)
    {
     knop = new Button("klik");
     knop2 = new Button("klik2");
     knop3 = new Button("klik3");
     tekstvak = new TextField();
     
     knop.setOnAction( event -> {
     tekstvak.setText("Boter");
     });
     
     knop2.setOnAction( event -> {
     tekstvak.setText("Kaas");
     });
     
     knop3.setOnAction( event -> {
     tekstvak.setText("ij");
     });
     
     
     p.getChildren().add(knop);
     p.getChildren().add(tekstvak);
     p.getChildren().add(knop2);
     p.getChildren().add(knop3);

    }
}
