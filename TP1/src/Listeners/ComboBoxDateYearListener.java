package Listeners;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

/**
 * Created by Benliam12 on 2019-09-22.
 */
public class ComboBoxDateYearListener implements ItemListener
{

    private JComboBox monthSelector;

    public ComboBoxDateYearListener(JComboBox month)
    {
        this.monthSelector = month;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == 2)
        {
            return;
        }

        for(ItemListener itemListener : monthSelector.getItemListeners())
        {
            if(itemListener instanceof ComboBoxDateMonthListener)
            {
                ComboBoxDateMonthListener t = (ComboBoxDateMonthListener) itemListener;
                t.updater();
                break;
            }
        }
    }
}
