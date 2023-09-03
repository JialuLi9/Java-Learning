public class Customer {
    private String name;
    private int age;
    private float money;
    private int rewardsld;


    public Customer(String n, int a, float m) {
        name = n;
        age = a;
        money = m;
        rewardsld = -1;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public int getRewardsld() { return rewardsld; }

    public void setReward(int ID){
        rewardsld = ID;
    }

    public boolean hasMoreMoneyThan(Customer c){
        return this.money>c.money;
    }



    public String toString() {
        return "Customer " + name + ": a " + age + " year old with $" + money;
    }
}
