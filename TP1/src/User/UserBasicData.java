package User;

public class UserBasicData
{

    protected String firstName;
    protected String lastName;
    protected int age;
    protected char sex;

    public UserBasicData()
    {

    }


    public UserBasicData setFirstName(String firstName)
    {
        this.firstName = firstName;
        return this;
    }

}
