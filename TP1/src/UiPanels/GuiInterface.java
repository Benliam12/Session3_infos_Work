package UiPanels;

import Vehicule.Vehicle;
import Vehicule.VehicleManager;

import javax.swing.*;
import java.awt.*;

public class GuiInterface extends JFrame{

    private static GuiInterface instance = new GuiInterface();
    public synchronized static GuiInterface getInstance() {return instance;}

    private JPanel cardPanel;
    private HomePanel homePanel;
    private MainPanel mainPanel;
    private FinalPanel finalPanel;

    public static final String MAIN_WINDOW = "mainWindow";
    public static final String HOME_WINDOW = "homeWindow";
    public static final String FINAL_WINDOW = "finalWindow";



    private GuiInterface()
    {
        int width = 600;
        int height = 900;
        this.setTitle("TP 1");
        this.setMinimumSize(new Dimension(width,height));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);


        //Wrapping everything up
        this.cardPanel = new JPanel(new CardLayout());

        this.finalPanel = new FinalPanel();
        this.mainPanel = new MainPanel();
        this.homePanel = new HomePanel(width, height);

        //Panel switcher
        this.cardPanel.add(this.mainPanel, MAIN_WINDOW);
        this.cardPanel.add(this.finalPanel, FINAL_WINDOW);
        this.cardPanel.add(this.homePanel, HOME_WINDOW);

        CardLayout cl = (CardLayout) this.cardPanel.getLayout();
        cl.show(this.cardPanel,HOME_WINDOW);
        this.getContentPane().add(this.cardPanel, BorderLayout.NORTH);
    }


    /**
     * Switch the current panel.
     * @param card Panel name.
     */
    public void swtichCard(String card)
    {
        CardLayout cl = (CardLayout) this.cardPanel.getLayout();
        cl.show(this.cardPanel, card);
    }

    /**
     * Returns the HomePanel that is used in the GuiInterface
     * @return HomePanel Object
     */
    public HomePanel getHomePanel()
    {
        return this.homePanel;
    }

    /**
     * Returns the FinalPanel that is used in the GuiInterface
     * @return FinalPanel Object
     */
    public FinalPanel getFinalPanel()
    {
        return this.finalPanel;
    }

    /**
     * Returns the MainPanel that is used in the GuiInterface.
     * @return MainPanel object
     */
    public MainPanel getMainPanel()
    {
        return this.mainPanel;
    }

    public static void main(String[] args)
    {
        GuiInterface guiInterface = GuiInterface.getInstance();

        guiInterface.setVisible(true);
    }

}
