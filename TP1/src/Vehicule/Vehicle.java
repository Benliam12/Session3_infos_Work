package Vehicule;

public class Vehicle
{

    private double value;
    private int year;
    private String model;
    private String brand;


    public Vehicle(String model, String brand, int year, double value)
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
}
