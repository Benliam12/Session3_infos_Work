import Listeners.ComboBoxDateMonthListener;
import Listeners.ComboBoxDateYearListener;
import UiDependencies.ComboItems;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormatSymbols;

public class MainWindow {

    private JPanel mainPanel;
    private JScrollBar scrollBar1;
    private JTextField firstName;
    private JTextField lastName;
    private JComboBox sexSelector;
    private JComboBox Day;
    private JComboBox Month;
    private JComboBox Year;
    private JTextField textField1;
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

        mw.Month.addItemListener(new ComboBoxDateMonthListener(mw.Year, mw.Month, mw.Day));
        mw.Year.addItemListener(new ComboBoxDateYearListener(mw.Month));

        for(int i = 2019; i>1930;i--)
        {
            mw.Year.addItem(i);
        }

        String[] months = new DateFormatSymbols().getMonths();

        for(int i = 1; i<=12;i++)
        {
            String output = months[i-1].substring(0, 1).toUpperCase() + months[i-1].substring(1);
            mw.Month.addItem(new ComboItems(output, i));
        }

        mw.Day.setSelectedItem(1);

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
