package UiPanels;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Benliam12 on 2019-10-06.
 * Panel that will be shown to the user as the final one, with the final price of his insurance
 */
public class FinalPanel extends JPanel {

    private boolean hasData = false;



    public FinalPanel(int width, int height, GuiInterface guiInterface)
    {
        JPanel contentPanel = new JPanel();
        contentPanel.setPreferredSize(new Dimension(width, height+250));
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.PAGE_AXIS));

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel title = new JLabel("<html><div style='font-size: 25px;'>Soumission Assurance</div></html>");
        title.setAlignmentX(SwingConstants.CENTER);

        titlePanel.add(title);

        JPanel descriptionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        descriptionPanel.setBorder(new EmptyBorder(10,30,10,30));
        JLabel description = new JLabel("Merci d'avoir utilisé notre application afin de calculer votre soumission! Les détails de votre soumissions se trouvent sous forme de fichier texte au même endroit que le .jar de l'application");
        description.setText("<html><div style='width: 425px; text-align:justify; font-size: 12px;'>"+description.getText()+"</div></html>");
        descriptionPanel.add(description);

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton quitBtn = new JButton("Quitter");
        quitBtn.setAlignmentX(SwingConstants.CENTER);
        quitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiInterface.close();
            }
        });
        btnPanel.add(quitBtn);

        contentPanel.add(titlePanel);
        contentPanel.add(Box.createVerticalGlue());
        contentPanel.add(descriptionPanel);
        contentPanel.add(Box.createVerticalGlue());
        contentPanel.add(btnPanel);
        contentPanel.add(Box.createVerticalGlue());

        this.add(contentPanel);
    }

}
