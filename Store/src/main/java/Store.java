import java.util.*;

public class Store
{
    private String name;
    private Stock stock = new Stock();
    private List<CashRegister> cashRegisters = new ArrayList<>();
    private List<Seller> sellers = new ArrayList<>();
    private List<Administrator> admins = new ArrayList<>();
    
    
    public Stock getStock()
    {
        return stock;
    }
    
    public List<Seller> getSellers()
    {
        return sellers;
    }
    
    public List<Administrator> getAdmins()
    {
        return admins;
    }
    
    public List<CashRegister> getCashRegister()
    {
        return cashRegisters;
    }
    
    public void setName(String _name)
    {
        this.name = _name;
    }
    
    public void addNewCashRegister(String _storeName, String _fiscalIdentifier)
    {
        cashRegisters.add(new CashRegister(_storeName, _fiscalIdentifier));
    }
    
    public void addNewSeller(String name, String phoneNo, String adress)
    {
        sellers.add(new Seller(name, phoneNo, adress));
    }
    
    public void addNewAdministrator(String name, String phoneNo, String adress)
    {
        admins.add(new Administrator(name, phoneNo, adress));
    }
}
