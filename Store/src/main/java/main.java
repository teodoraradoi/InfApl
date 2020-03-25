import java.util.Scanner;

public class main
{
    public static void main(String[] args)
    {
        Stock stock = new Stock();
        stock.createStock();
        boolean store = true;
        Employee seller = new Employee(1);
        Employee admin = new Employee(2);
        
        while (store)
        {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Enter the type of employee (1 - Seller 2 - Admin) or 0 - exit");
            int option = keyboard.nextInt();    
            switch(option)
            {
                case 1: // Seller
                {
                    Scanner in = new Scanner(System.in);
                    System.out.println("Enter the username and password");
                    String username = in.nextLine();
                    int password = keyboard.nextInt();
                    
                    if(username.equals(seller.username) && password == seller.password)
                    {
                        Bill bill = new Bill();
                        bill.toBuy(stock);
                        seller.payment(bill);
                        stock.updateStock(bill);
                    }
                    else
                    {
                        System.out.println("Wrong password!");
                    }
                    break;
                }

                case 2: // Admin
                {
                    Scanner in = new Scanner(System.in);
                    System.out.println("Enter the username and password");
                    String username = in.nextLine();
                    int password = keyboard.nextInt();
                    
                    if (username.equals(admin.username) && password == admin.password)
                    {
                        boolean adm = true;
                        while(adm)
                        {
                            System.out.println("Actions: 1. Update product 2. View stock 3. Change information of seller/ admin 4. Exit");
                            int action =  keyboard.nextInt();
                        
                            switch(action)
                            {
                                case 1: // Update product
                                {
                                    admin.viewStock(stock);
                                    System.out.println("Enter the name of the product you want to update: ");
                                    Scanner in1 = new Scanner(System.in);
                                    String name = in1.nextLine();
                                    admin.updateProduct(stock, name);
                                    break;
                                }

                                case 2: // View stock
                                {
                                    admin.viewStock(stock);
                                    break;
                                }

                                case 3: // Change info
                                {
                                    System.out.println("1 - to change the information of the seller 2 - to change the information of the admin");
                                    Scanner in1 = new Scanner(System.in);
                                    int opt = in1.nextInt();

                                    if(opt == 1)
                                    {
                                        seller.changeInfo();
                                    }
                                    
                                    if(opt == 2)
                                    {
                                        admin.changeInfo();
                                    }
                                    break;
                                }

                                case 4: // Exit
                                {
                                    adm = false;
                                    break;
                                }
                            }
                        }
                    }
                     else
                    {
                        System.out.println("Wrong password!");
                    }
                    break;
                }
                
                case 0: // Exit
                {
                    store = false;
                    break;
                }
            }
        }
    }
}
