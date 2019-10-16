package User;

public class UserBasicData
{

    protected String firstName;
    protected String lastName;
    protected String address;
    protected String emailAddress;
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
                this.emailAddress         != null &&
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

    /**
     * Returns the user's first name
     * @return user's first name
     */
    public String getFirstName()
    {
        return this.firstName;
    }

    /**
     * Returns the user's last name
     * @return user's last name
     */
    public String getLastName()
    {
        return this.lastName;
    }

    /**
     * Returns user's email
     * @return user's email
     */
    public String getEmail()
    {
        return this.emailAddress;
    }

    /**
     * Returns the user's age.
     * @return user's age.
     */
    public int getAge()
    {
        return this.age;
    }

    /**
     * Returns user's sex.
     * @return user's sex.
     */
    public Sex getSex()
    {
        return this.sex;
    }

    /**
     * Returns the amount of kilometers the user does in a single year.
     * @return amount of kilometers.
     */
    public int getKilometersPerYears()
    {
        return this.kilometersPerYears;
    }

    /**
     * Returns the age of when the driver got his driver licence.
     * @return age of getting the licence.
     */
    public int getAgeOfDriverLicence()
    {
        return this.ageOfDriverLicence;
    }

    /**
     * Returns the amount of infractions the user has done in the last 3 years.
     * @return Amount of infractions
     */
    public int getNumberOfInfractions() {
        return numberOfInfractions;
    }

    /*
    SETTERS
     */

    /**
     * Set the amount of infractions.
     * @param numberOfInfractions amount of infractions
     * @return current Object.
     */
    public UserBasicData setNumberOfInfractions(int numberOfInfractions)
    {
        this.numberOfInfractions = numberOfInfractions;
        return this;
    }

    /**
     * Set the first name
     * @param firstName first name
     * @return current Object.
     */
    public UserBasicData setFirstName(String firstName)
    {
        this.firstName = firstName;
        return this;
    }

    /**
     * Set the last name
     * @param lastName last name
     * @return current Object
     */
    public UserBasicData setLastName(String lastName)
    {
        this.lastName = lastName;
        return this;
    }

    /**
     * Set the address
     * @param address address
     * @return current Object.
     */
    public UserBasicData setAddress(String address)
    {
        this.address = address;
        return this;
    }

    /**
     * Set the email.
     * @param emailAddress email
     * @return current Object
     */
    public UserBasicData setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
        return this;
    }

    /**
     * Set the phoneNumber
     * @param phoneNumber phone number
     * @return current Object
     */
    public UserBasicData setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
        return this;
    }

    /**
     * Set the age
     * @param age age
     * @return current Object
     */
    public UserBasicData setAge(int age)
    {
        this.age = age;
        return this;
    }

    /**
     * Return the Sex.
     * @param sex sex
     * @return current Object
     */
    public UserBasicData setSex(Sex sex)
    {
        this.sex = sex;
        return this;
    }

    /**
     * Return age of getting licence.
     * @param age age of getting licence
     * @return current Object
     */
    public UserBasicData setAgeOfDriverLicence(int age)
    {
        this.ageOfDriverLicence = age;
        return this;
    }

    /**
     * Returns kilometers per year
     * @param kilometersPerYear kilometers per year
     * @return current Object
     */
    public UserBasicData setKilometersPerYear(int kilometersPerYear)
    {
        this.kilometersPerYears = kilometersPerYear;
        return this;
    }

    /**
     * Sex selector with 3 options.
     */
    public enum Sex
    {
        HOMME,
        FEMME,
        NONE
    }

}
