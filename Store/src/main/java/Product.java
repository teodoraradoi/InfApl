import java.util.*;

public class Product
{
    private String name;
    private String description;
    private double price;
    
    
    public void setProduct(String _name, String _description, double _price)
    {
        this.name = _name;
        this.description = _description;
        this.price = _price; 
    }
    
    public void setName(String _name)
    {
        this.name = _name;
    }
    
    public void setPrice(double _price)
    {
        this.price = _price;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public double getPrice()
    {
        return price;
    }
    
}
