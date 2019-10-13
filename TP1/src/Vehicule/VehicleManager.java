package Vehicule;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Benliam12 on 2019-09-19.
 */
public class VehicleManager
{

    private VehicleManager(){};
    private static final VehicleManager instance = new VehicleManager();
    public synchronized static VehicleManager getInstance() {
        return instance;
    }

    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    private String readJsonFile(String file) throws IOException, ParseException {
        InputStream in = getClass().getResourceAsStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        return reader.readLine();
    }

    public void setup()
    {
        try
        {

            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(readJsonFile("/carsData.json"));

            JSONArray mainArray = (JSONArray) jsonObject.get("cars");

            for(int i = 0; i<mainArray.size(); i++)
            {
                JSONObject object = (JSONObject) mainArray.get(i);

                String brand = (String) object.get("brand");
                String model = (String) object.get("model");
                Long year = (Long) object.get("year");
                Long value = (Long) object.get("value");

                this.vehicles.add(new Vehicle(brand, model, year.intValue(), value.doubleValue()));
            }
        } catch (IOException ex)
        {
            System.out.println("Can't load up cars");
        }
        catch (ParseException ex)
        {
            ex.printStackTrace();
        }
    }

    public ArrayList<String> getBrands()
    {
        ArrayList<String> returns = new ArrayList<>();

        for(Vehicle vehicle : this.vehicles)
        {
            if(!returns.contains(vehicle.getBrand()))
                returns.add(vehicle.getBrand());
        }

        return returns;
    }

    public ArrayList<String> getModels(String brand)
    {
        ArrayList<String> returns = new ArrayList<>();
        for(Vehicle vehicle : this.vehicles)
        {
            if(vehicle.getBrand().equalsIgnoreCase(brand))
                if(!returns.contains(vehicle.getModel()))
                    returns.add(vehicle.getModel());
        }
        return returns;
    }

    public ArrayList<Integer> getYears(String brand, String model)
    {
        ArrayList<Integer> returns = new ArrayList<>();
        for(Vehicle vehicle : this.vehicles)
        {
            if(vehicle.getBrand().equalsIgnoreCase(brand))
                if(vehicle.getModel().equalsIgnoreCase(model))
                    if(!returns.contains(vehicle.getYear()))
                        returns.add(vehicle.getYear());
        }
        return returns;
    }

    public Vehicle getVehicule(String brand, String model, int year)
    {
        for(Vehicle v: vehicles)
        {
            if(v.getBrand().equalsIgnoreCase(brand) && v.getModel().equalsIgnoreCase(model) && v.getYear() == year)
                return v;
        }
        return null;
    }

}
