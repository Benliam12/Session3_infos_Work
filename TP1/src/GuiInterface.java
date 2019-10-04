import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class GuiInterface extends JFrame{



    public GuiInterface()
    {
        this.setTitle("TP 1");
        this.setMinimumSize(new Dimension(1280,720));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);


        JPanel panelField = new JPanel();
        panelField.setPreferredSize(new Dimension(230,60));
        panelField.setBorder(BorderFactory.createTitledBorder("Informations personnelles"));
        JTextField textField = new JTextField();
        textField.setColumns(20);
        textField.setSize(new Dimension(200,30));
        JLabel label = new JLabel("Votre nom");
        panelField.add(label);
        panelField.add(textField);

        Box b2 = Box.createHorizontalBox();
        b2.add(new JButton("kefhj"));

        Box mainBox = Box.createVerticalBox();
        mainBox.add(panelField);
        mainBox.add(b2);


        this.getContentPane().add(mainBox, BorderLayout.NORTH);
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        GuiInterface t = new GuiInterface();
    }

}
