import java.io.*;
public class Customer {
    private String      name;
    private int         age; 
    private float       money;
    private int id;

    public Customer(String n, int a, float m) {
        name = n;
        age = a; 
        money = m;
        id = -1;
    }

    public Customer(String n, int a, float m, int i) {
        name = n;
        age = a;
        money = m;
        id = i;
    }


    public void setID(int newID){
      id = newID;
    }

    public String toString() {
        return "Customer " + name + ": a " + age + " year old with $" + money;
    }
    
    public String getName() { return name; }
    public int getAge(){return age;}
    public int getId() {return id;}

    public float getMoney() {return money;}

    public boolean hasMoreMoneyThan(Customer c) {
      return money > c.money;
    }

    public void saveTo(DataOutputStream aFile) throws IOException {
        aFile.writeUTF(name);
        aFile.writeInt(age);
        aFile.writeInt(id);
        aFile.writeFloat(money);

    }

    public static Customer readFrom(DataInputStream aFile) throws IOException {
            return new Customer(aFile.readUTF(), aFile.readInt(), aFile.readFloat(), aFile.readInt());
    }
}
