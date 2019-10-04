package Vehicule;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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

    private Connection connection;

    public void setup()
    {
            String host = "";
            String db = "";
            String user = "";
            String password = "";

            int port = 0;

            String url = "jdbc:mysql://"+host+":"+port+"/" + db;
            try
            {
                Connection c  = DriverManager.getConnection( url, user, password);
                return;
            }
            catch ( SQLException e )
            {
                return;
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }


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
