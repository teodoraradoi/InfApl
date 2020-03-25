import java.util.Scanner;

public class Employee
{
    private int employeeType; // 1 - Seller 2 - Admin
    protected String username;
    protected int password;
    CashRegister register = new CashRegister();
    
    Employee(){}
    Employee(int type)
    {
        if(type == 1)
        {
            this.employeeType = 1;
            this.username = "seller";
            this.password = 1234;
        }
        else
        {
            this.employeeType = 2;
            this.username = "admin";
            this.password = 5678;
        }
    }
    
    public void payment(Bill bill)
    {
        register.payment(bill);
    }
    
    public void updateProduct(Stock stock, String name)
    {
        for (int counter = 0; counter < stock.products.size(); counter++)
        {
            if(stock.products.get(counter).name.equals(name))
            {
                Scanner keyboard = new Scanner(System.in);
                System.out.println("Enter 1 to change the price and 2 to change the quantity");
                int option = keyboard.nextInt();

                if (option == 1)
                {
                    System.out.println("The old price was " + stock.products.get(counter).price);
                    System.out.println("Enter the new price");
                    double price = keyboard.nextDouble();
                    stock.products.get(counter).price = price;
                }

                if (option == 2)
                {
                    System.out.println("The old quantity was " + stock.products.get(counter).quantity);
                    System.out.println("Enter the new quantity");
                    int quantity = keyboard.nextInt();
                    stock.products.get(counter).quantity = quantity;
                }
                    break;
            }
        }  
    }
  
    public void viewStock(Stock stock)
    {
        String name;
        int quantity;
        double price;
        
        System.out.println("Name - Quantity - Price");
        for(int i = 0; i < stock.products.size(); i++)
        {
            name = stock.products.get(i).name;
            quantity = stock.products.get(i).quantity;
            price = stock.products.get(i).price;
            System.out.println(name + " - " + quantity + " - " + price);
        }
    }
  
  public void changeInfo()
  {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("1 - username 2 - password");
    int option = keyboard.nextInt();
      
    if(option == 1)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the new username");
        String user = in.nextLine();
        this.username = user;
    }
      
    if(option == 2)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the new password");
        int pass = in.nextInt();
        this.password = pass;
    }
  }
}