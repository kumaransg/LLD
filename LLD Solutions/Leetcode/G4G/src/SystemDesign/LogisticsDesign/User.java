package SystemDesign.LogisticsDesign;

import java.util.List;
public class User {

    private int userId;
    private String name;
    private Location adress;
    private String mobNo;
    private String emailId;

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Location getAdress()
    {
        return adress;
    }

    public void setAdress(Location adress)
    {
        this.adress = adress;
    }

    public String getMobNo()
    {
        return mobNo;
    }

    public void setMobNo(String mobNo)
    {
        this.mobNo = mobNo;
    }

    public String getEmailId()
    {
        return emailId;
    }

    public void setEmailId(String emailId)
    {
        this.emailId = emailId;
    }
}
