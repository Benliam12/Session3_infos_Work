package UiPanels;

import Vehicule.Vehicle;
import Vehicule.VehicleManager;

import javax.swing.*;
import java.awt.*;

public class GuiInterface extends JFrame{

    private static GuiInterface instance = new GuiInterface();
    public synchronized static GuiInterface getInstance() {return instance;}

    private JPanel cardPanel;
    private VehicleManager vm = VehicleManager.getInstance();

    public static final String MAIN_WINDOW = "mainWindow";
    public static final String HOME_WINDOW = "homeWindow";
    public static final String FINAL_WINDOW = "finalWindow";


    private GuiInterface()
    {
        this.setTitle("TP 1");
        this.setMinimumSize(new Dimension(600,900));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);


        //Wrapping everything up
        this.cardPanel = new JPanel(new CardLayout());

        FinalPanel finalPanel = new FinalPanel();
        MainPanel mainPanel = new MainPanel();
        HomePanel homePanel = new HomePanel();

        //Panel switcher
        this.cardPanel.add(mainPanel, MAIN_WINDOW);
        this.cardPanel.add(finalPanel, FINAL_WINDOW);
        this.cardPanel.add(homePanel, HOME_WINDOW);

        CardLayout cl = (CardLayout) this.cardPanel.getLayout();
        cl.show(this.cardPanel,HOME_WINDOW);
        this.getContentPane().add(this.cardPanel, BorderLayout.NORTH);
    }


    public void swtichCard(String card)
    {
        CardLayout cl = (CardLayout) this.cardPanel.getLayout();
        cl.show(this.cardPanel, card);
    }
    /*public HashMap<String, JTextField> getItemInTextFields()
    {
        return this.textFieldData;
    }*/

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
