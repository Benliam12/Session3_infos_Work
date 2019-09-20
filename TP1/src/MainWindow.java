import Listeners.ComboBoxDateListener;
import UiDependencies.ComboItems;

import javax.swing.*;
import java.awt.*;

public class MainWindow {


    private JPanel mainPanel;
    private JScrollBar scrollBar1;
    private JTextField firstName;
    private JTextField lastName;
    private JComboBox sexSelector;
    private JComboBox Day;
    private JComboBox Month;
    private JComboBox Year;
    private JLabel titre;

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("App");
        MainWindow mw = new MainWindow();
        frame.setContentPane(mw.getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(600,900));


        mw.scrollBar1.setForeground(new Color(10,220,200));
        mw.sexSelector.addItem(new ComboItems("Homme", "HOMME"));
        mw.sexSelector.addItem(new ComboItems("Femme", "FEMME"));
        mw.sexSelector.addItem(new ComboItems("Autre", "NONE"));

        mw.Month.addItemListener(new ComboBoxDateListener(mw.Day));

        for(int i = 2019; i>1930;i--)
        {
            mw.Year.addItem(i);
        }

        String[] months = {"Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Aout", "Septembre", "Octobre", "Novembre", "Décembre"};

        for(String month : months)
        {
            mw.Month.addItem(month);
        }

        frame.pack();
        frame.setVisible(true);

    }

    public JLabel getTitle()
    {
        return this.titre;
    }

    public JPanel getPanel()
    {
        return this.mainPanel;
    }


}
