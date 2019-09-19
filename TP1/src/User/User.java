package User;

import Vehicule.Vehicule;

import java.util.ArrayList;

public class User
{

    private UserBasicData userBasicData = null;
    private Vehicule vehicule;
    private ArrayList<SpecialConditions> specialConditionsSpeciales = new ArrayList<>();

    public User(UserBasicData userBasicData)
    {
        this.userBasicData = userBasicData;
    }


    /*#########################
        SETTERS
     #########################*/

    public User addConditionSpeciale(SpecialConditions specialConditions)
    {
        if(!this.specialConditionsSpeciales.contains(specialConditions))
            this.specialConditionsSpeciales.add(specialConditions);

        return this;
    }

    public User setConditionSpeciales(ArrayList<SpecialConditions> conditionSpeciales)
    {
        this.specialConditionsSpeciales = conditionSpeciales;
        return this;
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
        return this.specialConditionsSpeciales;
    }

    public Vehicule getVehicule()
    {
        return this.vehicule;
    }


    public enum SpecialConditions
    {

        THREE_OR_MORE_DRIVES("3 conducteurs ou plus par véhicule"),
        SUSPENDED_IN_THE_LAST_THREE_YEARS("  ");


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

