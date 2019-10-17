package UiPanels;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Benliam12 on 2019-10-06.
 */
public class HomePanel extends JPanel
{
    private GuiInterface guiInterface;
    public HomePanel(int width, int height, GuiInterface guiInterface)
    {
        this.guiInterface = guiInterface;
        JPanel contentPanel = new JPanel();
        contentPanel.setPreferredSize(new Dimension(width, height+250));
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.PAGE_AXIS));

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel title = new JLabel("<html><div style='font-size: 25px;'>Soumission Assurance</div></html>");
        title.setAlignmentX(SwingConstants.CENTER);

        titlePanel.add(title);

        JPanel descriptionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        descriptionPanel.setBorder(new EmptyBorder(10,30,10,30));
        JLabel description = new JLabel("Bienvenue dans le calculateur d'assurance!\n Vous pouvez calculer votre prime d'assurance en cliquant sur le bouton ci-dessous.");
        description.setText("<html><div style='width: 425px; font-size: 14px; text-align:center;'>"+description.getText()+"</div></html>");
        descriptionPanel.add(description);

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton startBtn = new JButton("Commencer la soumissions");
        startBtn.setAlignmentX(SwingConstants.CENTER);
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiInterface.swtichCard(GuiInterface.MAIN_WINDOW);
            }
        });
        btnPanel.add(startBtn);

        contentPanel.add(titlePanel);
        contentPanel.add(Box.createVerticalGlue());
        contentPanel.add(descriptionPanel);
        contentPanel.add(Box.createVerticalGlue());
        contentPanel.add(btnPanel);
        contentPanel.add(Box.createVerticalGlue());

        this.add(contentPanel);
    }
}
