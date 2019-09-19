import javax.swing.*;
import java.awt.*;

public class MainWindow {


    private JPanel mainPanel;
    private JPasswordField passwordLabel;
    private JLabel titre;

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("App");
        MainWindow mw = new MainWindow();
        frame.setContentPane(mw.getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(600,900));



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
