import User.User;
import User.UserBasicData;
import Vehicule.Vehicle;

/**
 * Created by Benliam12 on 2019-09-19.
 */
public class Tester
{

    public static void main(String[] args)
    {
        UserBasicData basicData = new UserBasicData();

        basicData.setAddress("450 rue Poney")
                .setAge(41)
                .setFirstName("Jean")
                .setLastName("Marie")
                .setPhoneNumber("819-291-2019")
                .setMailAddress("patate@gmail.com")
                .setSex(UserBasicData.Sex.HOMME)
                .setKilometersPerYear(10000)
                .setAgeOfDriverLicence(17)
                .setNumberOfInfractions(1)
        ;
        User user = new User(basicData);


        //user.addSpecialCondition(User.SpecialConditions.THREE_OR_MORE_DRIVES);
        user.setIsCustomer(true);

        Vehicle v = new Vehicle("Model 3", "Tesla", 2018, 33103);

        user.setVehicle(v);

        double price = InsuranceCalculator.getInsurancePrice(user);

        System.out.printf("%s %.2f%s","The price is:",price,"$");
    }

}
