import java.util.Scanner;

public class Seller extends EmployeeInfo
{
    public Seller(String name, String phoneNo, String adress)
    {
        this.name = name;
        this.phoneNo = phoneNo;
        this.adress = adress;
    }
    
    public int checkProductStock(Stock stock, String name, int quantity)
    {
        int num = -1;
        for(int i = 0; i < stock.getStockItems().size(); i++)
        {
            String aux = stock.getStockItems().get(0).getName();
            if(aux.equals(name))
            {
                if(stock.getStockItems().get(i).getQuantity() >= quantity)
                {
                    num = stock.getStockItems().get(i).getQuantity();
                }
            }
        }
        return num;
    }
    
    public void sell(CashRegister register, Stock stock)
    {
        register.startNewSell();
  
        boolean selling = true;
        while(selling)
        {
            System.out.println("1. Buy a product  2. Finish");
            Scanner in = new Scanner(System.in);
            int choice = in.nextInt();
            
           if(choice == 1)
           {
                Scanner in1 = new Scanner(System.in);
                System.out.println("Input the name of the product you want to buy");
                String _name= in1.nextLine();
                    
                Scanner in2 = new Scanner(System.in);
                System.out.println("Input the quantity");
                int _quantity =in2.nextInt();

                if(this.checkProductStock(stock, _name, _quantity) > 0)
                {
                    register.registerNewProduct(_name, _quantity, stock);
                }
                else
                {
                    System.out.println("We don't have that product.");
                }
            }
                
            if(choice == 2)
            {
                System.out.print("Receipt ID: ");
                System.out.println(register.getCurrentReceiptNo() + 1);
        
                register.finaliseSell(register.getReceipts().get(register.getCurrentReceiptNo()), stock);
                selling = false;
            }
        } 
    }
}
