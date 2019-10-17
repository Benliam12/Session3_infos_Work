package UiPanels;

import User.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by Benliam12 on 2019-10-06.
 * Panel that will be shown to the user as the final one, with the final price of his insurance
 */
public class FinalPanel extends JPanel {

    private boolean hasData = false;

    private GuiInterface guiInterface;
    private File exportFile;
    private JLabel submission;

    /**
     * Fills out the submission with the user data.
     * @param user User object that contains the data.
     * @param amount Already calculated amount of the insurance
     */
    public void generateData(User user, double amount)
    {
        String fileName = "soumission";
        int i = 0;
        File file;
        do{
            file = new File(fileName + String.valueOf(i) + ".txt");
            i++;
        } while(file.exists());

        user.toFile(file.getName(), amount);


    }

    public FinalPanel(int width, int height, GuiInterface guiInterface)
    {
        this.setPreferredSize(new Dimension(width-200, height));
        this.guiInterface = guiInterface;
        this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS ));


        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("<html><div style='font-size: 25px;'>Assurance automobile</div></html>");

        titlePanel.add(titleLabel);


        JPanel contentPanel = new JPanel();
        // JLabel submission = new JLabel("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam nec finibus ligula. Mauris eros purus, vulputate ac orci nec, blandit vehicula odio. In dignissim, odio quis eleifend sagittis, libero eros semper velit, sit amet ultricies tellus quam eget urna. Mauris interdum nulla lectus, vel scelerisque dui bibendum eu. Nunc massa tortor, efficitur vitae accumsan sit amet, feugiat nec lectus. Donec tellus quam, placerat id consectetur a, congue sed nunc. Sed turpis ante, pulvinar ac molestie vitae, ultrices ut diam. Duis congue ante in nisl ultricies laoreet. Maecenas condimentum lectus et augue tempus efficitur. In molestie lacus nibh, vitae elementum magna imperdiet et. Pellentesque porta elit sit amet vehicula hendrerit.");
        this.submission = new JLabel("Merci d'avoir utilisé notre application afin de calculer votre soumission! Les détails de votre soumissions se trouvent sous forme de fichier texte au même endroit que le .jar de l'application");
        submission.setText("<html><div style='width: 425px; text-align:justify; font-size: 12px;'>"+submission.getText()+"</div></html>");

        contentPanel.add(this.submission);

        JPanel bottomPanel = new JPanel();
        JButton finishBtn = new JButton("Quitter");

        finishBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiInterface.close();
            }
        });

        bottomPanel.add(finishBtn);

        JPanel mainPanel = new JPanel();
        mainPanel.setMaximumSize(new Dimension(width, height-38));
        mainPanel.setBorder(BorderFactory.createLineBorder(new Color(40,40,40)));

        mainPanel.setLayout(new BorderLayout());

        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        this.add(mainPanel, BorderLayout.CENTER);
    }

}
