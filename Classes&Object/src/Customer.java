public class Customer {
    String name;
    int age;
    float money;
    boolean admitted;


    public Customer(String initName){
        name = initName;
        age = 0;
        money = 0.0f;
        admitted = false;
    }

    public Customer(String initName, int initAge){
        name = initName;
        age = initAge;
        money = 0.0f;
        admitted = false;
    }

    public Customer(String initName, int initAge, float initMoney){
        name = initName;
        age = initAge;
        money = initMoney;
        admitted = false;
    }
    public Customer(){
        admitted = false;
    }

    public float computeFee() {
        final float discount = 0.5f;
        float fee = 0.0f;
        if (age<=3){
            fee = 0.0f;
        } else if (this.age>65){
            fee = 12.75f * discount;
        }else if (this.age <= 17){
            fee = 8.50f;
        } else{
            fee = 12.75f;
        }

        return fee;
    }

    public boolean spend(float amount){
        if (money >= amount){
            money -= amount;
            return true;
        }else{
            return false;
        }
    }

    public boolean hasMoreMoneyThan(Customer c) {
        return (this.money > c.money);
    }

    public void payAdmission(){
        admitted = spend(computeFee());
    }

    public String toString(){
        String result = String.format("Customer %s: a %d year old with $%.2f ",name, age, money);
        if (!admitted){
            result += String.format("who has not been admitted");
        }else{
            result += String.format("who has been admitted");
        }
        return result;
    }






}
