public class StockItem extends Product
{
    private Product product;
    private int quantity;
    
    
    public void setStockItem(Product _product, int _quantity)
    {
        this.setProduct(_product.getName(), _product.getDescription(), _product.getPrice());
    }
    
    public void setQuantity( int _quantity)
    {
        this.quantity = _quantity;
    }
    
    public Product getProduct()
    {
        return product;
    }
    
    public String getStockItemName()
    {
        return this.getName();
    }
    
    public double getStockItemPrice()
    {
        return this.getPrice();
    }
    
       public int getQuantity()
    {
        return quantity;
    }
    
   public void updateAfterSell(Receipt receipt, Stock stock, int i)
   {
       stock.getStockItems().get(i).quantity -= receipt.getReceiptItems().get(i).getQuanity();
   }
    
}
