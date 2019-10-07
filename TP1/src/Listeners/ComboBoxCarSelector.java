package Listeners;

import Vehicule.Vehicle;
import Vehicule.VehicleManager;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by Benliam12 on 2019-10-06.
 */
public class ComboBoxCarSelector implements ItemListener {

    private JComboBox brandSelector;
    private JComboBox modelSelector;
    private JComboBox yearsSelector;
    private String type;

    public ComboBoxCarSelector(JComboBox brandSelector, JComboBox modelSelector, JComboBox yearsSelector, String type)
    {
        this.brandSelector = brandSelector;
        this.modelSelector = modelSelector;
        this.yearsSelector = yearsSelector;
        this.type = type;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == 2)
            return;

        this.update();
    }

    public void update()
    {
        switch(type)
        {
            case "brand":
                String brand = this.brandSelector.getSelectedItem().toString();
                this.modelSelector.removeAllItems();
                for(String models : VehicleManager.getInstance().getModels(brand))
                {
                    this.modelSelector.addItem(models);
                }

                String firstModel = VehicleManager.getInstance().getModels(brand).get(0);
                this.yearsSelector.removeAllItems();

                for(Integer years : VehicleManager.getInstance().getYears(brand,firstModel ))
                {
                    this.yearsSelector.addItem(years);
                }
                break;
            case "model":
                String model = this.modelSelector.getSelectedItem().toString();
                this.yearsSelector.removeAllItems();

                for(Integer years : VehicleManager.getInstance().getYears(this.brandSelector.getSelectedItem().toString(),model ))
                {
                    this.yearsSelector.addItem(years);
                }
                break;
            default:
                break;
        }
    }
}
