package UiPanels;

import User.*;
import Vehicule.Vehicle;
import com.sun.xml.internal.ws.wsdl.writer.document.soap.Body;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public FinalPanel(int width, int height)
    {
        this.setPreferredSize(new Dimension(width-200, height));


        UserBasicData basicData = new UserBasicData();

        basicData.setAddress("450 rue Poney")
                .setAge(18)
                .setFirstName("Jean")
                .setLastName("Marie")
                .setPhoneNumber("819-291-2019")
                .setEmailAddress("patate@gmail.com")
                .setSex(UserBasicData.Sex.FEMME)
                .setKilometersPerYear(30000)
                .setAgeOfDriverLicence(16)
                .setNumberOfInfractions(0)
        ;
        User user = new User(basicData);


        user.setIsCustomer(true);
        user.setSpecialConditions(true);

        Vehicle v = new Vehicle("Tesla", "Model 3", 2016, 35000);
        v.addAntiTheftSystem(Vehicle.AntiTheftSystem.IMMOBILIZER);
        v.addAntiTheftSystem(Vehicle.AntiTheftSystem.TRACKING_ALARM_SYSTEM);

        user.setVehicle(v);

        this.generateData(user,100 );


        this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS ));


        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("<html><div style='font-size: 25px;'>Assurance automobile</div></html>");

        titlePanel.add(titleLabel);


        JPanel contentPanel = new JPanel();
        JLabel submission = new JLabel("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam nec finibus ligula. Mauris eros purus, vulputate ac orci nec, blandit vehicula odio. In dignissim, odio quis eleifend sagittis, libero eros semper velit, sit amet ultricies tellus quam eget urna. Mauris interdum nulla lectus, vel scelerisque dui bibendum eu. Nunc massa tortor, efficitur vitae accumsan sit amet, feugiat nec lectus. Donec tellus quam, placerat id consectetur a, congue sed nunc. Sed turpis ante, pulvinar ac molestie vitae, ultrices ut diam. Duis congue ante in nisl ultricies laoreet. Maecenas condimentum lectus et augue tempus efficitur. In molestie lacus nibh, vitae elementum magna imperdiet et. Pellentesque porta elit sit amet vehicula hendrerit.");
        submission.setText("<html><div style='width: 425px; text-align:justify; font-size: 12px;'>"+submission.getText()+"</div></html>");

        contentPanel.add(submission);

        JPanel bottomPanel = new JPanel();
        JButton finishBtn = new JButton("Quitter");

        finishBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiInterface.getInstance().close();
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
