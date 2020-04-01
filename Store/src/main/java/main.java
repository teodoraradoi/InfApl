import java.util.Scanner;

public class main
{
    public static void main(String[] args)
    {
        Store store = new Store();
        store.setName("Store");
        
        boolean app = true;
        while(app)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Admin 2. Seller 3. Exit");
            int choice= scanner.nextInt();
            
            switch(choice)
            {
                case 1: // Admin
                {
                    System.out.println("1. Create a new admin  2. Continue with an existing admin");
                    int choice1 = scanner.nextInt();
                    
                    if(choice1 == 1) // Creating a new admin
                    {
                        Scanner in1 = new Scanner(System.in);
                        System.out.println("Please enter the information for the new admin (name, phone number, adress)");
                        String aux1 = in1.nextLine();
                        String aux2 = in1.nextLine();
                        String aux3 = in1.nextLine();
                        
                        store.addNewAdministrator(aux1, aux2, aux3);
                    }
                    
                    if(choice1 == 2) // Continue with an existing admin
                    {
                        Scanner in0 = new Scanner(System.in);
                        System.out.println("Enter the name of the admin");
                        String name= in0.nextLine();
                        
                        for(int i = 0; i < store.getAdmins().size(); i++)
                        {
                            if(name.equals(store.getAdmins().get(i).getName()))
                            {
                                boolean choice2 = true;

                                while (choice2)
                                {
                                    Scanner in2 = new Scanner(System.in);
                                    System.out.println("1. Add a new product to stock  2. Check stock  3. Update price  0. Exit");
                                    int choice3 = in2.nextInt();
                                    Product product = new Product();
                                
                                    switch(choice3)
                                    {
                                        case 1: // Add a new product
                                        {
                                            product = new Product();
                                            Scanner in3 = new Scanner(System.in);
                                            System.out.println("Input the information about the product (name, description, price, quantity)");
                                            String aux1 = in3.nextLine();
                                            String aux2 = in3.nextLine();
                                            double aux3 = in3.nextDouble();
                                            int aux4 = in3.nextInt();
                                            
                                            product.setProduct(aux1, aux2, aux3);
                                            store.getStock().addProduct(product, aux4);
                                            break;
                                        }

                                        case 2: // Check stock
                                        {
                                            Scanner in3 = new Scanner(System.in);
                                            System.out.println("Input the name of the product you want to check");
                                            String aux_name = in3.nextLine();
                                            
                                             product = new Product();
                                             product.setName(aux_name);
                                            
                                             int aux = store.getAdmins().get(i).checkProductsStock(store.getStock(), product);
                                             System.out.println(product.getName() + ": " + aux + " left in stock");
                                             break;
                                        }

                                        case 3: // Update price
                                        {
                                            Scanner in3 = new Scanner(System.in);
                                            System.out.println("Input the name of the product");
                                            String aux_name = in3.nextLine();
                                            
                                            product = new Product();
                                            product.setName(aux_name);
                                            
                                            System.out.println("Input the name of the product");
                                            int aux_price = in3.nextInt();
                                            
                                            store.getStock().updateProductPrice(product, aux_price);
                                            System.out.println("price of " + product.getName() + ": " + store.getStock().getStockItems().get(0).getStockItemPrice());
                                            break;
                                        }
                                   
                                        case 0: // Exit
                                        {
                                            choice2 = false;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }

                    break;
                }
                
                case 2: // Seller
                {
                    System.out.println("1. Create a new seller  2. Continue with an existing seller");
                    int choice2 = scanner.nextInt();
                    
                    if(choice2 == 1) // Create a new seller
                    {
                        Scanner in1 = new Scanner(System.in);
                        System.out.println("Please enter the information for the new seller (name, description, price, quantity)");
                        String aux1 = in1.nextLine();
                        String aux2 = in1.nextLine();
                        String aux3 = in1.nextLine();
                        
                        store.addNewSeller(aux1, aux2, aux3);
                        store.addNewCashRegister("Store", "#356");
                    }
                    
                    if(choice2 == 2) // Continue with an existing seller
                    {
                        Scanner keyboard = new Scanner(System.in);
                        System.out.println("Enter the name of the seller");
                        String name= keyboard.nextLine();
                        
                        for(int i = 0; i < store.getSellers().size(); i++)
                        {
                            if(name.equals(store.getSellers().get(i).getName()))
                            {
                                // New sell
                                store.getStock().printStockItems();
                        
                                store.getSellers().get(i).sell(store.getCashRegister().get(i), store.getStock());
                            }
                        }
                    }
                    
                    break;
                }
                
                case 3: // Exit
                {
                    app = false;
                    break;
                }
            }
        }
    }
}