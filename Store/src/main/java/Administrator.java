public class Administrator extends EmployeeInfo
{   
    public Administrator(String name, String phoneNo, String adress)
    {
        this.name = name;
        this.phoneNo = phoneNo;
        this.adress = adress;
    }
    
    public void addProductsToStock(Stock stock, Product product, int quantity)
    {
        stock.addProduct(product, quantity);
    }
    
    public int checkProductsStock(Stock stock, Product product)
    {
        int aux = 0;
        for(int i = 0; i < stock.getStockItems().size(); i++)
        {
            String aux1 = stock.getStockItems().get(i).getName();
            String aux2 = product.getName();
            if(aux1.equals(aux2))
            {
                aux = stock.getStockItems().get(i).getQuantity();
                break;
            }
        }
        return aux;
    }
    
    public void removeProductsFromStock(Stock stock, StockItem product)
    {
        for(int i = 0; i < stock.getStockItems().size(); i++)
        {
            if(stock.getStockItems().get(i).getName().equals(product.getName()))
            {
                stock.getStockItems().remove(product);
            }
        }
    }
    
    public void modifyStock(Stock stock, Product product, int quantity)
    {
        for(int i = 0; i < stock.getStockItems().size(); i++)
        {
            String aux1 = stock.getStockItems().get(i).getName();
            String aux2 = product.getName();
            if(aux1.equals(aux2))
            {
                int aux = stock.getStockItems().get(i).getQuantity() + quantity;
                stock.getStockItems().get(i).setQuantity(aux);
                break;
            }
        }
    }
}
