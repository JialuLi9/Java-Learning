import java.util.Scanner;
public class ElectronicStore {
    String name;

    Desktop[] desktops = new Desktop[3];
    Laptop [] laptops = new Laptop[3];
    Fridge [] fridges = new Fridge[3];

    public ElectronicStore(String name){
        this.name = name;
        desktops[0] = new Desktop(3.5,8,500,true);
        desktops[1]  = new Desktop(2,4,300,false);
        desktops[2]  = new Desktop(4,5,600,true);
        laptops[0] = new Laptop(3.5,8,500,true,15);
        laptops[1] = new Laptop(2.5,6,400,false,12);
        laptops[2] = new Laptop(5,10,500,true,15);
        fridges[0] = new Fridge(500,true,"white");
        fridges[1] = new Fridge(800,true,"red");
        fridges[2] = new Fridge(300,false,"white");
    }

    public void printStock(){

        for (int i=0; i<this.desktops.length; i++){
            System.out.println(desktops[i].toString());
        }
        for (int i=0; i<laptops.length; i++){
            System.out.println(laptops[i].toString());
        }
        for (int i=0; i<fridges.length; i++){
            System.out.println(fridges[i].toString());
        }
    }

    public boolean searchStock(String keyWords) {

        String keyWord_lowercase = keyWords.toLowerCase();

        for (Desktop desktop: desktops){
            String desktop_output = desktop.toString().toLowerCase();

            if (desktop_output.indexOf(keyWord_lowercase) != -1){
                return true;
            }
        }

        for (Laptop laptop: laptops){
            String laptop_words = laptop.toString().toLowerCase();
            if (laptop_words.indexOf(keyWord_lowercase) != -1){
                return true;
            }
        }

        for (Fridge fridge: fridges){
            String fridge_words = fridge.toString().toLowerCase();
            if (fridge_words.indexOf(keyWord_lowercase) != -1){
                return true;
            }
        }
        return false;
    }

    /*public static void main(String[] args) {
        ElectronicStore store = new ElectronicStore("Forever");
        System.out.println(store.searchStock("tost"));
    }*/
}