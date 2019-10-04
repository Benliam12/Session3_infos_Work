import javax.swing.*;
import java.awt.*;

public class GuiInterface {

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("TP 1");
        JPanel contentPanel = new JPanel(new GridLayout(0,1));

        JLabel title = new JLabel("<html><h1 style=\"font-size:23px; font-weight: bold; padding: 0 10;\">Calculateur d'assurances</h1></html>");
        JComboBox<String> combo = new JComboBox<>();
        combo.addItem("Poulet");

        JPanel t = new JPanel();
        JPanel v = new JPanel();

        t.add(combo);
        t.setBackground(Color.CYAN);

        v.add(title);
        //v.setBorder(BorderFactory.createTitledBorder(
          //  BorderFactory.createEtchedBorder(), "Login Panel"));
        contentPanel.add(v);
        contentPanel.add(t);


        frame.setContentPane(contentPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(600,200));
        frame.setVisible(true);

    }

}
