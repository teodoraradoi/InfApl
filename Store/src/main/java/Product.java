public class Product
{
    protected String name;
    protected int id;
    protected int quantity;
    protected double price;
    
    public Product(){}
    public Product(String name, double price, int quantity)
    {
        this.name = name;
        this.id++;
        this.quantity = quantity;
        this.price = price;
    }
}
