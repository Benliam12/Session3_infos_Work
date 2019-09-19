package User;

public class UserBasicData
{

    protected String firstName;
    protected String lastName;
    protected String adress;
    protected String mailAdress;
    protected String phoneNumber;
    protected int age;
    protected int kilometersPerYears;
    protected Sex sex;


    public UserBasicData()
    {

    }

    public boolean isCompleted()
    {
        return (
                this.firstName != null &&
                this.lastName != null &&
                this.adress != null &&
                this.mailAdress != null &&
                this.phoneNumber != null &&
                this.age != 0 &&
                this.sex != null
                );
    }

    /*
    GETTERS
     */

    public int getAge()
    {
        return this.age;
    }

    public Sex getSex()
    {
        return this.sex;
    }

    public int getKilometersPerYears()
    {
        return this.kilometersPerYears;
    }

    /*
    SETTERS
     */

    public UserBasicData setFirstName(String firstName)
    {
        this.firstName = firstName;
        return this;
    }

    public UserBasicData setLastName(String lastName)
    {
        this.lastName = lastName;
        return this;
    }

    public UserBasicData setAdress(String adress)
    {
        this.adress = adress;
        return this;
    }

    public UserBasicData setMailAdress(String mailAdress)
    {
        this.mailAdress = mailAdress;
        return this;
    }

    public UserBasicData setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public UserBasicData setAge(int age)
    {
        this.age = age;
        return this;
    }

    public UserBasicData setSex(Sex sex)
    {
        this.sex = sex;
        return this;
    }

    public enum Sex
    {
        HOMME,
        FEMME
    }

}
