package Vehicule;

import java.util.ArrayList;

/**
 * Contains the essential vehicle data.
 */
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

    /**
     * Set the car's value
     * @param value value in dollars
     */
    public void setValue(double value)
    {
        this.value = value;
    }

    /**
     * Set the car's brand
     * @param brand brand
     */
    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    /**
     * Set the car year of fabrication.
     * @param year year of fabrication.
     */
    public void setYear(int year)
    {
        this.year = year;
    }

    /**
     * Set the car's model
     * @param model model
     */
    public void setModel(String model)
    {
        this.model = model;
    }

    /**
     * Add an anti theft system
     * @param antiTheftSystem System to add to the list. If already there, it won't add it a second time.
     */
    public void addAntiTheftSystem(AntiTheftSystem antiTheftSystem)
    {
        if(!this.installedSystems.contains(antiTheftSystem))
            this.installedSystems.add(antiTheftSystem);
    }

    /**
     * Properly remove a specific anti theft system.
     * @param antiTheftSystem anti theft system to remove.
     */
    public void removeAntiTheftSystem(AntiTheftSystem antiTheftSystem)
    {
        if(this.installedSystems.contains(antiTheftSystem))
            this.installedSystems.remove(antiTheftSystem);
    }

    /**
     * Set the list of all installed anti theft system.
     * @param installedSystems List of anti theft system.
     */
    public void setInstalledSystems(ArrayList<AntiTheftSystem> installedSystems)
    {
        this.installedSystems = installedSystems;
    }


    /**
     * Get car's value
     * @return value
     */
    public double getValue()
    {
        return this.value;
    }

    /**
     * Get the car's year of fabrication
     * @return year of fabrication
     */
    public int getYear()
    {
        return this.year;
    }

    /**
     * Get the car's model
     * @return model
     */
    public String getModel()
    {
        return this.model;
    }

    /**
     * Get the car's brand
     * @return brand
     */
    public String getBrand()
    {
        return this.brand;
    }

    /**
     * Return the installed systems.
     * @return List of the installed anti theft system.
     */
    public ArrayList<AntiTheftSystem> getInstalledSystems()
    {
        return this.installedSystems;
    }

    /**
     * Anti theft system options for {@link Vehicle}
     */
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

        public static AntiTheftSystem getEnum(String value)
        {
            for(AntiTheftSystem v : values())
            {
                if(v.toString().equalsIgnoreCase(value))
                {
                    return v;
                }
            }
            return null;
        }
    }
}
