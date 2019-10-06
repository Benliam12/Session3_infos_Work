import Listeners.ComboBoxDateMonthListener;
import Listeners.ComboBoxDateYearListener;
import UiDependencies.ComboItems;
import UiDependencies.SpringUtilities;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormatSymbols;
import java.util.HashMap;
import java.util.Map;

public class GuiInterface extends JFrame{

    private static GuiInterface instance = new GuiInterface();
    public static GuiInterface getInstance() {return instance;}

    private HashMap<String, JTextField> textFieldData = new HashMap<>();
    private JPanel mainPanel;
    private int bijour = 1;

    private void makeField(String[] labels, JPanel panel)
    {
        int numPairs = labels.length;
        //Create and populate the panel.
        JPanel p = new JPanel(new SpringLayout());
        for (int i = 0; i < numPairs; i++) {
            JLabel l = new JLabel(labels[i], JLabel.TRAILING);
            p.add(l);
            JTextField textField = new JTextField(15);
            l.setLabelFor(textField);
            this.textFieldData.put(labels[i], textField);
            p.add(textField);
        }

        //Lay out the panel.
        SpringUtilities.makeCompactGrid(p,
                numPairs, 2, //rows, cols
                6, 6,        //initX, initY
                6, 6);       //xPad, yPad
        panel.add(p);
    }

    private GuiInterface()
    {
        this.setTitle("TP 1");
        this.setMinimumSize(new Dimension(600,900));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);


        JLabel title = new JLabel("<html><h1 style='font-size: 23px; font-weight: bold;'>Soumission d'assurance</h1></html>");
        JPanel panelTitle = new JPanel();
        panelTitle.add(title);

        //Little margin
        JPanel panelFieldBoarder = new JPanel();
        panelFieldBoarder.setBorder(new EmptyBorder(20,20,20,20));

        //Surrounding box around the form
        JPanel panelField = new JPanel();
        panelField.setPreferredSize(new Dimension(this.getWidth()-60, (int) (this.getHeight() * 0.78)));
        panelField.setBorder(BorderFactory.createTitledBorder("Informations personnelles"));

        //main content
        JPanel panelFieldPadding = new JPanel();
        panelFieldPadding.setBorder(new EmptyBorder(20,20,20,20));
        panelFieldPadding.setLayout(new BoxLayout(panelFieldPadding, BoxLayout.Y_AXIS));
        panelFieldPadding.setAlignmentX(Component.CENTER_ALIGNMENT);

        //BirthDay selector
        JPanel yearOfBirthSelectorPanel = new JPanel();
        yearOfBirthSelectorPanel.setLayout(new SpringLayout());
        JComboBox daySelector = new JComboBox();
        JComboBox monthSelector = new JComboBox();
        JComboBox yearSelector = new JComboBox();

        monthSelector.addItemListener(new ComboBoxDateMonthListener(yearSelector, monthSelector, daySelector));
        yearSelector.addItemListener(new ComboBoxDateYearListener(monthSelector));

        for(int i = 2019; i>1930;i--)
        {
            yearSelector.addItem(i);
        }

        String[] months = new DateFormatSymbols().getMonths();

        for(int i = 1; i<=12;i++)
        {
            String output = months[i-1].substring(0, 1).toUpperCase() + months[i-1].substring(1); // put first letter in capital
            monthSelector.addItem(new ComboItems(output, i));
        }

        yearOfBirthSelectorPanel.add(new JLabel("Date de naissance"),0);
        yearOfBirthSelectorPanel.add(yearSelector,1);
        yearOfBirthSelectorPanel.add(monthSelector,2);
        yearOfBirthSelectorPanel.add(daySelector,3);

        SpringUtilities.makeCompactGrid(yearOfBirthSelectorPanel, 1, 4, //rows, cols
                22, 6,        //initX, initY
                7, 6);       //xPad, yPad

        //Main fields
        String[] t = {"Prénom", "Nom", "Email", "Adresse", "Numéro de téléphone"};
        this.makeField(t,panelFieldPadding);

        panelFieldPadding.add(yearOfBirthSelectorPanel);

        //Special conditions
        ButtonGroup btnGroup = new ButtonGroup();
        JPanel specialsConditionsPanel = new JPanel();
        JLabel specialConditionsLabel = new JLabel("Est-ce que l'une de ces conditions vous concernent ?");
        JRadioButton yesConditionsBtn = new JRadioButton("Oui");
        JRadioButton noConditionsBtn = new JRadioButton("Non");

        btnGroup.add(yesConditionsBtn);
        btnGroup.add(noConditionsBtn);
        noConditionsBtn.setSelected(true);
        specialsConditionsPanel.add(specialConditionsLabel);
        specialsConditionsPanel.add(yesConditionsBtn);
        specialsConditionsPanel.add(noConditionsBtn);
        panelFieldPadding.add(specialsConditionsPanel);


        panelField.add(panelFieldPadding);
        panelFieldBoarder.add(panelField);

        //Submit btn
        JPanel buttonBox = new JPanel();
        buttonBox.setLayout(new BoxLayout(buttonBox,BoxLayout.LINE_AXIS));
        JButton submitBtn = new JButton("Soumettre");
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Map.Entry<String, JTextField> entry : textFieldData.entrySet())
                {
                    String k = entry.getKey();
                    String v = entry.getValue().getText();
                }

                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "TESTPANEL");
            }
        });
        buttonBox.add(submitBtn, BorderLayout.SOUTH);

        //Wrapping everything up
        this.mainPanel = new JPanel(new CardLayout());
        JPanel testPanel = new JPanel();
        Box mainBox = Box.createVerticalBox();
        mainBox.add(panelTitle);
        mainBox.add(panelFieldBoarder);
        mainBox.add(buttonBox);

        //Panel switcher
        this.mainPanel.add(mainBox, "MAINWINDOW");
        this.mainPanel.add(testPanel, "TESTPANEL");

        CardLayout cl = (CardLayout) this.mainPanel.getLayout();
        cl.show(this.mainPanel, "MAINWINDOW");
        this.getContentPane().add(this.mainPanel, BorderLayout.NORTH);
    }

    public HashMap<String, JTextField> getItemInTextFields()
    {
        return this.textFieldData;
    }

    public void start()
    {
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        GuiInterface guiInterface = GuiInterface.getInstance();
        guiInterface.start();
    }

}
