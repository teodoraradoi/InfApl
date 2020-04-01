public class EmployeeInfo
{
    protected String name;
    protected String phoneNo;
    protected String adress;
    
    
    public void setEmployeeInfo(String _name, String _phoneNo, String _adress)
    {
        this.name = _name;
        this.phoneNo = _phoneNo;
        this.adress = _adress;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getPhoneNo()
    {
        return phoneNo;
    }
    
    public String getAdress()
    {
        return adress;
    }    
}
