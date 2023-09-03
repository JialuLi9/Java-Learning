import java.util.Scanner;
public class ElectronicStoreTester {

    public static void main(String[] args) {

        ElectronicStore store = new ElectronicStore("Forever");
        store.printStock();
        boolean flag = true;
        while (flag){
            System.out.print("Enter a term to search for: ");
            String term  = new Scanner(System.in).nextLine();
            if (term.toLowerCase().equals("quit")){
                flag = false;

            }else{
                boolean result = store.searchStock(term);
                if (result == true){
                    System.out.println("A matching item is contained in the store's stock.");

                }else{
                    System.out.println("No items in the store match that term.");
                }
            }

        }
    }
}
