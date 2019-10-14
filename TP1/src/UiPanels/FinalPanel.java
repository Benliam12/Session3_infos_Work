package UiPanels;

import User.User;

import javax.swing.*;

/**
 * Created by Benliam12 on 2019-10-06.
 * Panel that will be shown to the user as the final one, with the final price of his insurance
 */
public class FinalPanel extends JPanel {

    private boolean hasData = false;

    /**
     * Fills out the submission with the user data.
     * @param user User object that contains the data.
     * @param amount Already calculated amount of the insurance
     */
    public void generateData(User user, double amount)
    {

    }

    public FinalPanel()
    {
        this.add(new JLabel("Je suis le final panel! =) "));
    }

}
