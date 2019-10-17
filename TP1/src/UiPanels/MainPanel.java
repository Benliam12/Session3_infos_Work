package UiPanels;

import Calculator.InsuranceCalculator;
import Listeners.ComboBoxCarSelector;
import Listeners.ComboBoxDateMonthListener;
import Listeners.ComboBoxDateYearListener;
import UiDependencies.ComboItems;
import UiDependencies.SpringUtilities;
import User.UserBasicData;
import Vehicule.Vehicle;
import Vehicule.VehicleManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by Benliam12 on 2019-10-06.
 */
public class MainPanel extends JPanel
{
    private HashMap<String, JTextField> textFieldData = new HashMap<>();
    private HashMap<String, JComboBox> comboBoxData = new HashMap<>();
    private HashMap<String, JCheckBox> checkBoxData = new HashMap<>();
    private HashMap<String, JRadioButton> radioButtonData = new HashMap<>();

    private GuiInterface guiInterface;

    /**
     * Make a table of {@link JTextField}
     * @param labels name of the field.
     * @param panel panel to add the {@link JTextField}
     */
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

    /**
     * Make a table of {@link JLabel}
     * @param labels text in the {@link JLabel}
     * @param panel panel to add the {@link JLabel}
     */
    private void makeList(String[] labels, JPanel panel)
    {
        int numPairs = labels.length;
        //Create and populate the panel.
        JPanel p = new JPanel(new SpringLayout());
        for (int i = 0; i < numPairs; i++) {
            JLabel l = new JLabel(labels[i], JLabel.LEFT);
            p.add(l);
        }

        //Lay out the panel.
        SpringUtilities.makeCompactGrid(p,
                numPairs, 1, //rows, cols
                98, 6,        //initX, initY
                6, 6);       //xPad, yPad
        panel.add(p);
    }

    /**
     * Make a table of {@link JComboBox}
     * @param labels Name of the {@link JComboBox}
     * @param panel panel to add the table.
     */
    private void makeComboBoxList(String[] labels, JPanel panel)
    {
        int numPairs = labels.length;
        //Create and populate the panel.
        JPanel p = new JPanel(new SpringLayout());
        for (int i = 0; i < numPairs; i++) {
            JLabel l = new JLabel(labels[i], JLabel.TRAILING);
            p.add(l);
            JComboBox comboBox = new JComboBox();
            l.setLabelFor(comboBox);
            this.comboBoxData.put(labels[i], comboBox);
            p.add(comboBox);
        }

        //Lay out the panel.
        SpringUtilities.makeCompactGrid(p,
                numPairs, 2, //rows, cols
                80, 6,        //initX, initY
                6, 6);       //xPad, yPad
        panel.add(p);
    }

