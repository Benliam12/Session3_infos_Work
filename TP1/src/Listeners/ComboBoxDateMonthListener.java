package Listeners;

import UiDependencies.ComboItems;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.Year;
import java.time.YearMonth;

public class ComboBoxDateMonthListener implements ItemListener {

    private JComboBox years;
    private JComboBox days;
    private JComboBox months;

    public ComboBoxDateMonthListener(JComboBox years, JComboBox months, JComboBox days)
    {
        this.years = years;
        this.days = days;
        this.months = months;
    }

    @Override
    public void itemStateChanged(ItemEvent e)
    {
        if (e.getStateChange() == 2) {
            return; // Previous from changes. No need to do anything here.
        }

        this.updater();
    }

    public void updater()
    {
        int years = 0;

        try {
            years = Integer.parseInt(this.years.getSelectedItem().toString());
        } catch (NumberFormatException ex) {
            System.out.println("Error formating number (class ComboBoxDateMonthListener, method:itemStateChanged)");
        }

        boolean fev29th = (years % 4 == 0);

        try
        {
            ComboItems monthId = (ComboItems) this.months.getSelectedItem();
            YearMonth yearMonth = YearMonth.of(years, (int) monthId.getValue());

            System.out.println(yearMonth.lengthOfMonth());

            this.days.removeAllItems();

            for(int i=1; i<=yearMonth.lengthOfMonth(); i++)
            {
                this.days.addItem(i);
            }
        }
        catch(Exception ex)
        {
            //Used because when launching the program, it doesn't register first day.
            System.out.println("Start Err");
        }

    }
}
