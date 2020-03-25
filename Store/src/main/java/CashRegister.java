public class CashRegister extends Bill
{
    private int billID;

    public CashRegister()
    {
        this.billID = 0;
    }
    
    public void payment(Bill bill)
    {
        billID++;
        double price = bill.getPrice();
        System.out.println("Bill ID: " + billID);
        System.out.printf("%.2f lei\n", price); 
    }
}
