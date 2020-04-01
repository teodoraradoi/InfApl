import java.util.*;

public class CashRegister
{
    private int currentReceiptNo;
    private List<Receipt> receipts = new ArrayList<>();
    private String storeName;
    private String fiscalIdentifier;
    
    
    public CashRegister(String _storeName, String _fiscalIdentifier)
    {
        this.currentReceiptNo = 0;
        this.storeName = _storeName;
        this.fiscalIdentifier = _fiscalIdentifier;
    }
    
    public List<Receipt> getReceipts()
    {
        return receipts;
    }
    
    public int getCurrentReceiptNo()
    {
        return currentReceiptNo;
    }
    
    public void startNewSell()
    {
        receipts.add(new Receipt());
    }
    
    public void registerNewProduct(String name, int quantity, Stock stock)
    {
        ReceiptItem item = new ReceiptItem();
        item.setProductName(name);
        item.setQuanity(quantity);
        
        for(int i = 0; i < stock.getStockItems().size(); i++)
        {
            String aux1 = stock.getStockItems().get(i).getStockItemName();
            String aux2 = item.getProductName();
            if(aux1.equals(aux2))
            {
                item.setPricePerUnit(stock.getStockItems().get(i).getPrice());
            }
        }
        receipts.get(getCurrentReceiptNo()).getReceiptItems().add(item);
    }

    public void finaliseSell(Receipt receipt, Stock stock)
    {
        currentReceiptNo++;
        for(int i = 0; i < stock.getStockItems().size(); i++)
        {
            for(int j = 0; j < receipt.getReceiptItems().size(); j++)
            {
                if(stock.getStockItems().get(i).getName().equals(receipt.getReceiptItems().get(j).getProductName()))
                    stock.getStockItems().get(i).updateAfterSell(receipt, stock, i);
            }
        }
        
        System.out.print("Total: ");
        System.out.println(receipt.getTotal());
    }
    
}
