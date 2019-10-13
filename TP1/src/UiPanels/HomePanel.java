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

    public HomePanel(int width, int height)
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
        JLabel description = new JLabel("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam nec finibus ligula. Mauris eros purus, vulputate ac orci nec, blandit vehicula odio. In dignissim, odio quis eleifend sagittis, libero eros semper velit, sit amet ultricies tellus quam eget urna. Mauris interdum nulla lectus, vel scelerisque dui bibendum eu. Nunc massa tortor, efficitur vitae accumsan sit amet, feugiat nec lectus. Donec tellus quam, placerat id consectetur a, congue sed nunc. Sed turpis ante, pulvinar ac molestie vitae, ultrices ut diam. Duis congue ante in nisl ultricies laoreet. Maecenas condimentum lectus et augue tempus efficitur. In molestie lacus nibh, vitae elementum magna imperdiet et. Pellentesque porta elit sit amet vehicula hendrerit.");
        description.setText("<html><div style='width: 425px; text-align:justify;'>"+description.getText()+"</div></html>");
        descriptionPanel.add(description);

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton startBtn = new JButton("Commencer la soumissions");
        startBtn.setAlignmentX(SwingConstants.CENTER);
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiInterface.getInstance().swtichCard(GuiInterface.MAIN_WINDOW);
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
