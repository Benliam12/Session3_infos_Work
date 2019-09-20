import User.User;
import User.UserBasicData;

import java.util.Calendar;
import java.util.Map;

import static java.lang.Math.floor;
import static java.lang.Math.round;

public class InsuranceCalculator
{

    public static double getInsurancePrice(User user)
    {
        if(!checkUser(user)) {
            System.out.println("CHECK USER");
            return 0;
        }

        double finalPrice = 0;
        double basePrice = 0;
        double adjusments= 0;

        basePrice = addAgeBasedPrice(user);

        finalPrice += basePrice;
        finalPrice += (basePrice * addSexPrice(user));
        finalPrice += (basePrice * addSpecialConditionPrice(user));
        finalPrice += addVehiculeKilometerPrice(user);
        finalPrice += addVehicleYearPrice(user);
        finalPrice += addExperienceDriverPrice(user);

        adjusments += (finalPrice * addInfractionsPrice(user));
        adjusments += (finalPrice * addIsAlreadyCustomerPrice(user));

        finalPrice += adjusments;
        return (double)round(finalPrice * 1000)/1000;
    }

    private static boolean checkUser(User user)
    {
        if(user.getUserBasicData() != null && user.getVehicle() != null)
        {
            return (user.getUserBasicData().isCompleted());
        }
        else
        {
            System.out.println("User not Basic DATA OR Vehicle!");
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
        return (user.getSpecialConditionsSpeciales().size() > 0) ? 0.3 : 0;
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

}
