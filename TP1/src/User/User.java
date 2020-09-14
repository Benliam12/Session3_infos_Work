package User;

import Vehicule.Vehicle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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

    public void toFile(String filename, double price)
    {
        String data = "";

        try
        {
            FileWriter fileWriter = new FileWriter(filename);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            data += "[Information personnelles]\n";
            data += "Prénom: " + this.userBasicData.getFirstName() + "\n";
            data += "Nom : " + this.userBasicData.getLastName() + "\n";
            data += "Age : " + this.userBasicData.getAge()  + "\n";
            data += "Sexe: "+ this.userBasicData.getSex().toString() + "\n";
            data += "Email: " + this.userBasicData.getEmail() + "\n";
            data += "Adresse: "+ this.userBasicData.getAddress() + "\n";
            data += "Date de naissance:" + this.userBasicData.getDateOfBirth() + "\n";
            data += "Numéro de téléphone:" + this.userBasicData.getPhoneNumber() + "\n";
            data += "Possède une assurance avec la compagnie? : "+ ((this.isAlreadyCustomer) ? "Oui" : "Non") + "\n";

            data += "\n"; // Spacing

            data += "[Informations conduite]\n";
            data += "Kilmétrage annuel:" + String.valueOf(this.userBasicData.getKilometersPerYears()) + "\n";
            data += "Age d'obtention du permis de conduite:" + String.valueOf(this.userBasicData.getAgeOfDriverLicence()) + "\n";
            data += "Nombre d'infraction:" + String.valueOf(this.userBasicData.getNumberOfInfractions()) + "\n";

            data += "\n"; // Spacing

            data += "[Information Véhicule]\n";
            data += "Marque: " + this.vehicle.getBrand() + "\n";
            data += "Model: " + this.vehicle.getModel() + "\n";
            data += "Année: "+ this.vehicle.getYear() + "\n";
            data += "Valeur de référence: "+ this.vehicle.getValue() + "\n";
            data += "Systems anti vol installé: \n";

            if(this.vehicle.getInstalledSystems().size() == 0)
            {
                data += "Aucun\n";
            }
            else
            {
                for(Vehicle.AntiTheftSystem systems  : this.vehicle.getInstalledSystems())
                {
                    data += "- " + systems.toString() + "\n";
                }
            }

            data += "\n"; // Spacing

            data += "[Montant de l'assurance]\n";
            data += String.valueOf(price) + "$";

            bufferedWriter.write(data);

            bufferedWriter.close();
        } catch (IOException ex)
        {
            System.out.println("Impossible d'écrire la soumuissions!");
        }
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

