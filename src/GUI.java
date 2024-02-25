import javax.swing.*;
import java.awt.*;


public class GUI {
    public GUI() {

        JFrame frame = new JFrame();


    }// end of GUI OBJECT CONSTRUCTOR METHOD




    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,30, 10, 30));
        panel.setLayout(new GridLayout(0 , 1));

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Our GUI");
        frame.pack();
        frame.setVisible(true);


    }// end of the main METHOD

}// end of GUI CLASS
