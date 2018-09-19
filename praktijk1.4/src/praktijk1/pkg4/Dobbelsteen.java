package praktijk1.pkg4;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class Dobbelsteen extends JPanel {

    private Color g1, g2, g3, g4, g5, g6, g7;
    private Color con = Color.black;
    private Color cof = Color.white;
    JCheckBox ckBox = new JCheckBox("vast");
    int db = 0;
    private Random rand = new Random();

    public void dobbelen() {
        if (ckBox.isSelected() != true) {
            db = rand.nextInt(6);
            db++;

            if (db == 1) {
                g1 = cof;
                g2 = cof;
                g3 = cof;
                g4 = con;
                g5 = cof;
                g6 = cof;
                g7 = cof;
            } else if (db == 2) {
                g1 = con;
                g2 = cof;
                g3 = cof;
                g4 = cof;
                g5 = cof;
                g6 = cof;
                g7 = con;
            } else if (db == 3) {
                g1 = con;
                g2 = cof;
                g3 = cof;
                g4 = con;
                g5 = cof;
                g6 = cof;
                g7 = con;
            } else if (db == 4) {
                g1 = con;
                g2 = cof;
                g3 = con;
                g4 = cof;
                g5 = con;
                g6 = cof;
                g7 = con;
            } else if (db == 5) {
                g1 = con;
                g2 = cof;
                g3 = con;
                g4 = con;
                g5 = con;
                g6 = cof;
                g7 = con;
            } else if (db == 6) {
                g1 = con;
                g2 = con;
                g3 = con;
                g4 = cof;
                g5 = con;
                g6 = con;
                g7 = con;
            }
            repaint();
        }
    }

    public Dobbelsteen() {
        setLayout(null);
        g1 = cof;
        g2 = cof;
        g3 = cof;
        g4 = cof;
        g5 = cof;
        g6 = cof;
        g7 = cof;

        ckBox.setBounds(20, 170, 100, 20);

        add(ckBox);
    }

    public int aantalOgen() {
        return db;

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(cof);
        g.fillRoundRect(20, 10, 100, 100, 20, 20);
        g.setColor(g1);
        g.fillOval(30, 20, 20, 20);
        g.setColor(g2);
        g.fillOval(30, 50, 20, 20);
        g.setColor(g3);
        g.fillOval(30, 80, 20, 20);
        g.setColor(g4);
        g.fillOval(60, 50, 20, 20);
        g.setColor(g5);
        g.fillOval(90, 20, 20, 20);
        g.setColor(g6);
        g.fillOval(90, 50, 20, 20);
        g.setColor(g7);
        g.fillOval(90, 80, 20, 20);
    }

}
