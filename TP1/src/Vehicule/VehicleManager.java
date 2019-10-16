package Vehicule;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;

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

    /**
     * Set up the data that are stored in the database file in order to load up the available cars.
     */
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

    /**
     * Returns the available brands to pick
     * @return available brands / null if none
     */
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

    /**
     * Return all the models for a specific brand
     * @param brand brand
     * @return available models / null if none
     */
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

    /**
     * Returns all the years for a specific model.
     * @param brand car's brand
     * @param model model
     * @return available years / null if none
     */
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

    /**
     * Get a specific vehicle.
     * @param brand vehicle's brand
     * @param model vehicle's model
     * @param year vehicle's year
     * @return Vehicle Object / null if not found.
     */
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
