import User.User;
import User.UserBasicData;

import static java.lang.Math.floor;

public class InsuranceCalculator
{

    public static double getInsurancePrice(User user)
    {
        if(!checkUser(user))
            return 0;

        double finalPrice = 0;
        double basePrice = 0;

        basePrice = addAgeBasedPrice(user);
        finalPrice += basePrice;
        finalPrice += (basePrice * addSexPrice(user));
        finalPrice += (basePrice * addSpecialConditionPrice(user));
        finalPrice += addVehiculeKilometerPrice(user);



        return finalPrice;
    }

    private static boolean checkUser(User user)
    {
        if(user.getUserBasicData() != null && user.getVehicule() != null)
        {
            return (user.getUserBasicData().isCompleted());
        }
        else
        {
            return false;
        }
    }

    public static double addAgeBasedPrice(User user)
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

    public static double addSexPrice(User user)
    {
        return (user.getUserBasicData().getSex() == UserBasicData.Sex.HOMME) ? 0.15 : 0;
    }

    public static double addSpecialConditionPrice(User user)
    {
        return (user.getSpecialConditionsSpeciales().size() == 0) ? 0.3 : 0;
    }

    

    public static double addVehiculeKilometerPrice(User user)
    {
        return (user.getUserBasicData().getKilometersPerYears() >= 15000) ? floor((user.getUserBasicData().getKilometersPerYears() - 15000f) / 5000f) * 0.1 * user.getVehicule().getValue() : 0;
    }

}
