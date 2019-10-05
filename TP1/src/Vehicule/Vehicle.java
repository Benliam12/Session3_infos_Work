package Vehicule;

import java.util.ArrayList;

public class Vehicle
{

    private double value;
    private int year;
    private String model;
    private String brand;

    private ArrayList<AntiTheftSystem> installedSystems = new ArrayList<>();


    public Vehicle(String brand, String model, int year, double value)
    {
        this.model = model;
        this.brand = brand;
        this.year = year;
        this.value = value;
    }

    public void setValue(double value)
    {
        this.value = value;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public void addAntiTheftSystem(AntiTheftSystem antiTheftSystem)
    {
        if(!this.installedSystems.contains(antiTheftSystem))
            this.installedSystems.add(antiTheftSystem);
    }

    public void removeAntiTheftSystem(AntiTheftSystem antiTheftSystem)
    {
        if(this.installedSystems.contains(antiTheftSystem))
            this.installedSystems.remove(antiTheftSystem);
    }

    public void setInstalledSystems(ArrayList<AntiTheftSystem> installedSystems)
    {
        this.installedSystems = installedSystems;
    }


    public double getValue()
    {
        return this.value;
    }

    public int getYear()
    {
        return this.year;
    }

    public String getModel()
    {
        return this.model;
    }

    public String getBrand()
    {
        return this.brand;
    }

    public ArrayList<AntiTheftSystem> getInstalledSystems()
    {
        return this.installedSystems;
    }

    public enum AntiTheftSystem
    {
        SOUIND_ALARM("Alarme sonore"),
        IMMOBILIZER("Antidémarreur"),
        OTHER("Autre"),
        TRACKING_ALARM_SYSTEM("Système d'alarme de repérage"),
        INTENSIVE_ANTI_THEFT_MARKING("Marquage intensif antivol");

        String value;

        AntiTheftSystem(String value)
        {
            this.value = value;
        }

        @Override
        public String toString()
        {
            return this.value;
        }
    }
}
