package UiPanels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Benliam12 on 2019-10-06.
 */
public class HomePanel extends JPanel
{

    public HomePanel()
    {
        super();
        this.setLayout(new GridBagLayout());
        this.add(new JLabel("Je suis le home panel =)"));

        JButton startBtn = new JButton("Commencer la soumissions");
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiInterface.getInstance().swtichCard(GuiInterface.MAIN_WINDOW);
            }
        });

        this.add(startBtn);

    }
}
