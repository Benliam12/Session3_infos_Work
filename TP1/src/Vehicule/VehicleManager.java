package Vehicule;

import java.util.ArrayList;

/**
 * Created by Benliam12 on 2019-09-19.
 */
public class VehicleManager
{

    private VehicleManager(){};
    private static VehicleManager instance = new VehicleManager();
    public static VehicleManager getInstance() {return instance;}

    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    public void setup()
    {
        //TODO : Read file containing informations about the differents vehicles
    }

    public Vehicle getVehicule(String brand)
    {
        for(Vehicle v: vehicles)
        {
            if(v.getBrand().equalsIgnoreCase(brand))
                return v;
        }
        return null;
    }

}
