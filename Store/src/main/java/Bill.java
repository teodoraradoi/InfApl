import java.util.*;

public class Bill
{
    public List<Product> billProducts = new ArrayList<>();
    private double totalPrice;
    
    public void toBuy(Stock stock)
    {
        System.out.println("We have:");
        for(int i = 0; i < stock.products.size(); i++)
        {
            System.out.println(stock.products.get(i).name + " (" + stock.products.get(i).price + " lei)");
        }
        
        boolean cont = true;
        Scanner keyboard = new Scanner(System.in);
        while(cont)
        {
            System.out.println("Enter the name of the product you want to buy");
            Scanner in = new Scanner(System.in);
            String  name = in.nextLine();
            
            for(int i = 0; i < stock.products.size(); i++)
            {
                if(stock.products.get(i).name.equals(name))
                {
                    System.out.println("Enter the quantity");
                    int  quantity = in.nextInt();
                    while (stock.products.get(i).quantity < quantity)
                    {
                        System.out.println("We don't have enough. Enter new quantity");
                        quantity = in.nextInt();
                    }
                        double price = stock.products.get(i).price;
                        billProducts.add(new Product(name, price, quantity));
                        System.out.println("Product added!");
                        break; 
                }
            }

            System.out.println("Continue? 1. Yes 2. No");
            int opt = keyboard.nextInt();
            if(opt == 2)
            {
                cont = false;
            }
        }
    }
    
    public double getPrice()
   {
        billProducts.forEach((product)->
        {
            totalPrice += product.price * product.quantity;
        });
        
        double aux = totalPrice;
        this.totalPrice = 0;
        return aux;
   }
}