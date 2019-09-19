package User;

public class User
{

    private UserBasicData userBasicData = null;

    public User(UserBasicData userBasicData)
    {
        this.userBasicData = userBasicData;
    }

    public UserBasicData getUserBasicData()
    {
        return this.userBasicData;
    }

}