    /**
     * Make a table of {@link JCheckBox}
     * @param labels name of the {@link JCheckBox}
     * @param panel panel to add the table.
     */
    private void makeCheckBoxList(String[] labels, JPanel panel)
    {
        int numPairs = labels.length;
        //Create and populate the panel.
        JPanel p = new JPanel(new SpringLayout());
        for (int i = 0; i < numPairs; i++) {
            JLabel l = new JLabel(labels[i], JLabel.CENTER);
            JCheckBox checkBox = new JCheckBox();
            l.setLabelFor(checkBox);
            l.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e)
                {
                    if(e.getSource() == l)
                    {

                        checkBox.setSelected(!checkBox.isSelected());
                    }
                }
            });
            p.add(checkBox);
            p.add(l);
            checkBoxData.put(labels[i], checkBox);
        }

        //Lay out the panel.
        SpringUtilities.makeCompactGrid(p,
                numPairs, 2, //rows, cols
                0, 6,        //initX, initY
                6, 6);       //xPad, yPad
        panel.add(p);
    }

    public MainPanel(GuiInterface guiInterface)
    {
        super();
        this.guiInterface = guiInterface;

        this.setSize(new Dimension(600,970));

        JLabel title = new JLabel("<html><h1 style='font-size: 23px; font-weight: bold;'>Soumission d'assurance</h1></html>");
        JPanel panelTitle = new JPanel();
        panelTitle.add(title);

        //Little margin
        JPanel panelFieldBoarder = new JPanel();
        panelFieldBoarder.setBorder(new EmptyBorder(10,10,0,10));

        //Surrounding box around the form
        JPanel panelField = new JPanel();
        panelField.setPreferredSize(new Dimension(this.getWidth()-60, (int) (this.getHeight() * 0.75)));
        panelField.setBorder(BorderFactory.createTitledBorder(""));

        //main content
        JPanel panelFieldPadding = new JPanel();
        panelFieldPadding.setBorder(new EmptyBorder(0,20,20,20));
        panelFieldPadding.setLayout(new BoxLayout(panelFieldPadding, BoxLayout.Y_AXIS));
        panelFieldPadding.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel userDataSeparatorPanel = new JPanel();
        JLabel userDataSeparatorLabel = new JLabel("<html><b style='text-decoration: underlined; font-size: 1.5em;'>Informations personnelles</div></html>");

        userDataSeparatorPanel.add(userDataSeparatorLabel);
        panelFieldPadding.add(userDataSeparatorPanel);

        //BirthDay selector
        JPanel yearOfBirthSelectorPanel = new JPanel();
        yearOfBirthSelectorPanel.setLayout(new SpringLayout());
        JComboBox daySelector = new JComboBox();
        JComboBox monthSelector = new JComboBox();
        JComboBox yearSelector = new JComboBox();
        this.comboBoxData.put("daySelector", daySelector);
        this.comboBoxData.put("monthSelector", monthSelector);
        this.comboBoxData.put("yearSelector", yearSelector);

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

        //SEX SELECTOR
        JPanel sexSelectorPanel = new JPanel(new SpringLayout());
        JLabel sexSelectorLabel = new JLabel("Sexe", JLabel.TRAILING);
        JComboBox sexSelector = new JComboBox();
        this.comboBoxData.put("sexSelector", sexSelector);
        sexSelector.addItem(new ComboItems("Homme", UserBasicData.Sex.HOMME));
        sexSelector.addItem(new ComboItems("Femme", UserBasicData.Sex.FEMME));
        sexSelector.addItem(new ComboItems("Autre", UserBasicData.Sex.AUTRE));
        sexSelectorLabel.setLabelFor(sexSelector);
        sexSelectorPanel.add(sexSelectorLabel);
        sexSelectorPanel.add(sexSelector);
        SpringUtilities.makeCompactGrid(sexSelectorPanel,1 ,2 ,99 ,6 ,6 ,6 );
        panelFieldPadding.add(sexSelectorPanel);

        panelFieldPadding.add(yearOfBirthSelectorPanel);

        //Special conditions
        ButtonGroup btnGroup = new ButtonGroup();
        JPanel specialsConditionsPanel = new JPanel();
        JLabel specialConditionsLabel = new JLabel("Est-ce que l'une de ces conditions vous concernent ?");
        JRadioButton yesConditionsBtn = new JRadioButton("Oui");
        JRadioButton noConditionsBtn = new JRadioButton("Non");

        String[] conditions = {
                "Il y a 3 conducteurs ou plus / véhicule",
                "Votre permis a été suspendu dans les 3 dernières années",
                "Vous possédez un dossier criminel",
                "<html><div style=\" width:300px;\">Une police d'assurance automobile ou résidentielle vous a été refusée ou a été résiliée dans les 5 dernières années.</div></html>",
                "Le conducteur principal possède un permis d'apprenti"
        };

        btnGroup.add(yesConditionsBtn);
        btnGroup.add(noConditionsBtn);
        noConditionsBtn.setSelected(true);
        specialsConditionsPanel.add(specialConditionsLabel);
        specialsConditionsPanel.add(yesConditionsBtn);
        specialsConditionsPanel.add(noConditionsBtn);
        this.radioButtonData.put("yes-conditions", yesConditionsBtn);
        this.radioButtonData.put("no-conditions", noConditionsBtn);


        panelFieldPadding.add(specialsConditionsPanel);
        this.makeList(conditions,panelFieldPadding);

        JScrollPane jScrollPane = new JScrollPane(panelFieldPadding, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setPreferredSize(new Dimension(this.getWidth()-66,(int) (this.getHeight() * 0.78) - 40));
        jScrollPane.setBorder(new EmptyBorder(0,0,0,0));

        String[] otherInfos = {"Age d'obtention du permis", "Kilométrage annuel"};
        this.makeComboBoxList(otherInfos,panelFieldPadding);

        //Because the text was too long =(
        JPanel infractionPanel = new JPanel(new SpringLayout());
        JLabel infractionLabel = new JLabel("<html><div style=\"\">Nombre d'infractions (hors stationnement) dans les 3 dernièrs années</b></html>", JLabel.TRAILING);
        JComboBox infractionComboBox = new JComboBox();
        infractionLabel.setLabelFor(infractionComboBox);
        this.comboBoxData.put("infraction", infractionComboBox);
        infractionPanel.add(infractionLabel);
        infractionPanel.add(infractionComboBox);
        SpringUtilities.makeCompactGrid(infractionPanel,
                1, 2, //rows, cols
                0, 6,        //initX, initY
                6, 6);       //xPad, yPad
        panelFieldPadding.add(infractionPanel);

        for(int i = 16; i<=99;i++)
        {
            this.comboBoxData.get("Age d'obtention du permis").addItem(new ComboItems<Integer>(i + " ans", i));
        }

        for(int i = 1000; i<=200000;i+=1000)
        {
            this.comboBoxData.get("Kilométrage annuel").addItem(new ComboItems<Integer>(i + " km", i));
        }

        for(int i = 0; i<=50;i++)
        {
            this.comboBoxData.get("infraction").addItem(i);
        }

        JPanel alreadyCustomerPanel = new JPanel();
        ButtonGroup alreaydCustomerButtonGroup = new ButtonGroup();
        JLabel alreadyCustomerLabel = new JLabel("Êtes-vous déjà client avec nous?");
        JRadioButton yesAlreadyCustomer = new JRadioButton("Oui");
        JRadioButton noAlreadyCustomer = new JRadioButton("Non");
        this.radioButtonData.put("yes-customer", yesAlreadyCustomer);
        this.radioButtonData.put("no-customer", noAlreadyCustomer);
        alreadyCustomerPanel.add(alreadyCustomerLabel);
        alreadyCustomerPanel.add(yesAlreadyCustomer);
        alreadyCustomerPanel.add(noAlreadyCustomer);
        alreaydCustomerButtonGroup.add(yesAlreadyCustomer);
        alreaydCustomerButtonGroup.add(noAlreadyCustomer);
        noAlreadyCustomer.setSelected(true);
        panelFieldPadding.add(alreadyCustomerPanel);


        JPanel vehicleSeparatorPanel = new JPanel();
        JLabel vehicleSeparatorLabel = new JLabel("<html><b style='text-decoration: underlined; font-size: 1.5em;'>Informations sur le véhicle</b></html>");

        vehicleSeparatorPanel.add(vehicleSeparatorLabel);
        panelFieldPadding.add(vehicleSeparatorPanel);

        String[] cars = {"Marque", "Model", "Année"};
        this.makeComboBoxList(cars,panelFieldPadding);

        VehicleManager.getInstance().setup();
        this.comboBoxData.get("Marque").addItemListener(new ComboBoxCarSelector(this.comboBoxData.get("Marque"),this.comboBoxData.get("Model") ,this.comboBoxData.get("Année") ,"brand" ));
        this.comboBoxData.get("Model").addItemListener(new ComboBoxCarSelector(this.comboBoxData.get("Marque"),this.comboBoxData.get("Model") ,this.comboBoxData.get("Année") ,"model" ));
        for(String marque: VehicleManager.getInstance().getBrands())
        {
            this.comboBoxData.get("Marque").addItem(marque);
        }

        JPanel antiThefSystemPanel = new JPanel();
        antiThefSystemPanel.add(new JLabel("Selectionnez les sytèmes antivols que votre véhicule possède:", JLabel.TRAILING));
        panelFieldPadding.add(antiThefSystemPanel);

        String[] checkBoxs = {"Alarme sonore", "Marquage intensif antivol", "Antidemarreur", "Système d'alarme de repérage", "Autre", "Aucun"};
        this.makeCheckBoxList(checkBoxs,panelFieldPadding);
        this.checkBoxData.get("Aucun").setSelected(true);

        for(Map.Entry<String, JCheckBox> checkBox : this.checkBoxData.entrySet())
        {
            if(!checkBox.getKey().equalsIgnoreCase("Aucun"))
            {
                checkBox.getValue().addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if(e.getStateChange()==1)
                        {
                            checkBoxData.get("Aucun").setSelected(false);
                        }
                    }
                });
            }
        }

        this.checkBoxData.get("Aucun").addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==1)
                {
                    for(Map.Entry<String, JCheckBox> checkBox : checkBoxData.entrySet())
                    {
                        if(!checkBox.getKey().equalsIgnoreCase("Aucun"))
                        {
                            checkBox.getValue().setSelected(false);
                        }
                    }
                }
            }
        });

        //Submit btn
        JPanel buttonBox = new JPanel();
        buttonBox.setLayout(new BoxLayout(buttonBox,BoxLayout.LINE_AXIS));
        JButton submitBtn = new JButton("Soumettre");
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkUpData();
            }
        });
        buttonBox.add(submitBtn, BorderLayout.SOUTH);


        panelField.add(jScrollPane);
        panelFieldBoarder.add(panelField);
        Box box = Box.createVerticalBox();
        box.add(panelTitle);
        box.add(panelFieldBoarder);
        box.add(buttonBox);

        this.add(box);
    }

    /**
     * Checks if all the required data has been filled out. Will launch the {@link #proceed()} functions if it does confirm everything is good.
     */
    private void checkUpData()
    {
        String[] t = {"Prénom", "Nom", "Email", "Adresse", "Numéro de téléphone"};
        HashMap<String, String> fieldData = new HashMap<>();
        ArrayList<String> emptyErrors = new ArrayList<>();
        boolean hasError = false;

        for(String field : t)
        {
            String f = this.textFieldData.get(field).getText();

            if(f.trim().isEmpty())
            {
                emptyErrors.add(field);
                hasError=true;
            }

            fieldData.put(field, f.trim());
        }

        ComboItems<Integer> monthData =  (ComboItems) this.comboBoxData.get("monthSelector").getSelectedItem();
        int monthId = monthData.getValue();
        int year = (int)this.comboBoxData.get("yearSelector").getSelectedItem();
        int day =(int)this.comboBoxData.get("daySelector").getSelectedItem();

        LocalDate dateOfBirth = LocalDate.of(year,monthId,day);
        LocalDate now = LocalDate.now();
        int elapsedYear = Period.between(dateOfBirth,now).getYears();

        String outputMessage = "Il y a quelques problèmes à résoudre:\n";
        outputMessage += (emptyErrors.size() > 0) ? "Les champs suivants doivent être remplis: \n----------------------------\n" : "";
        hasError = (emptyErrors.size() > 0) || hasError;
        for(String s: emptyErrors)
        {
            outputMessage += s + "\n";
        }

        boolean yearDiff = ((int)((ComboItems) this.comboBoxData.get("Age d'obtention du permis").getSelectedItem()).getValue() >= elapsedYear);

        outputMessage += yearDiff ? "----------------------------\nL'age d'obtention de votre permis ne peut pas être vraie \n" : "";
        hasError = (yearDiff) || hasError;

        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);

        if(!pattern.matcher(fieldData.get("Email")).matches())
        {
            hasError = true;
            outputMessage += "----------------------------\nVotre email n'est pas valide!\n";
        }

        String phoneNumber = fieldData.get("Numéro de téléphone").trim().replace("-","").replace("(", "").replace(")", "").replace(" ", "");

        try
        {
            Long phone = Long.parseLong(phoneNumber);
            if(phoneNumber.length() != 10)
            {
                hasError=true;
                outputMessage+= "----------------------------\nLe numéro de téléphone n'est pas valide!";
            }
        }
        catch(Exception ex)
        {
            outputMessage+= "----------------------------\nLe numéro de téléphone n'est pas valide!";
            hasError=true;
        }

        if(hasError)
        {
            JOptionPane.showMessageDialog(new JFrame(),outputMessage);
        }
        else
        {
            this.proceed();
        }
    }

    /**
     * Execute the calculation of the final price. Will then send the user to the final Panel ({@link GuiInterface#swtichCard(String)})
     */
    private void proceed()
    {
        String phoneField = this.textFieldData.get("Numéro de téléphone").getText().trim().replace("-", "").replace("(", "").replace(")", "").replace(" ", "");
        String phoneNumber = phoneField.substring(0,3) + "-" + phoneField.substring(3,6) + "-" + phoneField.substring(6);

        ComboItems<Integer> monthData =  (ComboItems) this.comboBoxData.get("monthSelector").getSelectedItem();
        int monthId = monthData.getValue();
        int year = (int)this.comboBoxData.get("yearSelector").getSelectedItem();
        int day =(int)this.comboBoxData.get("daySelector").getSelectedItem();
        LocalDate dateOfBirth = LocalDate.of(year,monthId,day);
        LocalDate now = LocalDate.now();
        int elapsedYear = Period.between(dateOfBirth,now).getYears();

        UserBasicData basicData = new UserBasicData();
        basicData.setAddress(this.textFieldData.get("Adresse").getText())
                .setAge(elapsedYear)
                .setDateOfBirth(String.valueOf(day)+"/"+String.valueOf(monthId)+"/"+String.valueOf(year))
                .setFirstName(this.textFieldData.get("Prénom").getText())
                .setLastName(this.textFieldData.get("Nom").getText())
                .setPhoneNumber(phoneNumber)
                .setEmailAddress(this.textFieldData.get("Email").getText())
                .setSex((UserBasicData.Sex) ((ComboItems) this.comboBoxData.get("sexSelector").getSelectedItem()).getValue())
                .setKilometersPerYear((int)((ComboItems) this.comboBoxData.get("Kilométrage annuel").getSelectedItem()).getValue())
                .setAgeOfDriverLicence((int)((ComboItems) this.comboBoxData.get("Age d'obtention du permis").getSelectedItem()).getValue())
                .setNumberOfInfractions((int)this.comboBoxData.get("infraction").getSelectedItem());

        User.User user = new User.User(basicData);
        user.setIsCustomer(this.radioButtonData.get("yes-customer").isSelected());
        user.setSpecialConditions(this.radioButtonData.get("yes-conditions").isSelected());

        Vehicle vehicle = VehicleManager.getInstance().getVehicule(this.comboBoxData.get("Marque").getSelectedItem().toString(),
                this.comboBoxData.get("Model").getSelectedItem().toString(),
                (int) this.comboBoxData.get("Année").getSelectedItem());


        String[] checkBoxs = {"Alarme sonore", "Marquage intensif antivol", "Antidemarreur", "Système d'alarme de repérage", "Autre", "Aucun"};

        for(String antiTheft : checkBoxs)
        {
            if(!antiTheft.equalsIgnoreCase("Aucun") && this.checkBoxData.get(antiTheft).isSelected())
            {
                vehicle.addAntiTheftSystem(Vehicle.AntiTheftSystem.getEnum(antiTheft));
            }
        }

        user.setVehicle(vehicle);

        double price = InsuranceCalculator.getInsurancePrice(user);
        System.out.printf("%s %.2f%s","The price is:",price,"$\n");

        //Write down file with data.

        this.guiInterface.getFinalPanel().generateData(user, price);
        this.guiInterface.swtichCard(GuiInterface.FINAL_WINDOW);
    }
}
