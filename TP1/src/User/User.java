package User;

import Vehicule.Vehicle;

import java.util.ArrayList;

public class User
{

    private UserBasicData userBasicData = null;
    private Vehicle vehicle;
    private boolean containSpecialConditions = false;
    private boolean isAlreadyCustomer = false;

    public User(UserBasicData userBasicData)
    {
        this.userBasicData = userBasicData;
    }


    /*#########################
        SETTERS
     #########################*/
    public void setSpecialConditions(boolean containSpecialConditions)
    {
        this.containSpecialConditions = containSpecialConditions;
    }

    public void setVehicle(Vehicle v)
    {
        this.vehicle = v;
        if(v.getValue() >= 100000)
            this.containSpecialConditions = true;
    }

    public void setIsCustomer(boolean isAlreadyCustomer)
    {
        this.isAlreadyCustomer = isAlreadyCustomer;
    }

    /*#########################
        GETTERS
     #########################*/
    public UserBasicData getUserBasicData()
    {
        return this.userBasicData;
    }

    public boolean hasSpecialConditions() {return containSpecialConditions;}

    public Vehicle getVehicle()
    {
        return this.vehicle;
    }

    public boolean isAlreadyCustomer() {
       return  this.isAlreadyCustomer;
    }

}

