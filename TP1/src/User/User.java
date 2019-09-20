package User;

import Vehicule.Vehicle;

import java.util.ArrayList;

public class User
{

    private UserBasicData userBasicData = null;
    private Vehicle vehicle;
    private ArrayList<SpecialConditions> specialConditions = new ArrayList<>();
    private boolean isAlreadyCustomer = false;

    public User(UserBasicData userBasicData)
    {
        this.userBasicData = userBasicData;
    }


    /*#########################
        SETTERS
     #########################*/
    public void setSpecialConditions(ArrayList<SpecialConditions> specialCondition)
    {
        this.specialConditions = specialCondition;
    }

    public void addSpecialCondition(SpecialConditions specialConditions)
    {
        if(!this.specialConditions.contains(specialConditions))
            this.specialConditions.add(specialConditions);
    }

    public void setVehicle(Vehicle v)
    {
        this.vehicle = v;
        if(v.getValue() >= 100000)
            this.addSpecialCondition(SpecialConditions.CAR_VALUE_HIGHER_THAN_100K);
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

    public ArrayList<SpecialConditions> getSpecialConditionsSpeciales()
    {
        return this.specialConditions;
    }

    public Vehicle getVehicle()
    {
        return this.vehicle;
    }

    public boolean isAlreadyCustomer() {
       return  this.isAlreadyCustomer;
    }

    public enum SpecialConditions
    {

        THREE_OR_MORE_DRIVES("3 conducteurs ou plus par véhicule"),
        SUSPENDED_IN_THE_LAST_THREE_YEARS("Suspension de permis dans les 3 dernières années"),
        CRIMINAL("L'existance d'un dossier criminel"),
        REFUSED_IN_LAST_FIVE_YEARS("Police d'assurance auto ou résidentielle résiliée/refusée dans les 5 dernières années"),
        APPRENDICE_DRIVE("Conducteur principal détient un permis d'apprenti"),
        CAR_VALUE_HIGHER_THAN_100K("Valeur de la voiture supérieur à 100 000$");

        private String value;

        SpecialConditions(String value)
        {
            this.value = value;
        }

        public String getValue()
        {
            return this.value;
        }
    }
}

