package User;

public class UserBasicData
{

    protected String firstName;
    protected String lastName;
    protected String address;
    protected String mailAddress;
    protected String phoneNumber;
    protected int age;
    protected int ageOfDriverLicence;
    protected int kilometersPerYears;
    protected int numberOfInfractions = -1;
    protected Sex sex;


    public UserBasicData()
    {

    }

    /**
     * Check if everything has at least some values
     * @return result of the checker
     */
    public boolean isCompleted()
    {
        return (
                this.firstName           != null &&
                this.lastName            != null &&
                this.address             != null &&
                this.mailAddress         != null &&
                this.phoneNumber         != null &&
                this.ageOfDriverLicence  != 0    &&
                this.kilometersPerYears  != 0    &&
                this.age                 != 0    &&
                this.numberOfInfractions != -1   &&
                this.sex                 != null
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

    public int getAgeOfDriverLicence()
    {
        return this.ageOfDriverLicence;
    }

    public int getNumberOfInfractions() {
        return numberOfInfractions;
    }

    /*
    SETTERS
     */

    public UserBasicData setNumberOfInfractions(int numberOfInfractions)
    {
        this.numberOfInfractions = numberOfInfractions;
        return this;
    }

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

    public UserBasicData setAddress(String address)
    {
        this.address = address;
        return this;
    }

    public UserBasicData setMailAddress(String mailAddress)
    {
        this.mailAddress = mailAddress;
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

    public UserBasicData setAgeOfDriverLicence(int age)
    {
        this.ageOfDriverLicence = age;
        return this;
    }

    public UserBasicData setKilometersPerYear(int kilometersPerYear)
    {
        this.kilometersPerYears = kilometersPerYear;
        return this;
    }

    public enum Sex
    {
        HOMME,
        FEMME,
        NONE
    }

}
