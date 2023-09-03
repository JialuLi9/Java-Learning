public class CustomerTestProgram {
    public static void main(String arg[]){
        Customer c, c1;
        c = new Customer("Bob");
        c.name = "Bob";
        c.age = 27;
        c.money = 50;
        System.out.println(c.name);
        System.out.println(c.age);
        System.out.println(c.money);

        c1 = new Customer("Zoe");
        c1.name = "Zoe";
        c1.age = 20;
        c1.money = 100;
        System.out.println(c1.name);
        System.out.println(c1.age);
        System.out.println(c1.money);
    }
}

