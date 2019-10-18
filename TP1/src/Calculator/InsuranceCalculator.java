package Calculator;

import User.User;
import User.UserBasicData;

import java.io.File;
import java.util.Calendar;

import static java.lang.Math.floor;
import static java.lang.Math.round;

public class InsuranceCalculator
{

    /**
     * Main method to calculate the insurance price of a User
     * @param user User that is applying for the price
     * @return Amount of the insurance
     */
    public static double getInsurancePrice(User user)
    {
        if(!checkUser(user)) {
            System.out.println("CHECK USER"); // Error message, something went wrong woops
            return 0;
        }

        double finalPrice = 0;
        double basePrice = 0;
        double adjusments= 0;

        basePrice = addAgeBasedPrice(user);                           //Based price based on the user's age
        finalPrice += basePrice;
        finalPrice += (basePrice * addSexPrice(user));                // Add price based on user's sex
        finalPrice += (basePrice * addSpecialConditionPrice(user));   // Add price based on special conditions the user might have
        finalPrice += addVehiculeKilometerPrice(user);                // Add price based on the kilometers the user planned to do per year
        finalPrice += addVehicleYearPrice(user);                      // Add price based on the vehicle's age
        finalPrice += addExperienceDriverPrice(user);                 // Add price based on the user experience

        adjusments += (finalPrice * addAntiTheftDiscount(user));      //Add price based on the stealing protections the user might have.
        adjusments += (finalPrice * addInfractionsPrice(user));       // Add a penalty fee based on the infractions the user might have done.
        adjusments += (finalPrice * addIsAlreadyCustomerPrice(user)); // Add a discount if the user is already a customer.
        finalPrice += adjusments;
        return (double)round(finalPrice * 1000)/1000;
    }

    /**
     * Fills out the submission with the user data. And export it to a txt file.
     * @param user User object that contains the data.
     * @param amount Already calculated amount of the insurance
     */
    public static void generateData(User user, double amount)
    {
        String fileName = "soumission";
        int i = 0;
        File file;
        do{
            file = new File(fileName + String.valueOf(i) + ".txt");
            i++;
        } while(file.exists());

        user.toFile(file.getName(), amount);


    }

    /**
     * Check if the user has all the required information to proceed the calculation of the insurance.
     * In the case he doesn't meet the requirements, a message would be send to the console. Only the developer should
     * notice these error message since they should not happen during a normal execution of the program.
     * @param user User to check the data.
     * @return Should return true if everything goes well. Other wise, see with the developer.
     */
    private static boolean checkUser(User user)
    {
        if(user.getUserBasicData() != null && user.getVehicle() != null)
        {
            if(user.getUserBasicData().isCompleted())
            {
                return true;
            }
            else
            {
                System.out.println("Basic user data is not completer :/");
                return false;
            }
        }
        else
        {
            System.out.println("User no Basic DATA OR Vehicle!");
            return false;
        }
    }

    /**
     * Based cost of insurance depending of the users current age.
     *
     * @param user User object
     * @return Base cost
     */
    private static double addAgeBasedPrice(User user)
    {
        int age = user.getUserBasicData().getAge();

        if(age <= 20)
            return 500;
        else if(age <= 25)
            return 450;
        else if(age <= 30)
            return 400;
        else if(age <= 40)
            return 350;
        else if(age <= 50)
            return 300;
        else if(age <= 60)
            return 250;
        else if(age <= 70)
            return 200;
        else
            return 100;
    }

    /**
     * Add an extra 15% to the base cost if the customer is a boy
     * @param user User to check Data
     * @return Extra % cost
     */
    private static double addSexPrice(User user)
    {
        return (user.getUserBasicData().getSex() == UserBasicData.Sex.HOMME) ? 0.15 : 0;
    }

    /**
     * Add a extra cost if the user has a special condition.
     *
     * @param user User, to check the conditions
     * @return % to add from the base cost
     */
    private static double addSpecialConditionPrice(User user)
    {
        return (user.hasSpecialConditions()) ? 0.3 : 0;
    }

    /**
     * Add extra cost depending if vehicle is newer
     *
     * @param user User to check data
     * @return Extra cost
     */
    private static double addVehicleYearPrice(User user)
    {
        int year = Calendar.getInstance().get(Calendar.YEAR);

        int diff = year - user.getVehicle().getYear();

        double offValue = 0.1 - (0.02 * diff);

        offValue *= user.getVehicle().getValue();

        return (offValue <0) ? 0 : offValue;
    }

    /**
     * Add discount if the user has experience as a driver
     *
     * @param user User to check data
     * @return Discount
     */
    private static double addExperienceDriverPrice(User user)
    {
        int diff = user.getUserBasicData().getAge() - user.getUserBasicData().getAgeOfDriverLicence();
        double discount = floor(diff/5) * -0.05;
        return (diff <= -0.5) ? diff : -0.5;
    }

    /**
     * Add extra cost if user doesn't have a good behavior
     *
     * @param user User
     * @return Penality %
     */
    private static double addInfractionsPrice(User user)
    {
        return (0.15 * user.getUserBasicData().getNumberOfInfractions());
    }

    /**
     * Add a 20% discount if the user is already a customer of the company
     *
     * @param user User to check the data
     * @return the discount
     */
    private static double addIsAlreadyCustomerPrice(User user)
    {
        return (user.isAlreadyCustomer()) ? -0.20 : 0;
    }

    /**
     * Add the kilometer price on the vehicule.
     * Basically, over 15 000 kim, you add 10% of the car's value for each additional 5000 km over 15 000km.
     *
     * @param user The car's user
     * @return amount to add to total cost.
     */
    private static double addVehiculeKilometerPrice(User user)
    {
        return (user.getUserBasicData().getKilometersPerYears() >= 15000) ? floor((user.getUserBasicData().getKilometersPerYears() - 15000f) / 5000f) * 0.1 * user.getVehicle().getValue() : 0;
    }

    /**
     * Add a 5% discount for every anti-theft system installed.
     * @param user The car's user
     * @return The discount.
     */
    private static double addAntiTheftDiscount(User user)
    {
        return -.05 * user.getVehicle().getInstalledSystems().size();
    }

}
