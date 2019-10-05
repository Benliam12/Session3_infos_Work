package Vehicule;

import javax.xml.transform.Result;
import java.sql.*;
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
        Connection connection = null;
           try
           {
                String url = "jdbc:sqlite:db.db";
                connection = DriverManager.getConnection(url);

                String querry = "SELECT * FROM cars";
                Statement statement = connection.createStatement();

                ResultSet results = statement.executeQuery(querry);

                while(results.next())
                {
                    String brand = results.getString("brand");
                    String model = results.getString("model");
                    int year = results.getInt("year");
                    int value = results.getInt("value");
                    this.vehicles.add(new Vehicle(brand, model, year, value));
                    //System.out.println(results.getString("brand") + " " + results.getString("model") + " " + results.getInt("value") + "$");
                }


               System.out.println("Good connextion!");

           } catch (Exception ex)
           {
               System.out.println("Cant connect ;(");
               ex.printStackTrace();
           }
           finally {
               try {
                   if(connection != null)
                       connection.close();;
               } catch(SQLException ex)
               {
                   System.out.println("Err closing DB");
               }
           }


        //TODO : Read file containing informations about the differents vehicles
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
