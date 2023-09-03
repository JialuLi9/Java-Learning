public class Store {
    public static final int MAX_CUSTOMERS = 500;
    private String name;
    private Customer[] customers;
    private int customerCount;
    private static int LAST_ID = 100000;
    public Store(String n) {
        name = n;
        customers = new Customer[MAX_CUSTOMERS];
        customerCount = 0;
    }
    public void addCustomer(Customer c) {
        if (customerCount < MAX_CUSTOMERS)
            customers[customerCount++] = c;
        c.setReward(LAST_ID++);
    }
    public void listCustomers() {
        for (int i=0; i<customerCount; i++)
            System.out.println(customers[i]);
    }
    public int averageCustomerAge(){
        int sum=0;
        for (int i=0; i<customerCount; i++){
            sum += customers[i].getAge();
        }

        return (int)(sum/customerCount);
    }
    public Customer richestCustomer(){
        Customer richest_one = customers[0];
        for (int i=0; i<customerCount; i++){
            /*if (customers[i].money>richest_one.money){
                richest_one = customers[i];
            }*/
            if (customers[i].hasMoreMoneyThan(richest_one)){
                richest_one = customers[i];
            }
        }
        return richest_one;
    }

    /*public void rob(Customer c){
        c.money = 0;
    }*/
}
