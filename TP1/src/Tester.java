import User.User;
import User.UserBasicData;
import Vehicule.Vehicle;
import Vehicule.VehicleManager;

/**
 * Created by Benliam12 on 2019-09-19.
 */
public class Tester
{

    public static void main(String[] args)
    {
        UserBasicData basicData = new UserBasicData();

        basicData.setAddress("450 rue Poney")
                .setAge(18)
                .setFirstName("Jean")
                .setLastName("Marie")
                .setPhoneNumber("819-291-2019")
                .setMailAddress("patate@gmail.com")
                .setSex(UserBasicData.Sex.FEMME)
                .setKilometersPerYear(30000)
                .setAgeOfDriverLicence(16)
                .setNumberOfInfractions(0)
        ;
        User user = new User(basicData);


        user.setIsCustomer(true);
        user.setSpecialConditions(true);

        Vehicle v = new Vehicle("Tesla", "Model 3", 2013, 10000);
        v.addAntiTheftSystem(Vehicle.AntiTheftSystem.IMMOBILIZER);
        v.addAntiTheftSystem(Vehicle.AntiTheftSystem.TRACKING_ALARM_SYSTEM);

        user.setVehicle(v);

        double price = InsuranceCalculator.getInsurancePrice(user);

        System.out.printf("%s %.2f%s","The price is:",price,"$\n");

        VehicleManager vm = VehicleManager.getInstance();
        VehicleManager.getInstance().setup();


        System.out.println("Il y a " + vm.getModels("Tesla").size() + " models de Tesla");
        System.out.println("Il y a " + vm.getYears("Tesla", "Model 3").size() + " nombre d'années");
    }

}
