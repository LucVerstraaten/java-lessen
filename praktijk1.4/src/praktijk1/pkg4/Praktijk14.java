package praktijk1.pkg4;

import javax.swing.*;

public class Praktijk14 extends JFrame {

    public static void main(String[] args) {
        JFrame theFrame = new Praktijk14();
        theFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        theFrame.setTitle("IB1A periode 14");
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theFrame.setContentPane(new MainPanel());
        theFrame.setVisible(true);
    }

}
