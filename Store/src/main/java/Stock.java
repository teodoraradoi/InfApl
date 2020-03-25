import java.util.*; 

public class Stock extends Product
{
    public List<Product> products = new ArrayList<>();
    
      public void createStock()
    {
       products.add(new Product("banane", 1.20, 20));
       products.add(new Product("mere", 3, 10));
       products.add(new Product("cartofi", 4.90, 50));
       products.add(new Product("pere", 2.30, 10));
    }
      
    public void updateStock(Bill bill)
    {
        products.forEach((productInStock) ->
        {
            bill.billProducts.forEach((productsToSell) ->
            {
                if(productInStock.name.equals(productsToSell.name))
                {
                    productInStock.quantity -=productsToSell.quantity;
                }
            }
            );
        }
        );
    }
}
