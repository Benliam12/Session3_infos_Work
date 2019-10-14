package User;

import Vehicule.Vehicle;

import java.util.ArrayList;

/**
 * Main user class that is used to calculate the insurance price.
 */
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

    /**
     * Reset the userBasicData of the user.
     * @param userBasicData new userBasicData to set.
     */
    public void setUserBasicData(UserBasicData userBasicData)
    {
        this.userBasicData = userBasicData;
    }

    /**
     * Set if if the user has specialConditions
     * @param containSpecialConditions True/False.
     */
    public void setSpecialConditions(boolean containSpecialConditions)
    {
        this.containSpecialConditions = containSpecialConditions;
    }

    /**
     * Set the user's vehicle. The one that will be used to calculate his insurance price.
     * @param v Vehicle object.
     */
    public void setVehicle(Vehicle v)
    {
        this.vehicle = v;
        if(v.getValue() >= 100000)
            this.containSpecialConditions = true;
    }

    /**
     * Set if the customer is already client with the company. If he already has other insurance with it.
     * @param isAlreadyCustomer True / False
     */
    public void setIsCustomer(boolean isAlreadyCustomer)
    {
        this.isAlreadyCustomer = isAlreadyCustomer;
    }

    /*#########################
        GETTERS
     #########################*/

    /**
     * Returns the user's basic data that is linked to the object.
     * @return UserBasicData Object.
     */
    public UserBasicData getUserBasicData()
    {
        return this.userBasicData;
    }

    /**
     * Returns if the user has special conditions.
     * @return True / False
     */
    public boolean hasSpecialConditions() {return containSpecialConditions;}

    /**
     * Returns the user vehicle.
     * @return User's Vehicle Object / Null if the user doesnt has one set yet.
     */
    public Vehicle getVehicle()
    {
        return this.vehicle;
    }

    /**
     * Returns if the user is already a customer.
     * @return True / False.
     */
    public boolean isAlreadyCustomer() {
       return  this.isAlreadyCustomer;
    }



}

