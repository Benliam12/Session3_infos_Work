import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class GuiInterface extends JFrame{


    private void makeField(String label, JPanel panel)
    {
        JTextField textField = new JTextField();
        textField.setColumns(20);
        textField.setSize(new Dimension(200,30));
        JLabel jLabel= new JLabel(label);
        panel.add(jLabel);
        panel.add(textField);
    }

    public GuiInterface()
    {
        this.setTitle("TP 1");
        this.setMinimumSize(new Dimension(1280,720));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);


        JLabel title = new JLabel("<html><h1 style='font-size: 23px; font-weight: bold;'>Je suis un titre</h1></html>");
        JPanel panelTitle = new JPanel();
        panelTitle.add(title);

        JPanel panelFieldBoarder = new JPanel();
        panelFieldBoarder.setBorder(new EmptyBorder(20,20,20,20));

        JPanel panelField = new JPanel();
        panelField.setPreferredSize(new Dimension(this.getWidth()-120, (int) (this.getHeight() * 0.7)));
        panelField.setBorder(BorderFactory.createTitledBorder("Informations personnelles"));

        JPanel panelFieldPadding = new JPanel();
        panelFieldPadding.setBorder(new EmptyBorder(20,20,20,20));
        panelFieldPadding.setLayout(new BoxLayout(panelFieldPadding, BoxLayout.Y_AXIS));

        this.makeField("Votre prénom", panelFieldPadding);
        this.makeField("Votre nom", panelFieldPadding);
        this.makeField("Date de naissance", panelFieldPadding);

        panelField.add(panelFieldPadding);

        panelFieldBoarder.add(panelField);

        Box buttonBox = Box.createHorizontalBox();
        buttonBox.add(new JButton("kefhj"));

        Box mainBox = Box.createVerticalBox();
        mainBox.add(panelTitle);
        mainBox.add(panelFieldBoarder);
        mainBox.add(buttonBox);


        this.getContentPane().add(mainBox, BorderLayout.NORTH);
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        GuiInterface t = new GuiInterface();
    }

}
