import java.io.*;

public class CustomerTestProgram {
    public static void main(String args[]) {
        Customer c1 = new Customer("Amie", 14, 100);
        Customer c2 = new Customer("Brad", 15, 0);

        try {
            DataOutputStream out;
            out = new DataOutputStream(new FileOutputStream("customer1.txt"));
            c1.saveTo(out);
            out.close();
            out = new DataOutputStream(new FileOutputStream("customer2.txt"));
            c2.saveTo(out);
            out.close();
        } catch (FileNotFoundException e) {
            // Do Nothing
        } catch (IOException e) {
            // Do Nothing
        }

        try {
            DataInputStream in;
            in = new DataInputStream(new FileInputStream("customer1.txt"));
            System.out.println(Customer.readFrom(in));
            in.close();
            in = new DataInputStream(new FileInputStream("customer2.txt"));
            System.out.println(Customer.readFrom(in));
            in.close();
        } catch (FileNotFoundException e) {
            // Do Nothing
        } catch (IOException e) {
            // Do Nothing
        }


    }
}
