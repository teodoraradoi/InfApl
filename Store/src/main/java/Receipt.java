import java.util.*;

public class Receipt
{
    private List<ReceiptItem> recieptItems = new ArrayList<>();
    
    
    public List<ReceiptItem> getReceiptItems()
   {
       return recieptItems;
   }
    
    public double getTotal()
   {
        double total = 0;
        total = total + this.getTotalForProduct();
        return total;
   }
    
    public double getTotalForProduct()
   {
        double sum = 0;
        for(int i = 0; i < recieptItems.size(); i++)
        {
            sum = 0;
            sum = recieptItems.get(i).getPricePerUnit() * recieptItems.get(i).getQuanity();
            recieptItems.get(i).setTotal(sum);
        }
        
        return sum;
   }   
}
