import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Benliam12 on 2019-09-19.
 */
public class Lab5
{


    private JPanel mainPanel;
    private JTextField textField;
    private JButton button;
    private JLabel outPutLabel;


    private boolean firstStart = true;

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("App");
        Lab5 mw = new Lab5();
        frame.setContentPane(mw.getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(500,300));
        frame.setResizable(false);

        mw.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getActionCommand().equalsIgnoreCase("Button"))
                {
                    mw.showPalindrome();
                }
            }
        });

        mw.textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == 10)
                {
                    mw.showPalindrome();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        frame.pack();
        frame.setVisible(true);

    }

    public JPanel getPanel()
    {
        return this.mainPanel;
    }

    private void showPalindrome()
    {
        if(this.checkPalindrome())
            this.outPutLabel.setText("Palindrome");
        else
            this.outPutLabel.setText("Mot ordinaire");

        this.textField.setText("");
    }

    private boolean checkPalindrome()
    {
        StringBuilder sb = new StringBuilder(this.textField.getText());

        if(!sb.toString().isEmpty())
        {
           String  normal = sb.toString();
           String reversed = sb.reverse().toString();


            return normal.equalsIgnoreCase(reversed);
        }
        return false;
    }

}
