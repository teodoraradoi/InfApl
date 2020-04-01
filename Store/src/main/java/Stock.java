import java.util.*;

public class Stock
{
   private List<StockItem> stockItems = new ArrayList<>();
    
   
   public List<StockItem> getStockItems()
   {
       return this.stockItems;
   }
   
   public void addProduct(Product product, int quantity)
   {
       StockItem stockItem = new StockItem();
       stockItem.setStockItem(product, quantity);
       stockItems.add(stockItem);
   }
   
   public void updateProductPrice(Product product, double price)
   {
       for(int i = 0; i < stockItems.size(); i++)
       {
           if(stockItems.get(i).getName().equals(product.getName()))
           {
              stockItems.get(i).setPrice(price);
           }
           break;
       }
   }
   
   public void printStockItems()
   {
       for(int i = 0; i < stockItems.size(); i++)
       {
           System.out.println("Name - Description - Price - Quantity");
           System.out.print(stockItems.get(i).getName()+ " ");
           System.out.print(stockItems.get(i).getDescription() + " ");
           System.out.print(stockItems.get(i).getPrice() + " ");
           System.out.println(stockItems.get(i).getQuantity()); 
       }
   }
}
